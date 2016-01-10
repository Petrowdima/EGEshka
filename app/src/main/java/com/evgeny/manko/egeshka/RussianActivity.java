package com.evgeny.manko.egeshka;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RussianActivity extends AppCompatActivity implements View.OnClickListener{

    Button teorBtn;
    Button testBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian);

        teorBtn = (Button) findViewById(R.id.teorBtn);
        testBtn = (Button) findViewById(R.id.testBtn);

        teorBtn.setOnClickListener(this);
        testBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.teorBtn:
                startActivity(new Intent(this, RusTeor.class));
                break;
            case R.id.testBtn:
                startActivity(new Intent(this, RusTest.class));
                break;
        }
    }
}