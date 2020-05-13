package com.praditya.sistempakarai;

import com.praditya.sistempakarai.model.Disease;
import com.praditya.sistempakarai.model.Infection;
import com.praditya.sistempakarai.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataHelper {

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("Apakah Anda sering mengalami buang air besar (lebih dari 2 kali)?"));
        questions.add(new Question("Apakah Anda mengalami buang air besar encer?"));
        questions.add(new Question("Apakah Anda mengalami buang air besar berdarah?"));
        questions.add(new Question("Apakah Anda merasa lesu dan tidak bergairah?"));
        questions.add(new Question("Apakah Anda tidak selera makan?"));
        questions.add(new Question("Apakah Anda merasa mual dan sering muntah (lebih dari 1 kali)?"));
        questions.add(new Question("Apakah Anda merasa sakit di bagian perut?"));
        questions.add(new Question("Apakah tekanan darah Anda rendah?"));
        questions.add(new Question("Apakah Anda merasa pusing?"));
        questions.add(new Question("Apakah Anda mengalami Pingsan?"));
        questions.add(new Question("Apakah suhu badan Anda tinggi?"));
        questions.add(new Question("Apakah Anda memiliki luka di bagian tertentu?"));
        questions.add(new Question("Apakah Anda tidak dapat menggerakkan anggota badan tertentu?"));
        questions.add(new Question("Apakah Anda pernah memakan sesuatu?"));
        questions.add(new Question("Apakah Anda memakan daging?"));
        questions.add(new Question("Apakah Anda memakan jamur?"));
        questions.add(new Question("Apakah Anda memakan makanan kaleng?"));
        questions.add(new Question("Apakah Anda membeli susu?"));
        questions.add(new Question("Apakah Anda meminum susu?"));

        return questions;
    }

    public static ArrayList<Disease> getDiseases() {
        ArrayList<Disease> diseases = new ArrayList<>();
        diseases.add(new Disease("Mencret", new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5))));
        diseases.add(new Disease("Muntah", new ArrayList<Integer>(Arrays.asList(4, 5, 6))));
        diseases.add(new Disease("Sakit Perut", new ArrayList<Integer>(Arrays.asList(4, 7))));
        diseases.add(new Disease("Darah Rendah", new ArrayList<Integer>(Arrays.asList(4, 8, 9))));
        diseases.add(new Disease("Koma", new ArrayList<Integer>(Arrays.asList(8, 10))));
        diseases.add(new Disease("Demam", new ArrayList<Integer>(Arrays.asList(4, 5, 9, 11))));
        diseases.add(new Disease("Septicaemia", new ArrayList<Integer>(Arrays.asList(4, 8, 11, 12))));
        diseases.add(new Disease("Lumpuh", new ArrayList<Integer>(Arrays.asList(4, 13))));
        diseases.add(new Disease("Mencret Berdarah", new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));
        diseases.add(new Disease("Makan Daging", new ArrayList<Integer>(Arrays.asList(14, 15))));
        diseases.add(new Disease("Makan Jamur", new ArrayList<Integer>(Arrays.asList(14, 16))));
        diseases.add(new Disease("Makan Makanan Kaleng", new ArrayList<Integer>(Arrays.asList(14, 17))));
        diseases.add(new Disease("Minum Susu", new ArrayList<Integer>(Arrays.asList(18, 19))));

        return diseases;
    }

    public static ArrayList<Infection> getInfections() {
        ArrayList<Infection> infections = new ArrayList<>();
        ArrayList<Disease> diseases = getDiseases();
        infections.add(new Infection("Keracunan Staphylococcus Aureus", new ArrayList<Disease>(Arrays.asList(
                diseases.get(0),
                diseases.get(1),
                diseases.get(2),
                diseases.get(3),
                diseases.get(9)
        ))));
        infections.add(new Infection("Keracunan Jamur Beracun", new ArrayList<Disease>(Arrays.asList(
                diseases.get(0),
                diseases.get(1),
                diseases.get(2),
                diseases.get(4),
                diseases.get(10)
        ))));
        infections.add(new Infection("Keracunan Salmonellae", new ArrayList<Disease>(Arrays.asList(
                diseases.get(0),
                diseases.get(1),
                diseases.get(2),
                diseases.get(5),
                diseases.get(6),
                diseases.get(9)
        ))));
        infections.add(new Infection("Keracunan Clostridium Botulinum", new ArrayList<Disease>(Arrays.asList(
                diseases.get(1),
                diseases.get(7),
                diseases.get(11)
        ))));
        infections.add(new Infection("Keracunan Campylobacter", new ArrayList<Disease>(Arrays.asList(
                diseases.get(2),
                diseases.get(5),
                diseases.get(8),
                diseases.get(12)
        ))));

        return infections;
    }
}
