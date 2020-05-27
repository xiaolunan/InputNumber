package com.rcl.lib.inputnumber;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.rcl.lib.inputnumber.listener.InputNumListener;

public class InputNumberView extends LinearLayout {

    private InputNumListener inputNumListener;
    private int inputNumber = 0;
    private EditText edit_input;
    private int numberMin;
    private int numberMax;
    private int defaultNumber;
    private LinearLayout viewPackage;
    private boolean disable;
    private Button lessBtn;
    private Button plusBtn;
    private int step;

    public InputNumberView(Context context) {
        this(context, null);
    }

    public InputNumberView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputNumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.input_number_layout, this);

        initView();

        initAttr(context, attrs);
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView);
        numberMin = typedArray.getInt(R.styleable.InputNumberView_numberMin, 0);
        numberMax = typedArray.getInt(R.styleable.InputNumberView_numberMax, 10);

        defaultNumber = typedArray.getInt(R.styleable.InputNumberView_defaultNumber, 0);
        setNumber();

        disable = typedArray.getBoolean(R.styleable.InputNumberView_btnDisable, false);
        initDisable();

        step = typedArray.getInt(R.styleable.InputNumberView_step, 1);
    }

    private void initView() {
        viewPackage = this.findViewById(R.id.viewPackage);
        lessBtn = this.findViewById(R.id.LessBtn);
        plusBtn = this.findViewById(R.id.plusBtn);
        edit_input = this.findViewById(R.id.edit_input);

        //减号事件
        lessBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //最小值
                inputNumber -= step;
                if (inputNumber <= numberMin) {
                    inputNumber = numberMin;
                }
                setInputNumber(inputNumber);
                initGetNum();
            }
        });

        //加号事件
        plusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //最大值
                inputNumber += step;
                if (inputNumber >= numberMax) {
                    inputNumber = numberMax;
                }
                setInputNumber(inputNumber);
                initGetNum();
            }
        });
    }

    private int getInputNumber() {
        return inputNumber;
    }

    private void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    private void initGetNum() {
        edit_input.setText(String.valueOf(getInputNumber()));
        if (inputNumListener != null) {
            inputNumListener.inputNumber(getInputNumber());
        }
    }

    public void setInputNumListener(InputNumListener inputNumListener) {
        this.inputNumListener = inputNumListener;
    }

    public void setNumberMin(int numberMin) {
        this.numberMin = numberMin;
    }

    public void setNumberMax(int numberMax) {
        this.numberMax = numberMax;
    }

    public void setDefaultNumber(int defaultNumber) {
        this.defaultNumber = defaultNumber;
        setNumber();
    }

    private void setNumber() {
        //设置默认值
        setInputNumber(defaultNumber);
        //刷线ui
        initGetNum();
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
        initDisable();
    }

    //设置禁用状态
    private void initDisable() {
        if (disable) {
            lessBtn.setBackgroundResource(R.drawable.less_disable_bg);
            lessBtn.setEnabled(false);
            plusBtn.setBackgroundResource(R.drawable.plus_disable_bg);
            plusBtn.setEnabled(false);
            edit_input.setBackgroundResource(R.drawable.edit_disable_bg);
            edit_input.setEnabled(false);
        }
    }

    public void setStep(int step) {
        this.step = step;
    }
}
