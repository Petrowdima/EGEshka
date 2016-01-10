package com.evgeny.manko.egeshka;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RussianActivity extends AppCompatActivity implements View.OnClickListener{

    Button testBtn;
    Button teorBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian);

        testBtn = (Button) findViewById(R.id.testBtn);
        teorBtn = (Button) findViewById(R.id.teorBtn);

        testBtn.setOnClickListener(this);
        teorBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.testBtn:
                startActivity(new Intent(this, RusTest.class));
                break;
            case R.id.teorBtn:
                startActivity(new Intent(this, RusTeor.class));
                break;
        }
    }
}