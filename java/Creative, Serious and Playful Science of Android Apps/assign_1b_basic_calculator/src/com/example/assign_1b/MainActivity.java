package com.example.assign_1b;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText ans;
	Operations operation;
	String text = "";
	double operand;
	double store;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ans = (EditText) findViewById(R.id.ans);
		ans.setKeyListener(null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void ButtonOnClick(View v) {		
		switch (v.getId()) {
		case R.id.button1:
			text = text + "1";
			ans.setText(text);
			break;
		case R.id.button2:
			text = text + "2";
			ans.setText(text);
			break;
		case R.id.button3:
			text = text + "3";
			ans.setText(text);
			break;
		case R.id.button4:
			text = text + "4";
			ans.setText(text);
			break;
		case R.id.button5:
			text = text + "5";
			ans.setText(text);
			break;
		case R.id.button6:
			text = text + "6";
			ans.setText(text);
			break;
		case R.id.button7:
			text = text + "7";
			ans.setText(text);
			break;
		case R.id.button8:
			text = text + "8";
			ans.setText(text);
			break;
		case R.id.button9:
			text = text + "9";
			ans.setText(text);
			break;
		case R.id.button10:
			text = text + "0";
			ans.setText(text);
			break;
		case R.id.button11:// dot button
			if (!text.contains(".")) {
				text = text + ".";
			}
			ans.setText(text);
			break;
		// I can't fool-proof invalid inputs without breaking these buttons below (app crashes)
		case R.id.button12:// equal button
			if (!text.matches("")) {
				switch (operation) {
				case add:
					store = Double.parseDouble(text);
					store += operand;
					ans.setText(Double.toString(store));
					break;
				case subtract:
					store = Double.parseDouble(text);
					store = operand - store;
					ans.setText(Double.toString(store));
					break;
				case multiply:
					store = Double.parseDouble(text);
					store *= operand;
					ans.setText(Double.toString(store));
					break;
				case divide:
					store = Double.parseDouble(text);
					store = operand / store;
					ans.setText(Double.toString(store));
					break;
				default:
					break;
				}
			}
			break;
		case R.id.button13:// divide button
			if (!text.matches("")) {
				operation = Operations.divide;
				operand = Double.parseDouble(ans.getText().toString());
				text = "";
			}
			break;
		case R.id.button14:// multiply button
			if (!text.matches("")) {
				operation = Operations.multiply;
				operand = Double.parseDouble(ans.getText().toString());
				text = "";
			}
			break;
		case R.id.button15:// subtract button
			if (!text.matches("")) {
				operation = Operations.subtract;
				operand = Double.parseDouble(ans.getText().toString());
				text = "";
			} else if (!text.contains("-")) {
				text = text + "-";
				ans.setText(text);
			}
			break;
		case R.id.button16:// add button
			if (text.length() > 0) {
				Log.e("4", "error");

				operation = Operations.add;
				operand = Double.parseDouble(ans.getText().toString());
				text = "";
			}
			break;
		case R.id.button17:// clear button
			operand = 0;
			store = 0;
			text = "";
			ans.setText(text);
			break;
		}
	}

	public enum Operations {
		add, subtract, multiply, divide
	}

}
