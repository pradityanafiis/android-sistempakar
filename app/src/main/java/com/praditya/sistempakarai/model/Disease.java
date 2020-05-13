package com.praditya.sistempakarai.model;

import java.util.ArrayList;

public class Disease {
    private String text;
    private ArrayList<Integer> questions;

    public Disease(String text, ArrayList<Integer> questions) {
        this.text = text;
        this.questions = questions;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Integer> questions) {
        this.questions = questions;
    }
}
