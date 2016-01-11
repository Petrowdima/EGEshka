package com.evgeny.manko.egeshka;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Random;

/**
 * Created by danildovgal on 07.01.2016.
 */
public class RusTest extends AppCompatActivity {


    Button btnRusVopr, btnRusVopr2;
    TextView tvRusVopr, tvRusVopr2;
    CheckBox chb1, chb2, chb3, chb4;
    DBhelper sqlHelper;
    Cursor cursor;
    EditText etRusVopr2;
    int sh, ans;
    String otvet;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random random = new Random();
        int ss = random.nextInt(2);
        switch (ss) {
            case 0:
                voprosi_rus_1();
                break;
            case 1:
                voprosi_rus_2();
                break;
        }
    }

    public void voprosi_rus_1() {

        setContentView(R.layout.voprosi_rus_1);
        tvRusVopr = (TextView) findViewById(R.id.tvRusVopr);
        chb1 = (CheckBox) findViewById(R.id.chb1);
        chb2 = (CheckBox) findViewById(R.id.chb2);
        chb3 = (CheckBox) findViewById(R.id.chb3);
        chb4 = (CheckBox) findViewById(R.id.chb4);
        btnRusVopr = (Button) findViewById(R.id.btnRusVopr);


        final Random random = new Random();

        sqlHelper = new DBhelper(getApplicationContext());

        super.onResume();

        try {
            sqlHelper.open();
            Integer gh=0;
            cursor = sqlHelper.database.rawQuery("select id from RUSvoprosi1" , null);
            cursor.moveToLast();
            gh = cursor.getInt(0);
            int ran = random.nextInt(gh);
            cursor = sqlHelper.database.rawQuery("select * from RUSvoprosi1 where id="+(ran+1), null);
            cursor.moveToFirst();
            tvRusVopr.setText(cursor.getString(2));
            chb1.setText(cursor.getString(3));
            chb2.setText(cursor.getString(4));
            chb3.setText(cursor.getString(5));
            chb4.setText(cursor.getString(6));
            ans = cursor.getInt(1);
            otvet = cursor.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ans == 1) {
            View.OnClickListener onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.chb1:
                            chb2.setChecked(false);
                            chb3.setChecked(false);
                            chb4.setChecked(false);
                            break;
                        case R.id.chb2:
                            chb1.setChecked(false);
                            chb3.setChecked(false);
                            chb4.setChecked(false);
                            break;
                        case R.id.chb3:
                            chb2.setChecked(false);
                            chb1.setChecked(false);
                            chb4.setChecked(false);
                            break;
                        case R.id.chb4:
                            chb2.setChecked(false);
                            chb3.setChecked(false);
                            chb1.setChecked(false);
                            break;
                        case R.id.btnRusVopr:
                            if (chb1.isChecked() || chb2.isChecked() || chb3.isChecked() || chb4.isChecked()) {
                                int a = random.nextInt(2);
                                if (a == 0) {
                                    voprosi_rus_1();
                                } else {
                                    voprosi_rus_2();
                                }


                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Вы не выбрали ответ", Toast.LENGTH_SHORT);
                                toast.show();
                            }

                            break;
                    }
                }

            };
            chb1.setOnClickListener(onClickListener);
            chb2.setOnClickListener(onClickListener);
            chb3.setOnClickListener(onClickListener);
            chb4.setOnClickListener(onClickListener);
            btnRusVopr.setOnClickListener(onClickListener);
        }


        if (ans == 2) {
            View.OnClickListener onClickListener2 = new View.OnClickListener() {
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.chb1:
                            if ((!chb2.isChecked() && chb3.isChecked() && chb4.isChecked()) ||
                                    (!chb3.isChecked() && chb2.isChecked() && chb4.isChecked()) ||
                                    (!chb4.isChecked() && chb3.isChecked() && chb2.isChecked())) {
                                if (sh == 2) {
                                    chb2.setChecked(false);
                                }
                                if (sh == 3) {
                                    chb3.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }
                            }
                            sh = 1;
                            break;
                        case R.id.chb2:
                            if ((!chb1.isChecked() && chb3.isChecked() && chb4.isChecked()) ||
                                    (!chb3.isChecked() && chb1.isChecked() && chb4.isChecked()) ||
                                    (!chb4.isChecked() && chb3.isChecked() && chb1.isChecked())) {
                                if (sh == 1) {
                                    chb1.setChecked(false);
                                }
                                if (sh == 3) {
                                    chb3.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }
                            }
                            sh = 2;
                            break;
                        case R.id.chb3:
                            if ((!chb2.isChecked() && chb1.isChecked() && chb4.isChecked()) ||
                                    (!chb1.isChecked() && chb2.isChecked() && chb4.isChecked()) ||
                                    (!chb4.isChecked() && chb1.isChecked() && chb2.isChecked())) {
                                if (sh == 2) {
                                    chb2.setChecked(false);
                                }
                                if (sh == 1) {
                                    chb1.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }
                            }
                            sh = 3;
                            break;
                        case R.id.chb4:
                            if ((!chb2.isChecked() && chb3.isChecked() && chb1.isChecked()) ||
                                    (!chb3.isChecked() && chb2.isChecked() && chb1.isChecked()) ||
                                    (!chb1.isChecked() && chb3.isChecked() && chb2.isChecked())) {
                                if (sh == 2) {
                                    chb2.setChecked(false);
                                }
                                if (sh == 3) {
                                    chb3.setChecked(false);
                                }
                                if (sh == 1) {
                                    chb1.setChecked(false);
                                }
                            }
                            sh = 4;
                            break;
                        case R.id.btnRusVopr:
                            if ((chb1.isChecked() && chb2.isChecked()) ||
                                    (chb1.isChecked() && chb3.isChecked()) ||
                                    (chb1.isChecked() && chb4.isChecked()) ||
                                    (chb2.isChecked() && chb3.isChecked()) ||
                                    (chb2.isChecked() && chb4.isChecked()) ||
                                    (chb3.isChecked() && chb4.isChecked())) {
                                int a = random.nextInt(2);
                                if (a == 0) {
                                    voprosi_rus_1();
                                } else {
                                    voprosi_rus_2();
                                }

                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Вы выбрали не все ответы", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            break;
                    }
                }
            };
            chb1.setOnClickListener(onClickListener2);
            chb2.setOnClickListener(onClickListener2);
            chb3.setOnClickListener(onClickListener2);
            chb4.setOnClickListener(onClickListener2);
            btnRusVopr.setOnClickListener(onClickListener2);
        }
        if (ans == 3) {
            View.OnClickListener onClickListener3 = new View.OnClickListener() {
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.chb1:
                            if (chb2.isChecked() && chb3.isChecked() && chb4.isChecked())
                                     {
                                if (sh == 2) {
                                    chb2.setChecked(false);
                                }
                                if (sh == 3) {
                                    chb3.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }

                            }
                            sh=1;

                            break;
                        case R.id.chb2:
                            if (chb1.isChecked() && chb3.isChecked() && chb4.isChecked()) {
                                if (sh == 1) {
                                    chb1.setChecked(false);
                                }
                                if (sh == 3) {
                                    chb3.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }
                            }
                            sh=2;

                            break;
                        case R.id.chb3:
                            if (chb2.isChecked() && chb1.isChecked() && chb4.isChecked()) {
                                if (sh == 2) {
                                    chb2.setChecked(false);
                                }
                                if (sh == 1) {
                                    chb1.setChecked(false);
                                }
                                if (sh == 4) {
                                    chb4.setChecked(false);
                                }

                            }
                            sh=3;

                                break;
                                case R.id.chb4:
                                    if (chb2.isChecked() && chb3.isChecked() && chb1.isChecked()) {
                                        if (sh == 2) {
                                            chb2.setChecked(false);
                                        }
                                        if (sh == 3) {
                                            chb3.setChecked(false);
                                        }
                                        if (sh == 1) {
                                            chb1.setChecked(false);
                                        }

                                    }
                                    sh=4;

                                    break;
                                case R.id.btnRusVopr:
                                    if (chb2.isChecked() && chb3.isChecked() && chb4.isChecked()) {

                                        int a = random.nextInt(2);
                                        if (a == 0) {
                                            voprosi_rus_1();
                                        } else {
                                            voprosi_rus_2();
                                        }
                                    }
                                    else {
                                        Toast toast = Toast.makeText(getApplicationContext(),
                                                "Вы выбрали не все ответы", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }

                                    break;
                            }

                    }

                };

            chb1.setOnClickListener(onClickListener3);
            chb2.setOnClickListener(onClickListener3);
            chb3.setOnClickListener(onClickListener3);
            chb4.setOnClickListener(onClickListener3);
            btnRusVopr.setOnClickListener(onClickListener3);

            }


        }





                public void voprosi_rus_2() {
                    setContentView(R.layout.voprosi_rus_2);


                    btnRusVopr2 = (Button) findViewById(R.id.btnRusVopr2);
                    tvRusVopr2 = (TextView) findViewById(R.id.tvRusVopr2);
                    etRusVopr2 = (EditText) findViewById(R.id.etRusVopr2);
                    etRusVopr2.setText("");
                    final Random random = new Random();


                    sqlHelper = new DBhelper(getApplicationContext());

                    super.onResume();
                    try {
                        sqlHelper.open();
                        Integer gh=0;
                        cursor = sqlHelper.database.rawQuery("select id from RUSvoprosi2" , null);
                        cursor.moveToLast();
                        gh = cursor.getInt(0);
                        int ran = random.nextInt(gh);
                        cursor = sqlHelper.database.rawQuery("select * from RUSvoprosi2 where id="+(ran+1), null);
                        cursor.moveToFirst();
                        tvRusVopr2.setText(cursor.getString(1));





                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



                    View.OnClickListener onClickListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (view.getId()) {
                                case R.id.btnRusVopr2:
                                    String bb = etRusVopr2.getText().toString();
                                    if (!bb.matches("")) {
                                        int a = random.nextInt(2);
                                        if (a == 0) {
                                            voprosi_rus_1();
                                        } else {
                                            voprosi_rus_2();
                                        }

                                    } else {
                                        Toast toast = Toast.makeText(getApplicationContext(),
                                                "Вы не написали ответ", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                    break;
                            }
                        }
                    };
                    btnRusVopr2.setOnClickListener(onClickListener);
                }
            }
