package com.example.android.populationquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.populationquiz.R.id.editText_planet;

public class QuizActivity extends AppCompatActivity {

    int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


    }

    /**
     * Submits answers and displays score.
     */
    public void submit (View view) {
//        checkFirst();
//        checkSecond();
//        checkThird();
        checkFourth();

    }

    /**
     * Checks if first answer is correct.
     */
    public void checkFirst () {
        EditText editTextPlanet = (EditText) findViewById(editText_planet);
        String answer = editTextPlanet.getEditableText().toString();
        String planet = getString(R.string.string_question01_answer);
        if (answer.equals(planet)) {
            mScore += 1;
            showToast(getString(R.string.string_first) + getString(R.string.string_correct) + mScore);
        } else {
            showToast(getString(R.string.string_first) + getString(R.string.string_incorrect) + mScore);
        }
    }

    /**
     * Checks if second answer is correct.
     */
    public void checkSecond() {
        RadioButton true02 = (RadioButton) findViewById(R.id.true02);
        boolean isCorrect02 = true02.isChecked();
        if (isCorrect02) {
            mScore += 1;
            showToast(getString(R.string.string_second) + getString(R.string.string_correct) + mScore);
        } else {
            showToast(getString(R.string.string_second) + getString(R.string.string_incorrect) + mScore);
        }

    }

    /**
     * Checks if third answer is correct.
     */
    public void checkThird (){
        RadioButton true03 = (RadioButton) findViewById(R.id.true03);
        boolean isCorrect03 = true03.isChecked();
        if (isCorrect03) {
            mScore += 1;
            showToast(getString(R.string.string_third) + getString(R.string.string_correct) + mScore);
        } else {
            showToast(getString(R.string.string_third) + getString(R.string.string_incorrect) + mScore);
        }
    }

    /**
     * Checks if fourth answer is correct.
     */
    public void checkFourth() {
        CheckBox true04 = (CheckBox) findViewById(R.id.true04);
        boolean isCorrect04 = true04.isChecked();
        CheckBox true05 = (CheckBox) findViewById(R.id.true05);
        boolean isCorrect05 = true05.isChecked();
        CheckBox false01 = (CheckBox) findViewById(R.id.false01);
        boolean isFalse01 = false01.isChecked();
        CheckBox false02 = (CheckBox) findViewById(R.id.false02);
        boolean isFalse02 = false02.isChecked();


        if (isCorrect04) {
            if (isCorrect05) {
                mScore += 2;
                if (!isFalse01) {
                    if (!isFalse02) { // Only the two correct answers are checked.
                        showToast(getString(R.string.string_fourth) + getString(R.string.string_correct) + mScore);
                    } else { // Two correct answers checked, and one wrong, option B.
                        mScore -= 1;
                        showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                    }
                } else { // Two correct answers checked, and one wrong, option A.
                    mScore -= 1;
                    if (isFalse02){ // Two correct answers checked, and two wrong ones.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                }
            } else { // Only option C is correctly checked.
                mScore += 1;
                if(isFalse01){ // And incorrectly also option A is checked.
                    mScore -= 1;
                    if (isFalse02){ // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                } else {
                    if (isFalse02) { // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
            }
        } else {
            if (isCorrect05) { // Only option D is correctly checked.
                mScore += 1;
                if(isFalse01){ // And incorrectly also option A is checked.
                    mScore -= 1;
                    if (isFalse02){ // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                } else {
                    if (isFalse02) { // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct) + mScore);
            } else { // No correct option is checked.
                if (isFalse01) { // And incorrectly option A is checked.
                    mScore -= 1;
                    if (isFalse02) { // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_incorrect) + mScore);
                } else {
                    if (isFalse02) { // And incorrectly  option B is checked.
                        mScore -= 1;
                    }
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_incorrect) + mScore);
            }
        }
    }

    /**
     * Resets score.
     */
    public void resetScore() {
        mScore = 0;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Displays Toast message.
     */
    public void showToast(String strMessage) {
        Toast.makeText(getApplicationContext(),strMessage, Toast.LENGTH_LONG).show();
    }
}
