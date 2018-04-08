package com.sergiu.newfoodorderclient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Sergiu on 4/7/2018.
 */

public class FoodPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlemenuitem);

        // Aici luam variablibele din desen
        TextView foodName = (TextView) findViewById(R.id.foodName);
        TextView foodDesc = (TextView) findViewById(R.id.foodDesc);
        TextView foodPrice = (TextView) findViewById(R.id.foodPrice);
        //

        // Aici am creat un nou obiect de tip food
        Food food1 = new Food("Mancarea lui Sergiu","12 euro", null," Hmmmm ce bun");
        //

        //Aici setam valorile din food1 in desen
   //     foodPrice.setText("15");
   //     foodName.setText(food1.getName());
  //      foodDesc.setText(food1.getDesc());
    }
}
