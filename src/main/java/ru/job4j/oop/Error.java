package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println("active= " + this.active);
        System.out.println("status= " + this.status);
        System.out.println("message= " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorOne = new Error(true, 2, "errorOne");
        Error errorTwo = new Error(false, 100, "errorTwo");
        Error errorThree = new Error(true, 777, "errorThree");

        errorOne.show();
        errorTwo.show();
        errorThree.show();
        error.show();
    }
}
