package com.script972;


import java.io.*;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConnection extends Thread {
    private String ip;
    private int minute;
    private int number;

    public TestConnection(int number, String ip, int prior) {
        this.ip = ip;
        this.number = number;
        this.setPriority(prior);
    }

    @Override
    public void run() {
        while (minute < 60) {
            System.out.println(number + " --- " + timeStamp() + " --- " + isIpReachable(ip, 3600) + " <" + ip + ">");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            minute = minute + 5;
        }
        System.out.println("Поток "+number+" завершил работу.");
        this.interrupt();


    }

    private boolean isIpReachable(String ip, int timeout) {
        boolean state = false;

        try {
            state = InetAddress.getByName(ip).isReachable(timeout);
        } catch (IOException e) {
            //Parse error here
        }

        return state;
    }

    private String timeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }


}

