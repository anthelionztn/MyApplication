package com.example.tunan.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private Button button;
    private CheckBox eatBox;
    private CheckBox sleepBox;
    private CheckBox dotaBox;
    private int cnt = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        ButtonListener bl = new ButtonListener();
        button.setOnClickListener(bl);

        eatBox = (CheckBox)findViewById(R.id.eatID);
        sleepBox = (CheckBox)findViewById(R.id.sleepID);
        dotaBox = (CheckBox)findViewById(R.id.dotaID);

        BoxListener bol = new BoxListener();
        eatBox.setOnClickListener(bol);
        sleepBox.setOnClickListener(bol);
        dotaBox.setOnClickListener(bol);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ButtonListener implements View.OnClickListener{//内部类

        public void onClick(View v) {
            cnt++;
            textView.setText(cnt+"");
        }
    }
    class BoxListener implements View.OnClickListener{

        public void onClick(View v) {
            int id = v.getId();
            CheckBox box = (CheckBox)v;
            if(box.isChecked()){
                switch (id){
                    case R.id.eatID:
                        textView.setText("I'm eating!");break;
                    case R.id.sleepID:
                        textView.setText("I'm sleeping!");break;
                    default:
                        textView.setText("I'm playing dota!");
                }
            }

        }
    }
}
