package edu.orangecoastcollege.cs273.ttran1272.mortgage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage( this );
        setContentView(R.layout.activity_main);
    }


    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        TextView amountTV = (TextView) findViewById(R.id.amount);
        amountTV.setText(mortgage.getFormattedAmount());

        TextView yearsTV = (TextView) findViewById(R.id.years);
        yearsTV.setText(mortgage.getYears());

        TextView rateTV = (TextView) findViewById(R.id.rate);
        rateTV.setText(mortgage.getRate() + "%");

        TextView monthlyTV = (TextView) findViewById(R.id.monthly_payment);
        monthlyTV.setText(mortgage.formattedMonthlyPayment());

        TextView totalTV = (TextView) findViewById(R.id.totalPayment);
        totalTV.setText(mortgage.formattedTotalPayment());
    }


    public void modifyData(View v){
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }

}
