package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private Item getItemFromRS(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime());
    }

    @Override
    public void clear() {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setString(2, String.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE items SET name = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(getItemFromRS(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(getItemFromRS(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = getItemFromRS(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}