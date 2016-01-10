package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Даниил on 08.01.2016.
 */
public class RusTeorA2 extends AppCompatActivity implements View.OnClickListener{
    ImageView paronimyImage;
    TextView paronimyText;
    ImageView paronimyImageFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rus_teor_a2);

        paronimyImage = (ImageView) findViewById(R.id.paronimyImage);
        paronimyText = (TextView) findViewById(R.id.paronimyText);

        paronimyImage.setOnClickListener(this);
        paronimyText.setOnClickListener(this);
    }

    protected void parominyFull(){
        setContentView(R.layout.paronimy_full);
        paronimyImageFull = (ImageView) findViewById(R.id.paronimyImageFull);
        paronimyImageFull.setOnClickListener(this);
    }




    protected void paronimy(){
        ListView lvParonimy;

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.paronimyImage:
                parominyFull();
                break;
            case R.id.paronimyText:
                paronimy();
                break;
            case R.id.paronimyImageFull:
                startActivity(new Intent(this, RusTeorA2.class));
                break;
        }
    }
}
