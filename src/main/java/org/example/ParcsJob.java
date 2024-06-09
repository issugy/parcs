package org.example;

import parcs.AMInfo;
import parcs.task;

public class ParcsJob {
    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("ShellSort.jar");
        AMInfo info = new AMInfo(curtask, null);
        (new ShellSort()).run(info);
        curtask.end();
    }
}
