package edu.orangecoastcollege.cs273.ttran1272.mortgage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.text.DecimalFormat;

/**
 * Created by ttran1272 on 9/25/2017.
 */

public class Mortgage {
    public final DecimalFormat MONEY = new DecimalFormat( "$#,##0.00");
    private static final String PREFERENCE_AMOUNT = "amount";
    private static final String PREFERENCE_YEARS = "years";
    private static final String PREFERENCE_RATE = "rate";

    private float amount;
    private int years;
    private float rate;

    // Instantiate Mortgage from preferences
    public Mortgage (Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        setAmount(pref.getFloat(PREFERENCE_AMOUNT, 100000.0F));
        setYears(pref.getInt(PREFERENCE_YEARS, 30));
        setRate(pref.getFloat(PREFERENCE_RATE, 0.035f));

    }

    //Write mortgage data to preferences
    public void setPreferences(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat( PREFERENCE_AMOUNT, amount);
        editor.putInt( PREFERENCE_YEARS, years);
        editor.putFloat( PREFERENCE_RATE, rate);
        editor.commit();
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getFormattedAmount() {
        return MONEY.format(amount);
    }

    public float monthlyPayment() {
        float mRate = rate / 12;
        double temp = Math.pow( 1/( 1+ mRate) , years * 12);
        return amount * mRate / (float) ( 1 - temp) ;
    }

    public String formattedMonthlyPayment() {
        return MONEY.format(monthlyPayment());
    }

    public float totalPayment() {
        return monthlyPayment() * years * 12;
    }

    public String formattedTotalPayment() {
        return MONEY.format(totalPayment());
    }
}
