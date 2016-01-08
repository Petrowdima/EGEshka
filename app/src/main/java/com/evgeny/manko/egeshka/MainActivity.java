package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    Button btnMath;
    Button btnRus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMath = (Button) findViewById(R.id.btnMath);
        btnRus = (Button) findViewById(R.id.btnRus);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnMath:
                        break;
                    case R.id.btnRus:
                        Intent intent = new Intent(getApplicationContext(), rus.class);
                        startActivity(intent);
                        break;

                }
            }
        };
        btnMath.setOnClickListener(onClickListener);
        btnRus.setOnClickListener(onClickListener);
    }
}



