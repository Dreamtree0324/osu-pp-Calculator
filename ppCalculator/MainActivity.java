package com.example.administrator.ppcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText starET;
    EditText odET;
    EditText scoreET;
    EditText accET;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starET = (EditText) findViewById(R.id.starET);
        odET = (EditText) findViewById(R.id.odET);
        scoreET = (EditText) findViewById(R.id.scoreET);
        accET = (EditText) findViewById(R.id.accET);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        double d = Double.parseDouble(starET.getText().toString());
        double od = Double.parseDouble(odET.getText().toString());
        int h = Integer.parseInt(scoreET.getText().toString());
        double i = Double.parseDouble(accET.getText().toString());

        double f = 64 - 3*od;
        double k = Math.pow((150/f)*Math.pow(i/100,16),1.8)*2.5*Math.min(1.15,Math.pow(1000/1500,0.3));
        double l = (Math.pow(5*Math.max(1,d/0.0825)-4,3)/110000)*(1+0.1*Math.min(1,1000/1500));
        double m =  (h<500000) ? h/500000*0.1 :
                    ((h<600000) ? (h-500000)/100000*0.2+0.1 :
                    ((h<700000) ? (h-600000)/100000*0.35+0.3 :
                    ((h<800000) ? (h-700000)/100000*0.2+0.65 :
                    ((h<900000) ? (h-800000)/100000*0.1+0.85 :
                    (h-900000)/100000*0.05+0.95))));

        if(h > 1000000){
            Toast.makeText(getApplicationContext(), "점수는 100만점을 초과할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(h < 0){
            Toast.makeText(getApplicationContext(), "점수는 음수값일 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(od > 10.0){
            Toast.makeText(getApplicationContext(), "OD는 10을 초과할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(od < 0.0){
            Toast.makeText(getApplicationContext(), "OD는 음수값일 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(i > 100.0){
            Toast.makeText(getApplicationContext(), "ACC는 100%를 초과할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(i < 0.0){
            Toast.makeText(getApplicationContext(), "ACC는 음수 일 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(d < 0.0){
            Toast.makeText(getApplicationContext(), "StarRating은 음수 일 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else{
            double pp = Math.round(Math.pow(Math.pow(k,1.1)+Math.pow(l*m,1.1),1/1.1)*1.1);
            Intent intent = new Intent(getApplication(), Main2Activity.class);
            intent.putExtra("result", pp);
            startActivity(intent);
        }


    }
}
