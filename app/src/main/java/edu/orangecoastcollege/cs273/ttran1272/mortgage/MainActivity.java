package edu.orangecoastcollege.cs273.ttran1272.mortgage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage( this );
        setContentView(R.layout.activity_main);
    }
}
