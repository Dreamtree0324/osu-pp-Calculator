package com.example.administrator.ppcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textview = (TextView) findViewById(R.id.textview);

        Intent intet = getIntent();
        textview.setText(Double.toString(getIntent().getDoubleExtra("result",0.0)));

        Button btnReturn = (Button)findViewById(R.id.retry);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button osuPage = (Button) findViewById(R.id.osuPage);
        osuPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://osu.ppy.sh/"));
                startActivity(intent);
            }
        });
    }
}
