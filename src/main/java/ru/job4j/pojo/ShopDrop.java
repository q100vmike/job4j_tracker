package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[index] = products[index + 1];
            index++;
        }
        products[index] = null;
        return products;
    }
}
