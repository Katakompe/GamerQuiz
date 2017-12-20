package com.example.android.gamerquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.gamerquiz.R.id.question;

public class QuizActivity extends AppCompatActivity {

    int activeQuestion=1;
    boolean checkedAnswer=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("activeQuestion", activeQuestion);
        savedInstanceState.putBoolean("checkedAnswer", checkedAnswer);
    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState) {
        activeQuestion = savedInstanceState.getInt("activeQuestion");
        checkedAnswer = savedInstanceState.getBoolean("checkedAnswer");
        TextView question = (TextView) findViewById(R.id.question);
        RadioButton r1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton r2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton r3 = (RadioButton) findViewById(R.id.radio3);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

        switch(activeQuestion) {
            case 1:
                question.setText(getString(R.string.question1));
                r1.setText(getString(R.string.answer1A));
                r2.setText(getString(R.string.answer1B));
                r3.setText(getString(R.string.answer1C));
                break;
            case 2:
                question.setText(getString(R.string.question2));
                r1.setText(getString(R.string.answer2B));
                r2.setText(getString(R.string.answer2C));
                r3.setText(getString(R.string.answer2A));
                break;
            case 3:
                question.setText(getString(R.string.question3));
                r1.setText(getString(R.string.answer3B));
                r2.setText(getString(R.string.answer3A));
                r3.setText(getString(R.string.answer3C));
                break;
            case 4:
                question.setText(getString(R.string.question4));
                r1.setText(getString(R.string.answer4C));
                r2.setText(getString(R.string.answer4A));
                r3.setText(getString(R.string.answer4B));
                break;
            case 5:
                question.setText(getString(R.string.question1));
                r1.setText(getString(R.string.answer5A));
                r2.setText(getString(R.string.answer5C));
                r3.setText(getString(R.string.answer5A));
                break;
            case 6:
                question.setText(getString(R.string.question6));
                r1.setText(getString(R.string.answer6A));
                r2.setText(getString(R.string.answer6B));
                r3.setText(getString(R.string.answer6C));
                break;
            case 7:
                question.setText(getString(R.string.question7));
                r1.setText(getString(R.string.answer7A));
                r2.setText(getString(R.string.answer7B));
                r3.setText(getString(R.string.answer7C));
                break;
            case 8:
                question.setText(getString(R.string.question8));
                r1.setText(getString(R.string.answer8C));
                r2.setText(getString(R.string.answer8A));
                r3.setText(getString(R.string.answer8B));
                break;
            case 9:
                question.setText(getString(R.string.question9));
                r1.setText(getString(R.string.answer9C));
                r2.setText(getString(R.string.answer9B));
                r3.setText(getString(R.string.answer9A));
                break;
            case 10:
                question.setText(getString(R.string.question10));
                r1.setText(getString(R.string.answer10A));
                r2.setText(getString(R.string.answer10C));
                r3.setText(getString(R.string.answer10B));
                break;
            default:
                activeQuestion=1;
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }


    public void checkAnswer (View v){
        String correctAnswer;
        switch(activeQuestion) {
            case 1:
                correctAnswer = getString(R.string.answer1C);
                break;
            case 2:
                correctAnswer = getString(R.string.answer2C);
                break;
            case 3:
                correctAnswer = getString(R.string.answer3C);
                break;
            case 4:
                correctAnswer = getString(R.string.answer4C);
                break;
            case 5:
                correctAnswer = getString(R.string.answer5C);
                break;
            case 6:
                correctAnswer = getString(R.string.answer6C);
                break;
            case 7:
                correctAnswer = getString(R.string.answer7C);
                break;
            case 8:
                correctAnswer = getString(R.string.answer8C);
                break;
            case 9:
                correctAnswer = getString(R.string.answer9C);
                break;
            case 10:
                correctAnswer = getString(R.string.answer10C);
                break;
            default:
                correctAnswer = "error";
                break;

        }


        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.radiogroup);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if(radioButtonID == -1){
            Toast.makeText(this, "Choose an answer first", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton radioButton = (RadioButton) radioButtonGroup.findViewById(radioButtonID);
        String answer = radioButton.getText().toString();


        if(correctAnswer.equals(answer)){
            Toast.makeText(this, "Your answer was correct! Great!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Your answer was wrong! Correct Answer: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }
        checkedAnswer = true;
    }

    public void nextQuestion(View v){

        if(!checkedAnswer) {
            Toast.makeText(this, "Check your answer before moving on!", Toast.LENGTH_SHORT).show();
            return;
        }
        activeQuestion++;

        TextView question = (TextView) findViewById(R.id.question);
        RadioButton r1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton r2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton r3 = (RadioButton) findViewById(R.id.radio3);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

        switch(activeQuestion) {
            case 1:
                question.setText(getString(R.string.question1));
                r1.setText(getString(R.string.answer1A));
                r2.setText(getString(R.string.answer1B));
                r3.setText(getString(R.string.answer1C));
                break;
            case 2:
                question.setText(getString(R.string.question2));
                r1.setText(getString(R.string.answer2B));
                r2.setText(getString(R.string.answer2C));
                r3.setText(getString(R.string.answer2A));
                break;
            case 3:
                question.setText(getString(R.string.question3));
                r1.setText(getString(R.string.answer3B));
                r2.setText(getString(R.string.answer3A));
                r3.setText(getString(R.string.answer3C));
                break;
            case 4:
                question.setText(getString(R.string.question4));
                r1.setText(getString(R.string.answer4C));
                r2.setText(getString(R.string.answer4A));
                r3.setText(getString(R.string.answer4B));
                break;
            case 5:
                question.setText(getString(R.string.question1));
                r1.setText(getString(R.string.answer5A));
                r2.setText(getString(R.string.answer5C));
                r3.setText(getString(R.string.answer5A));
                break;
            case 6:
                question.setText(getString(R.string.question6));
                r1.setText(getString(R.string.answer6A));
                r2.setText(getString(R.string.answer6B));
                r3.setText(getString(R.string.answer6C));
                break;
            case 7:
                question.setText(getString(R.string.question7));
                r1.setText(getString(R.string.answer7A));
                r2.setText(getString(R.string.answer7B));
                r3.setText(getString(R.string.answer7C));
                break;
            case 8:
                question.setText(getString(R.string.question8));
                r1.setText(getString(R.string.answer8C));
                r2.setText(getString(R.string.answer8A));
                r3.setText(getString(R.string.answer8B));
                break;
            case 9:
                question.setText(getString(R.string.question9));
                r1.setText(getString(R.string.answer9C));
                r2.setText(getString(R.string.answer9B));
                r3.setText(getString(R.string.answer9A));
                break;
            case 10:
                question.setText(getString(R.string.question10));
                r1.setText(getString(R.string.answer10A));
                r2.setText(getString(R.string.answer10C));
                r3.setText(getString(R.string.answer10B));
                break;
            default:
                activeQuestion=1;
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        rg.clearCheck();
        checkedAnswer=false;

    }
}
