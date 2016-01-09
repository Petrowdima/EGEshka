package com.evgeny.manko.egeshka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Даниил on 08.01.2016.
 */
public class A2 extends AppCompatActivity {
    ImageView paronimyImage;
    TextView paronimyText;
    ImageView paronimyImageFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        paronimyImage = (ImageView)  findViewById(R.id.paronimyImage);
        paronimyText = (TextView)  findViewById(R.id.paronimyText);
        paronimyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(A2.this, ParonimyFull.class));
            }
        }) ;
        paronimyText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              startActivity(new Intent(A2.this, Paronimy.class));
            }
        });

    }

}
