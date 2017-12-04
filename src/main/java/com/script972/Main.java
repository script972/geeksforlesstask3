package com.script972;


import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private ExecutorService executor;

    public static void main(String[] args) {
        Main main = new Main();
        main.manipulate();
    }

    public void manipulate() {
        List<IpEntity> iplists = new ArrayList<>();
        executor = Executors.newFixedThreadPool(3);
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            System.out.println("Введите " + i + " адрес");
            iplists.add(new IpEntity(scanner.nextLine(), 1));
        }
        createThread(iplists);

    }

    private void createThread(List<IpEntity> iplists) {
        for (IpEntity iplist : iplists) {
            executor.execute(new TestConnection(iplist.getNumber(), iplist.getIp()));
        }
    }

}
