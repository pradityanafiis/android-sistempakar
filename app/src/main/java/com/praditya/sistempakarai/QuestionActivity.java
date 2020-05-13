package com.praditya.sistempakarai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.praditya.sistempakarai.adapter.QuestionAdapter;
import com.praditya.sistempakarai.model.Question;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionActivity extends AppCompatActivity {
    @BindView(R.id.rv_question) RecyclerView rvQuestion;
    @BindView(R.id.btn_submit) Button btnSubmit;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ButterKnife.bind(this);
        rvQuestion.setHasFixedSize(true);
        rvQuestion.setLayoutManager(new LinearLayoutManager(QuestionActivity.this));
        adapter = new QuestionAdapter(QuestionActivity.this);
        adapter.setQuestions(DataHelper.getQuestions());
        rvQuestion.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                intent.putExtra("QUESTIONS_EXTRA", adapter.getQuestions());
                startActivity(intent);
            }
        });
    }

}
