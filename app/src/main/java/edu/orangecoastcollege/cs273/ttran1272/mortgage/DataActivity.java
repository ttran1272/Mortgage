package edu.orangecoastcollege.cs273.ttran1272.mortgage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();

    }

    public void updateView() {
        Mortgage mortgage = MainActivity.mortgage;
        if (mortgage.getYears() == 10) {
            RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
            rb10.setChecked(true);
        } else if (mortgage.getYears() == 15){
            RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);
            rb15.setChecked(true);
        }

        EditText amountET = (EditText) findViewById(R.id.data_amount);
        amountET.setText("" + mortgage.getAmount());

        EditText rateET = (EditText) findViewById(R.id.data_rate);
        rateET.setText("" + mortgage.getRate());
    }


    public void updateMortgageObject() {
        Mortgage mortgage = MainActivity.mortgage;

        RadioButton rb10 = (RadioButton) findViewById(R.id.ten);
        RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen);

        int year = 30;
        if (rb10.isChecked())
            year = 10;
        else if (rb15.isChecked())
            year = 15;

        mortgage.setYears(year);

        EditText amountET = (EditText) findViewById(R.id.data_amount);
        String amountString = amountET.getText().toString();

        EditText rateET = (EditText) findViewById(R.id.data_rate);
        String rateString = rateET.getText().toString();

        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);

            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);
        }catch (NumberFormatException e){
            mortgage.setAmount(100000.0f);
            mortgage.setRate(.035f);
        }

    }
    public void goBack (View v){
        updateMortgageObject();
        this.finish();
    }

}
