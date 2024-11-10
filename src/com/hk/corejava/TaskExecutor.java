package com.hk.corejava;

import java.util.concurrent.CompletableFuture;

public class TaskExecutor {

    public static void main(String[] args) {
        // Start taskA and taskB in parallel using CompletableFuture
        CompletableFuture<Void> taskAFuture = CompletableFuture.runAsync(TaskExecutor::taskA);

        // Once taskB is completed, start taskC with the result of taskB
        CompletableFuture<Void> taskBAndCFuture = CompletableFuture.supplyAsync(TaskExecutor::taskB).thenAccept(TaskExecutor::taskC);

        // Wait for both tasks to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(taskAFuture, taskBAndCFuture);
        allOf.join(); // This will block until both tasks are done
    }

    private static void taskA() {
        // Simulate some work with taskA
        try {
            System.out.println("Task A is started");
            Thread.sleep(5000);
            System.out.println("Task A is completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static String taskB() {
        // Simulate some work with taskB
        try {
            System.out.println("Task B is started");
            Thread.sleep(3000);
            System.out.println("Task B is completed");
            return "Task B is completed";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Task B failed";
        }
    }

    private static void taskC(String result) {
        try {
            System.out.println("Task C is started");
            Thread.sleep(2000);
            System.out.println("Task C is completed with input: "
                    + result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
