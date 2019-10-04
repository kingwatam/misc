package com.example.assign_2anew;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Jabberwocky extends Activity {
	WebView webview;
	View view;
	MediaPlayer bgMusic;
	boolean isPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		webview = (WebView) findViewById(R.id.webView1);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.loadUrl("file:///android_asset/jabberwocky.html");
		isPhoto = false;
		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent browser = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
				startActivity(browser);
			}
		});
		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (!isPhoto) {
					webview.loadUrl("file:///android_asset/Jabberwocky.jpg");
					isPhoto = true;
				} else {
					webview.loadUrl("file:///android_asset/jabberwocky.html");
					isPhoto = false;
				}
			}
		});
		bgMusic = MediaPlayer.create(this, R.raw.egmontovertureexerpt);
	}

	@Override
	protected void onResume() {
		bgMusic.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		bgMusic.pause();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}

}
