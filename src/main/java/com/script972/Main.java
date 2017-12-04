package com.script972;


import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private ExecutorService executor;

    public static void main(String[] args) {
        Main main=new Main();
        main.manipulate();
    }

    public void manipulate() {
        List<IpEntity> iplists=new ArrayList<>();
        executor=Executors.newFixedThreadPool(3);
        Scanner scanner=new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            System.out.println("Введите "+i+" адрес и номер приоритет [1..10]" );
            iplists.add(new IpEntity(scanner.nextLine(), i, Integer.valueOf(scanner.nextLine())));
        }
        createThread(iplists);
        executor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Потоки завершины");
                return "";
            }
        });


    }

    private void createThread(List<IpEntity> iplists) {
        for (int j = 0; j < iplists.size(); j++) {
            executor.execute(new TestConnection(iplists.get(j).getNumber(), iplists.get(j).getIp(), iplists.get(j).getPrio()));
        }

    }

}
