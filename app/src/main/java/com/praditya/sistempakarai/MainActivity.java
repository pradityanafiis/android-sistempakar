package com.praditya.sistempakarai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.edt_threshold) EditText edtThreshold;
    @BindView(R.id.btn_question) Button btnQuestion;
    private int threshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_question) {
            if (checkInput()) {
                startActivity(new Intent(MainActivity.this, QuestionActivity.class));
            }
        }
    }

    private boolean checkInput() {
        boolean isReady = true;
        String thresholdText = edtThreshold.getText().toString().trim();

        if (thresholdText.isEmpty()) {
            edtThreshold.setError("Threshold harus diisi");
            isReady = false;
        }else {
            threshold = Integer.parseInt(thresholdText);
            if (threshold < 0 || threshold > 100) {
                edtThreshold.setError("Nilai threshold harus antara 1 sampai 100");
                isReady = false;
            }
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("threshold", threshold);
        editor.commit();
        return isReady;
    }
}
