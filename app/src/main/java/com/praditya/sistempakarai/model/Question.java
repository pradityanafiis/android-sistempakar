package com.praditya.sistempakarai.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String question;
    private boolean checked = false;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
