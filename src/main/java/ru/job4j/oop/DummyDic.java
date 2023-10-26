package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        String unknown;
        DummyDic  word = new DummyDic();
        unknown = word.engToRus("Unknown word.");
        System.out.println(unknown);
    }
}
