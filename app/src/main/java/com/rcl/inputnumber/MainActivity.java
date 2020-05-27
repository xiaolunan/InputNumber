package com.rcl.inputnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.rcl.lib.inputnumber.InputNumberView;
import com.rcl.lib.inputnumber.listener.InputNumListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private InputNumberView mInputNumberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputNumberView = findViewById(R.id.mInputNumberView);
        mInputNumberView.setInputNumListener(new InputNumListener() {
            @Override
            public void inputNumber(int number) {
                Log.d(TAG, "inputNumber: " + number);
            }
        });

        mInputNumberView.setNumberMin(-5);
        mInputNumberView.setNumberMax(15);
        mInputNumberView.setDefaultNumber(10);
        mInputNumberView.setStep(1);
    }
}
