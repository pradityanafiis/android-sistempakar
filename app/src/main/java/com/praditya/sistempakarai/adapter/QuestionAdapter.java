package com.praditya.sistempakarai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.praditya.sistempakarai.R;
import com.praditya.sistempakarai.model.Question;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ListViewHolder> {
    ArrayList<Question> questions;
    Context context;

    public QuestionAdapter(Context context) {
        this.questions = new ArrayList<>();
        this.context = context;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    @NonNull
    @Override
    public QuestionAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ListViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.tvQuestion.setText(question.getQuestion());
        holder.cbQuestion.setOnCheckedChangeListener(null);
        holder.cbQuestion.setChecked(question.isChecked());
        holder.cbQuestion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                question.setChecked(b);
            }
        });

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb_question) CheckBox cbQuestion;
        @BindView(R.id.tv_question) TextView tvQuestion;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}