package com.oc.rss.oc_rss;

import android.content.res.Resources;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    private TextView textResult;
    private Button btnRoll;

    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = findViewById(R.id.textTitle);


        if(Resources.getSystem().getConfiguration().locale.getLanguage() == "fr"){
            textTitle.setText("Dé à "+ max + " " + getString(R.string.sided_dice));
        } else {
            textTitle.setText(max + " " + getString(R.string.sided_dice));
        }

        textResult = findViewById(R.id.textResult);
        textResult.setText("");

        btnRoll = findViewById(R.id.buttonRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int roll = random.nextInt(max) + 1;
                textResult.setText(String.valueOf(roll));
            }
        });
    }
}
