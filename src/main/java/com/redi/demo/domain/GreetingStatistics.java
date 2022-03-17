package com.redi.demo.domain;

public class GreetingStatistics {

    private String name;
    private int greets;

    public GreetingStatistics(String name, int greets) {
        this.name = name;
        this.greets = greets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGreets() {
        return greets;
    }

    public void setGreets(int greets) {
        this.greets = greets;
    }
}
