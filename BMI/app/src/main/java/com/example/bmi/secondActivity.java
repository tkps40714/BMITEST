package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class secondActivity extends AppCompatActivity {

    private Button button_back;
    private TextView show_result;
    private TextView show_suggest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        showResults();
    }

    private void initViews()
    {
        button_back = (Button)findViewById(R.id.button);
        show_result = (TextView)findViewById(R.id.result);
        show_suggest = (TextView)findViewById(R.id.suggest);
    }
    private void showResults()
    {
        try
        {
            DecimalFormat nf = new DecimalFormat("0.00");

            Bundle bundle = this.getIntent().getExtras();
            //身高
            double height = Double.parseDouble(bundle.getString("KEY_HEIGHT"))/100;
            //體重
            double weight = Double.parseDouble(bundle.getString("KEY_WEIGHT"));
            //計算出BMI值
            double BMI = weight / (height*height);

            //結果
            show_result.setText("BMI:" + nf.format(BMI));

            //建議
            if(BMI > 25) //太重了
                show_suggest.setText("heavy");
            else if(BMI < 20) //太輕了
                show_suggest.setText("light");
            else //剛剛好
                show_suggest.setText("avg");
        }
        catch(Exception obj)
        {
            Toast.makeText(this, "要先輸入身高體重喔!", Toast.LENGTH_SHORT).show();
        }
    }
}
