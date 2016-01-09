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

public class RussianActivity extends AppCompatActivity {

    Button teorBtn;
    ListView lvudar;
    FragmentTransaction fTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nachalo();
    }

    public void nachalo() {
        setContentView(R.layout.activity_russian);

        teorBtn = (Button) findViewById(R.id.teorBtn);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.teorBtn:
                        rus_activity();
                        break;
                }
            }
        };
        teorBtn.setOnClickListener(onClickListener);

    }
    public void rus_activity() {
        setContentView(R.layout.rus);
        Button A1btn;
        Button A2btn;


        A1btn = (Button) findViewById(R.id.teorA1btn);
        A2btn = (Button) findViewById(R.id.teorA2btn);
        View.OnClickListener clickRusTeor = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.teorA1btn:
                        rusactivityudareniya();
                        break;

                    case R.id.teorA2btn:
                        a2();
                        break;
                }
            }
        };
        A1btn.setOnClickListener(clickRusTeor);
        A2btn.setOnClickListener(clickRusTeor);

    }
    public void rusactivityudareniya() {
        setContentView(R.layout.rus_udarenya);

         lvudar = (ListView) findViewById(R.id.lvudar);

        Scanner ns = null;
        try {
            ns = new Scanner(getAssets().open("Udarenia.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ss=0;
        while (ns.hasNextLine()==true) {
            ns.nextLine();
            ss=ss+1;
        }
        ns.close();
        String[] arr = new String[ss];

        Scanner ns2 = null;
        try {
            ns2 = new Scanner(getAssets().open("Udarenia.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0; i<ss; i++) {
            String temp = ns2.nextLine();
            StringBuffer strg = new StringBuffer(temp);
            char[] str = temp.toCharArray();
            int pos = 0;
            for(int j = 0; j < str.length; j++){
                if(Character.isUpperCase(str[j])){
                    str[j] = Character.toLowerCase(str[j]);
                    pos = j+1;
                    break;
                }
            }
            strg.setCharAt(pos-1, Character.toLowerCase(strg.charAt(pos-1)));
            strg.insert(pos, "́");
            arr[i] = strg.toString();
        }
        ns2.close();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        lvudar.setAdapter(adapter);
    }

    public void a2(){
        Intent intent = new Intent(this, A2.class);
        startActivity(intent);
    }

}