package com.evgeny.manko.egeshka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Даниил on 08.01.2016.
 */
public class Paronimy extends AppCompatActivity {
    ListView lvParonimy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paronimy_list);
        lvParonimy = (ListView) findViewById(R.id.lvParonimy);

        Scanner ns = null;
        try {
            ns = new Scanner(getAssets().open("paronimy.txt"));
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
        Log.d("myLogs", String.valueOf(ss));

        Scanner ns2 = null;


        try {
            ns2 = new Scanner(getAssets().open("paronimy.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0; i<ss; i++) {
            String temp = ns2.nextLine();
            StringBuffer strg = new StringBuffer(temp);

            arr[i] = strg.toString();
        }
        ns2.close();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        lvParonimy.setAdapter(adapter);
    }
}
