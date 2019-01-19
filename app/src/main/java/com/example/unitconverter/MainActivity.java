package com.example.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int flag = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etinput = findViewById(R.id.etinput);
        final TextView tvinput = findViewById(R.id.tvinput);
        final TextView tvoutput = findViewById(R.id.tvoutput);
        Button b1 = findViewById(R.id.btsubmit);
        Button b2 = findViewById(R.id.btreverse);
        Button b3 = findViewById(R.id.btreset);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    flag = 0;
                    tvinput.setText("Enter in meters");
                }
                else{
                    flag = 1;
                    tvinput.setText("Enter in kilometers");
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s = etinput.getText().toString();
                    Double n = Double.parseDouble(s);
                    if (flag == 1)
                        s = (n * 1000) + " m";
                    else
                        s = (n / 1000) + " km";
                    tvoutput.setText(s);
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Enter Something!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etinput.setText("");
                tvoutput.setText("");
            }
        });
    }
}
