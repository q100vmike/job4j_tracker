package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        while (index < products.length - 1) {
            products[index] = products[index + 1];
            index++;
        }
        products[index] = null;
        return products;
    }
}
