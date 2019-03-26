package com.example.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void calcBMI(View view) {
        Intent intent = new Intent(this, secondActivity.class);
        Bundle bundle = new Bundle();
        TextView height;
        height = findViewById(R.id.height);
        TextView weight;
        weight = findViewById(R.id.weight);
        bundle.putString("KEY_HEIGHT", height.getText().toString());
        bundle.putString("KEY_WEIGHT", weight.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
