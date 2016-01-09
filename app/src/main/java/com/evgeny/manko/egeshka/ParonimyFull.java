package com.evgeny.manko.egeshka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Даниил on 08.01.2016.
 */
public class ParonimyFull extends AppCompatActivity {
    ImageView paronimyImageFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paronimy_full);
        paronimyImageFull = (ImageView) findViewById(R.id.paronimyImageFull);
        paronimyImageFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
