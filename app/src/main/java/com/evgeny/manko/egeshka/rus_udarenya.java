package com.evgeny.manko.egeshka;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by danil on 07.01.2016.
 */
public class rus_udarenya extends Activity {


    ListView lvudar;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            arr[i] = ns2.nextLine();
        }
        ns2.close();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        lvudar.setAdapter(adapter);

    }

}
