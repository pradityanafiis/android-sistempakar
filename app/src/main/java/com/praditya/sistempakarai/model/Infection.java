package com.praditya.sistempakarai.model;

import java.util.ArrayList;

public class Infection {
    private String text;
    private ArrayList<Disease> diseases;

    public Infection(String text, ArrayList<Disease> diseases) {
        this.text = text;
        this.diseases = diseases;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<Disease> diseases) {
        this.diseases = diseases;
    }
}
