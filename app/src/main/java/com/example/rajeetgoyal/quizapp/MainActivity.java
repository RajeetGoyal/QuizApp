package com.example.rajeetgoyal.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(getResources().getString(R.string.activity_name));
    }


    // This method be called on clicking radio buttons.
    public void onRadioButtonClicked(View view) {
        RadioButton radioButton = findViewById(view.getId());
        boolean checked = radioButton.isChecked();
        switch (view.getId()) {
            case R.id.ques1_b_radio_button:
            case R.id.ques2_c_radio_button:
            case R.id.ques7_a_radio_button:
            case R.id.ques5_b_radio_button:
            case R.id.ques4_a_radio_button:
                if (checked)
                    score = score + 1;
                break;
        }
    }

    // This method will be called on clicking checkboxes.
    public void onCheckBoxClicked(View view) {
        CheckBox firstCheckBox = findViewById(R.id.ques3_a_check_box);
        CheckBox thirdCheckBox = findViewById(R.id.ques3_c_check_box);
        boolean firstCheckBoxState = firstCheckBox.isChecked();
        boolean thirdCheckBoxState = thirdCheckBox.isChecked();
        if (firstCheckBoxState && thirdCheckBoxState) {
            score = score + 1;
        }
    }

    // This method is called when the submit button is clicked.
    public void submit(View view) {
        // Compare the EditText input string with the correct answer.
        EditText editText = findViewById(R.id.continent_edit_text);
        String str1 = editText.getText().toString();
        String str2 = "Asia";
        if (str1.equalsIgnoreCase(str2)) {
            score = score + 1;
        }


        // Generating quiz results in a toast
        Toast.makeText(MainActivity.this, "Your score is " + score + " out of 7", Toast.LENGTH_LONG).show();

        // Clearing inputs after generating the scores
        RadioGroup question1 = findViewById(R.id.question1_radio_group);
        question1.clearCheck();
        RadioGroup question2 = findViewById(R.id.question2_radio_group);
        question2.clearCheck();
        CheckBox firstCheckBox = findViewById(R.id.ques3_a_check_box);
        if(firstCheckBox.isChecked()){
            firstCheckBox.setChecked(false);
        }
        CheckBox secondCheckBox = findViewById(R.id.ques3_b_check_box);
        if(secondCheckBox.isChecked()){
            secondCheckBox.setChecked(false);
        }
        CheckBox thirdCheckBox = findViewById(R.id.ques3_c_check_box);
        if(thirdCheckBox.isChecked()){
            thirdCheckBox.setChecked(false);
        }
        RadioGroup question4 = findViewById(R.id.question4_radio_group);
        question4.clearCheck();
        RadioGroup question5 = findViewById(R.id.question5_radio_group);
        question5.clearCheck();
        editText.getText().clear();
        RadioGroup question7 = findViewById(R.id.question7_radio_group);
        question7.clearCheck();
        score = 0;
    }
}


