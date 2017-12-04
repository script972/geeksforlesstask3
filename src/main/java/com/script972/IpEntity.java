package com.script972;

public class IpEntity {
    private String ip;
    private int number;
    private int prio;

    public IpEntity(String ip, int number, Integer prio) {
        this.ip = ip;
        this.number = number;
        this.prio=prio;
    }

    public String getIp() {
        return ip;
    }

    public int getNumber() {
        return number;
    }

    public int getPrio() {
        return prio;
    }
}
