package com.evgeny.manko.egeshka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;


/**
 * Created by danil on 07.01.2016.
 */


public class rus extends Activity {


    ListView listview;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rus);
        listview = (ListView) findViewById(R.id.listview);

        final String[] rus_list = {"Ударения", "Тест"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, rus_list);
        listview.setAdapter(adapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg1, long arg2) {
                switch (arg1) {
                    case 0:
                        Intent intent2 = new Intent(getApplicationContext(), rus_udarenya.class);
                        startActivity(intent2);
                        break;
                    case 1:
                            Intent intent3 = new Intent(getApplicationContext(), voprosi_rus.class);
                            startActivity(intent3);
                        break;

                }
            }
        };
        listview.setOnItemClickListener(onItemClickListener);
    }
}
