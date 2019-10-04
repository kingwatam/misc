package com.example.assign_2anew;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MicroGravity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_micro_gravity);
		WebView webview = (WebView) findViewById(R.id.webView1);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.loadUrl("file:///android_asset/nasa.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.micro_gravity, menu);
		return true;
	}

}
