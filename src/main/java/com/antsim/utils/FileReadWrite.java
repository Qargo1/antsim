package com.antsim.utils;
import java.io.*;
import java.util.ArrayList;

public class FileReadWrite {
    public static void main(String[] args) {
        // Создаём список покупок
        ArrayList<String> shoppingList = new ArrayList<>();
        shoppingList.add("Хлеб");
        shoppingList.add("Молоко");
        shoppingList.add("Яйца");

        // Записываем список в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("utils/shopping_list.txt"))) {
            for (String item : shoppingList) {
                writer.write(item);
                writer.newLine(); // Переход на новую строку
            }
            System.out.println("Список покупок записан в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Читаем список из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("utils/shopping_list.txt"))) {
            System.out.println("Список покупок из файла:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}