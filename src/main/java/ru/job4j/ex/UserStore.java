package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User fuser = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                fuser = user;
            }
        }
        if (null == fuser) {
            throw new UserNotFoundException("User Not Found");
        }
        return fuser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid User");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException nf) {
            nf.printStackTrace();
        } catch (UserNotFoundException ie) {
            ie.printStackTrace();
        }
    }
}
