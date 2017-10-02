package me.xlogix.coffeeordering;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /**
   * This method is called when the order button is clicked.
   */
  int quantity = 1;
  int whip = 1;
  int choco = 2;
  int price = 5;


  public void resetOrder(View view) {
    EditText nameVariable = (EditText) findViewById(R.id.edit_textview_name);
    nameVariable.setText("");
  }

  public void submitOrder(View view) {
    EditText nameVariable = (EditText) findViewById(R.id.edit_textview_name);
    String value = nameVariable.getText().toString();
    CheckBox wipcreamVariable = (CheckBox) findViewById(R.id.whipcream);
    boolean hasWhipcream = wipcreamVariable.isChecked();
    CheckBox chcocVariable = (CheckBox) findViewById(R.id.choco);
    boolean haschocolate = chcocVariable.isChecked();
    if (hasWhipcream) {
      price = price + whip;
    }
    if (haschocolate) {
      price = price + choco;
    }

    String orderMessage = orderSummary(haschocolate, hasWhipcream, value);
    displayMessage(orderMessage);
  }

  public String orderSummary(boolean addchoco, boolean addwhip, String value) {
    int finalPrice;
    finalPrice = quantity * price;
    String message = "Name: "
        + value
        + "\nQuantity: "
        + quantity
        + "\nAdd a whipcream: "
        + addwhip
        + "\nAdd a Chocolate: "
        + addchoco
        + "\nTotal: Rs"
        + finalPrice
        + "\nThank You!";
    return message;
  }

  // This Method will display the given text

  private void displayMessage(String Message) {
    TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
    priceTextView.setText(Message);
  }

  /**
   * This method displays the given quantity value on the screen.
   */
  private void display(int number) {
    TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
    quantityTextView.setText("" + number);
  }

  /**
   * This method displays the given price on the screen.
   */

  // increment method to increment the number of coffees
  public void increment(View view) {
    //int quantity = 2;
    if (quantity == 100) {
      Toast.makeText(this, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT).show();
      return;
    }
    quantity = quantity + 1;
    display(quantity);
  }

  // to decrement the number of coffees

  public void decrement(View view) {
    //int quantity = 2;
    if (quantity == 1) {
      Toast.makeText(this, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT).show();
      return;
    }
    quantity = quantity - 1;
    display(quantity);
  }

  private void displayPrice(int number) {
    TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
    priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
  }

  // order summary method
   /* public void orderSummary()
    {

    }*/
}
