package org.example;

import parcs.AMInfo;
import parcs.task;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParcsJob {
    public static void main(String[] args) {
        try {
            // Додайте цей блок для перевірки
            String serverFilePath = "out/server";
            String serverIP = Files.readString(Paths.get(serverFilePath)).trim();
            System.out.println("Server IP read from file: " + serverIP);

            // Створюємо завдання
            task curtask = new task();
            curtask.addJarFile("ShellSort.jar");
            AMInfo info = new AMInfo(curtask, null);
            (new ShellSort()).run(info);
            curtask.end();
        } catch (IOException e) {
            System.err.println("Error reading server file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
