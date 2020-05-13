package com.praditya.sistempakarai.model;

public class Result {
    private String infectionName;
    private int infectionPercentage;

    public Result(String infectionName, int infectionPercentage) {
        this.infectionName = infectionName;
        this.infectionPercentage = infectionPercentage;
    }

    public String getInfectionName() {
        return infectionName;
    }

    public void setInfectionName(String infectionName) {
        this.infectionName = infectionName;
    }

    public int getInfectionPercentage() {
        return infectionPercentage;
    }

    public void setInfectionPercentage(int infectionPercentage) {
        this.infectionPercentage = infectionPercentage;
    }
}
