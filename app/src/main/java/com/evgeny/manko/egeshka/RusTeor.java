package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RusTeor extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rus_teor);
        Button A1btn;
        Button A2btn;

        A1btn = (Button) findViewById(R.id.teorA1btn);
        A2btn = (Button) findViewById(R.id.teorA2btn);

        A1btn.setOnClickListener(this);
        A2btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.teorA1btn:
                intent = new Intent(this, RusTeorA1.class);
                startActivity(intent);
                break;
            case R.id.teorA2btn:
                intent = new Intent(this, RusTeorA2.class);
                startActivity(intent);
        }
    }
}
