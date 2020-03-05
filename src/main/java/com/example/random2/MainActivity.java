package com.example.random2;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.lang.String;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private ConstraintLayout layout;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set attributes to identify ID for page layout, button, textview
        layout= (ConstraintLayout)findViewById(R.id.layout);
        button = findViewById(R.id.button);
        textView2 =(TextView) findViewById(R.id.textView2);


        //button click actions
        button.setOnClickListener(new View.OnClickListener() {
            private Object DbManager;

            @Override
            public void onClick(View view) {
                // new instance fo the radom function
                Random random = new Random();
                // randomizing the color
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                layout.setBackgroundColor(color);
                // new instance of random
                Random rand = new Random();
                // generate random number between 0-1000 ad convert to string
                String b = String.valueOf(rand.nextInt(1000));
                // update textview with random number between 0-1000
                textView2.setText(b);

                //instnace of dbhelper clss to insert objects into database
                DbHelper dbHandler = new DbHelper(MainActivity.this);
                dbHandler.insertUserDetails(color,b);

                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();

        }

        });

        //start database activity






        // end of button fucntionality


            }
        }



