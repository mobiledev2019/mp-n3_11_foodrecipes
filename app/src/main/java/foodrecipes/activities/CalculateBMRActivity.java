package foodrecipes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import foodrecipes.R;

public class CalculateBMRActivity extends AppCompatActivity {
    private List<String> listGender;

    public static final String KEY_AGE = "age";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_WEIGHT = "weight";

    private EditText editHeight;
    private EditText editAge;
    private EditText editWeight;
    private Spinner spinnerGender;
    private Button buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmr);

        editAge = (EditText) findViewById(R.id.text_years);
        editHeight = (EditText) findViewById(R.id.text_height);
        editWeight = (EditText) findViewById(R.id.text_weight);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);
        spinnerGender = (Spinner) findViewById(R.id.spinner_gender);

        listGender = new ArrayList<String>();
        listGender.add("Male");
        listGender.add("Female");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listGender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editAge.getText().toString().equals("") || editHeight.getText().toString().equals("") || editWeight.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields required!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), CalculateResultActivity.class);
                    intent.putExtra(KEY_AGE, editAge.getText().toString());
                    intent.putExtra(KEY_HEIGHT, editHeight.getText().toString());
                    intent.putExtra(KEY_WEIGHT, editWeight.getText().toString());
                    intent.putExtra(KEY_GENDER, spinnerGender.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
