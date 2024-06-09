package org.example;

import parcs.*;
import java.nio.file.*;
import java.io.IOException;

public class ParcsJob {
    public static void main(String[] args) {
        try {
            String serverFilePath = "out/server";
            String serverIP = Files.readString(Paths.get(serverFilePath)).trim();
            System.out.println("Server IP read from file: " + serverIP);

            // Створюємо завдання
            System.out.println("Creating task...");
            task curtask = new task();
            curtask.addJarFile("ShellSort.jar");
            AMInfo info = new AMInfo(curtask, null);
            System.out.println("Running ShellSort...");
            (new ShellSort()).run(info);
            curtask.end();
            System.out.println("Task ended.");
        } catch (IOException e) {
            System.err.println("Error reading server file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
