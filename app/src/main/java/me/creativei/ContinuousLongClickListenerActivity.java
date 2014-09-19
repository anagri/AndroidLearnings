package me.creativei;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import me.creativei.listener.ContinuousLongClickListener;


public class ContinuousLongClickListenerActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuous_long_click_listener);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final TextView textView = (TextView) findViewById(R.id.txtCurrentValue);

        View btnUp = findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
                int newValue = currentValue + 1;
                textView.setText(String.valueOf(newValue));
            }
        });

        new ContinuousLongClickListener(btnUp, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
                int newValue = currentValue + 10;
                textView.setText(String.valueOf(newValue));
                return false;
            }
        });
        View btnDown = findViewById(R.id.btnDown);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
                int newValue = currentValue - 1;
                textView.setText(String.valueOf(newValue));
            }
        });

        new ContinuousLongClickListener(btnDown, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
                int newValue = currentValue - 10;
                textView.setText(String.valueOf(newValue));
                return false;
            }
        });
    }
}
