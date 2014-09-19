package me.creativei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listTopicsView = (ListView) findViewById(R.id.listTopics);
        final String[] listTopics = getResources().getStringArray(R.array.listTopics);
        listTopicsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String activityName = "me.creativei." + listTopics[position].replace(" ", "") + "Activity";
                try {
                    Class<?> activityClass = Class.forName(activityName);
                    Intent intent = new Intent(MainActivity.this, activityClass);
                    MainActivity.this.startActivity(intent);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
