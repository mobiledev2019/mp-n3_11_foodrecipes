package foodrecipes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import foodrecipes.R;

public class CalculateResultActivity extends AppCompatActivity {

    private TextView textCalo;
    private TextView textGain;
    private TextView textLose;

    private String gender;
    private int weight;
    private int height;
    private int age;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);

        textCalo = (TextView) findViewById(R.id.text_calories);
        textGain = (TextView) findViewById(R.id.text_gain);
        textLose = (TextView) findViewById(R.id.text_lose);

        Intent intent = getIntent();
        weight = Integer.parseInt(intent.getStringExtra(CalculateBMRActivity.KEY_WEIGHT));
        age = Integer.parseInt(intent.getStringExtra(CalculateBMRActivity.KEY_AGE));
        height = Integer.parseInt(intent.getStringExtra(CalculateBMRActivity.KEY_HEIGHT));
        gender = intent.getStringExtra(CalculateBMRActivity.KEY_GENDER);

        if (gender.equals("Male")) {
            result = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            result = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        textCalo.setText(getString(R.string.calories) + " " + String.valueOf(result));
        textGain.setText(getString(R.string.gain_weight) + " " + String.valueOf(result + 500));
        textLose.setText(getString(R.string.lose_weight) + " " + String.valueOf(result - 500));
    }
}
