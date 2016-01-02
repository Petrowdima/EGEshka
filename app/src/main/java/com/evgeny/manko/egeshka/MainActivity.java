package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMath;
    Button btnRus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMath = (Button) findViewById(R.id.btnMath);
        btnRus = (Button) findViewById(R.id.btnRus);
        btnMath.setOnClickListener(this);
        btnRus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btnMath:
                //intent = new Intent(this, actMath.class);
                //startActivity(intent);
                break;
            case R.id.btnRus:
                //intent = new Intent(this, actRus.class);
                //startActivity(intent);
        }
    }
}
