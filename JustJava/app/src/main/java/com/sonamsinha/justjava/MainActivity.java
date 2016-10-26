package com.sonamsinha.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    /**
     * This app displays an order form to order coffee.
     */

    int quantity = 1;
    int price = 0;
    TextView priceTextView;
    TextView quantityTextView;
    Spinner spinner;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // SPINNER CODE
        spinner = (Spinner) findViewById(R.id.coffee_spinner);

        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.coffe_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //int quantity = 2;
        String priceMessage = "Thank you!";
        display(quantity);
        price = quantity * 5;
        displayPrice(price, priceMessage);
        //String priceMessage = "Thank you!";
        //displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number, String msg) {
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Amount due: " +NumberFormat.getCurrencyInstance().format(number) + "\n" + msg);
    }

    public void increment(View view) {
        //int quantity = 2;
        quantity += 1;
        display(quantity);
    }

    public void decrement(View view) {
        //int quantity = 2;
        if(quantity > 0) {
            quantity -= 1;
        }
        display(quantity);
    }

    public void reset(View view){
        quantity = 0;
        priceTextView.setText("");
        quantityTextView.setText("" + quantity);
        spinner.setSelection(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        /*if ("Choose..".equalsIgnoreCase(item)){
            item = "";
        }*/

        // Displaying selected item in a TextView
        resultText = (TextView) findViewById(R.id.items_display);
        resultText.setText(" " + item);
        // showing a toast on selecting an item
        Toast.makeText(parent.getContext(), item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*public void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }*/

}
