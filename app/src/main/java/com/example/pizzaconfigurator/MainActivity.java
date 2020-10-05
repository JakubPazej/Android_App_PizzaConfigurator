package com.example.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.basicPizzaType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pizzaName_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("Please select a pizza here") == false) {
            Toast.makeText(parent.getContext(), "You selected " + text, Toast.LENGTH_SHORT).show();
        } /*else {
            Toast.makeText(parent.getContext(), "No pizza selected", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void onSubmitClicked(View view){
        Spinner spinner = (Spinner) findViewById(R.id.basicPizzaType);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        Switch switch1 = (Switch) findViewById(R.id.switch1);

        String message = spinner.getSelectedItem().toString();
        if(checkBox.isChecked()==true) {
            message += "\nWith " + checkBox.getText().toString();
        } else {
            message += "\nNO " + checkBox.getText().toString();
        }
        if(checkBox2.isChecked()==true) {
            message += "\nWith " + checkBox2.getText().toString();
        } else {
            message += "\nNO " + checkBox2.getText().toString();
        }
        if(checkBox3.isChecked()==true) {
            message += "\nWith " + checkBox3.getText().toString();
        } else {
            message += "\nNO " + checkBox3.getText().toString();
        }
        if(switch1.isChecked()==true) {
            message += "\n" + "With Cheesy Crust";
        } else {
            message += "\nNO " + "Cheesy Crust";
        }

        Intent intent = new Intent(this, orderDetailsScene.class);
        intent.putExtra("orderKey", message);
        startActivity(intent);
    }
}