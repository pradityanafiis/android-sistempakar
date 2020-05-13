package com.praditya.sistempakarai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.praditya.sistempakarai.model.Disease;
import com.praditya.sistempakarai.model.Infection;
import com.praditya.sistempakarai.model.Question;
import com.praditya.sistempakarai.model.Result;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    @BindViews({R.id.tv_infection_name_1, R.id.tv_infection_name_2, R.id.tv_infection_name_3, R.id.tv_infection_name_4, R.id.tv_infection_name_5})
    List<TextView> tvInfectionName;
    @BindViews({R.id.tv_infection_percentage_1, R.id.tv_infection_percentage_2, R.id.tv_infection_percentage_3, R.id.tv_infection_percentage_4, R.id.tv_infection_percentage_5})
    List<TextView> tvInfectionPercentage;
    @BindView(R.id.btn_retry)
    Button btnRetry;
    @BindView(R.id.tv_infection_result)
    TextView tvInfectionResult;
    private ArrayList<Question> questions;
    private int threshold;
    private String resultInfection = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ResultActivity.this);

        questions = (ArrayList<Question>) getIntent().getSerializableExtra("QUESTIONS_EXTRA");
        threshold = sharedPreferences.getInt("threshold", 0);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        calculateResult();
    }

    public void calculateResult() {
        ArrayList<Infection> infections = DataHelper.getInfections();
        ArrayList<Result> results = new ArrayList<>();
        for (Infection infection : infections) {
            float percentage = 100.0f/infection.getDiseases().size();
            float sumPercentage = 0f;
            for (Disease disease : infection.getDiseases()) {
                float sum = 0f;
                for (int i : disease.getQuestions()) {
                    if (questions.get(i-1).isChecked()) {
                        sum++;
                    }
                }
                sumPercentage += (sum/disease.getQuestions().size())*percentage;
            }
            if (sumPercentage >= threshold) {
                resultInfection += infection.getText() + "\n";
            }
            results.add(new Result(infection.getText(), (int) sumPercentage));
        }
        displayResult(results);
    }

    public void displayResult(ArrayList<Result> results) {
        for (int i = 0; i < tvInfectionName.size(); i++) {
            Result result = results.get(i);
            TextView tvName = tvInfectionName.get(i);
            TextView tvPercentage = tvInfectionPercentage.get(i);

            tvName.setText(result.getInfectionName());
            tvPercentage.setText(result.getInfectionPercentage() + "%");
        }

        if (resultInfection.isEmpty())
            tvInfectionResult.setText("Tidak ada");
        else
            tvInfectionResult.setText(resultInfection);
    }
}
