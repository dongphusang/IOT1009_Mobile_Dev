package com.github.iot1009.lab4_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declaring components
    Button confirm;
    EditText inputField;
    ListView taskList;
    ArrayList<String> tasks;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init components
        confirm = findViewById(R.id.add_button);
        inputField = findViewById(R.id.input_field);
        taskList = findViewById(R.id.task_list);

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        taskList.setAdapter(adapter);

        // assign listeners
        confirm.setOnClickListener(this);
        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
               TextView textView = (TextView)v;
               textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
           }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.add_button)
            addItem(taskList);
    }

    // add item to the listview
    public void addItem(View v) {
        String input = inputField.getText().toString();
        if (input.equals(""))
            inputField.setHint("Enter your task...");
        else
            tasks.add(input);

        adapter.notifyDataSetChanged();
        inputField.setText(""); // set EditText to empty after input
    }

}