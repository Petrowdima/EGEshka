package com.evgeny.manko.egeshka;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.provider.MediaStore;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class RussianActivity extends AppCompatActivity {

    Button teorBtn;
    ListView listview;
    Button button;
    ListView lvudar;
    FileInputStream lol;

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


        A1btn = (Button) findViewById(R.id.teorA1btn);
        View.OnClickListener clickRusTeor = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.teorA1btn:
                        rusactivityudareniya();
                        break;
                }
            }
        };
        A1btn.setOnClickListener(clickRusTeor);

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
        String line;

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

}