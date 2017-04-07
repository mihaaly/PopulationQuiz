package com.example.android.populationquiz;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    // Holds actual points attained by user.
    int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


    }

    /**
     * Scrolls back to start, resets score to 0, submits answers and displays score.
     */
    public void submit (View view) {
        // Scrolls back to start.
        int orientation = this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            //code for portrait mode
            ScrollView scrollView = (ScrollView) findViewById(R.id.quiz_portrait);
            scrollView.scrollTo(0, 0);
        }
        else{
            //code for landscape mode
            HorizontalScrollView scrollView2 = (HorizontalScrollView) findViewById(R.id.quiz_land);
            scrollView2.scrollTo(0, 0);
        }
        // Reset and check.
        mScore = 0;
        checkFirst();
        checkSecond();
        checkThird();
        checkFourth();
        checkFifth();
        showToast(getString(R.string.string_scoreToast) + mScore + "/6");

    }

    /**
     * Checks if first answer is correct, assigns points, gives feedback if answer is correct.
     */
    public void checkFirst () {
        EditText editTextPlanet = (EditText) findViewById(R.id.editText_planet);
        String answer = editTextPlanet.getEditableText().toString();
        String planet = getString(R.string.string_question01_answer);
        if (answer.equals(planet)) {
            mScore += 1;
            showToast(getString(R.string.string_first) + getString(R.string.string_correct));
        } else {
            showToast(getString(R.string.string_first) + getString(R.string.string_incorrect));
        }
    }

    /**
     * Checks if second answer is correct, assigns points, gives feedback if answer is correct.
     */
    public void checkSecond() {
        RadioButton true02 = (RadioButton) findViewById(R.id.true02);
        boolean isCorrect02 = true02.isChecked();
        if (isCorrect02) {
            mScore += 1;
            showToast(getString(R.string.string_second) + getString(R.string.string_correct));
        } else {
            showToast(getString(R.string.string_second) + getString(R.string.string_incorrect));
        }

    }

    /**
     * Checks if third answer is correct, assigns points, gives feedback if answer is correct.
     */
    public void checkThird (){
        RadioButton true03 = (RadioButton) findViewById(R.id.true03);
        boolean isCorrect03 = true03.isChecked();
        if (isCorrect03) {
            mScore += 1;
            showToast(getString(R.string.string_third) + getString(R.string.string_correct));
        } else {
            showToast(getString(R.string.string_third) + getString(R.string.string_incorrect));
        }
    }

    /**
     * Checks if fourth answer is correct, assigns points, gives feedback if answer is correct.
     * It's sick, I know :)
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
                        showToast(getString(R.string.string_fourth) + getString(R.string.string_correct));
                    } else { // Two correct answers checked, and one wrong, option B.
                        mScore -= 1;
                        showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                    }
                } else { // Two correct answers checked, and one wrong: option A.
                    mScore -= 1;
                    if (isFalse02){ // Two correct answers checked, and two wrong ones.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                }
            } else { // Only option C is correctly checked.
                mScore += 1;
                if(isFalse01){ // And incorrectly also option A is checked.
                    mScore -= 1;
                    if (isFalse02){ // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                } else {
                    if (isFalse02) { // And incorrectly option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
            }
        } else {
            if (isCorrect05) { // Only option D is correctly checked.
                mScore += 1;
                if(isFalse01){ // And incorrectly also option A is checked.
                    mScore -= 1;
                    if (isFalse02){ // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                } else {
                    if (isFalse02) { // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_partially)+ getString(R.string.string_correct));
            } else { // No correct option is checked.
                if (isFalse01) { // And incorrectly option A is checked.
                    mScore -= 1;
                    if (isFalse02) { // And incorrectly also option B is checked.
                        mScore -= 1;
                    }
                    showToast(getString(R.string.string_fourth) + getString(R.string.string_incorrect));
                } else {
                    if (isFalse02) { // And incorrectly  option B is checked.
                        mScore -= 1;
                    }
                }
                showToast(getString(R.string.string_fourth) + getString(R.string.string_incorrect));
            }
        }
    }

    /**
     * Checks if fifth answer is correct, assigns points, gives feedback if answer is correct.
     */
    public void checkFifth(){
        RadioButton true06 = (RadioButton) findViewById(R.id.true06);
        boolean isCorrect06 = true06.isChecked();
        if (isCorrect06) {
            mScore += 1;
            showToast(getString(R.string.string_fifth) + getString(R.string.string_correct));
        } else {
            showToast(getString(R.string.string_fifth) + getString(R.string.string_incorrect));
        }
    }

    /**
     * Resets score, and navigates back to home screen.
     */
    public void resetScore(View view) {
        mScore = 0;
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates to InfoActivity for background information.
     */
    public void moreInfo (View view) {
        Intent intent = new Intent (this,InfoActivity.class);
        startActivity(intent);
    }

    /**
     * Displays short Toast message.
     */
    public void showToast(String strMessage) {
        Toast.makeText(getApplicationContext(),strMessage, Toast.LENGTH_LONG).show();
    }


}
