//Копия файла присланная мне Даниилом https://vk.com/danek130995 danek130995@github
package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bMathBtn;
    Button rusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bMathBtn = (Button) findViewById(R.id.bMathBtn);
        rusBtn = (Button) findViewById(R.id.RusBtn);

        bMathBtn.setOnClickListener(this);
        rusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.bMathBtn:
                break;
            case R.id.RusBtn:
                intent = new Intent(this, RussianActivity.class);
                startActivity(intent);
                break;
        }
    }
}