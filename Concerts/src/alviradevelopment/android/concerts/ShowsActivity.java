package alviradevelopment.android.concerts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class ShowsActivity extends Activity {

	TextView artist;
	TextView showDisp;
	ListView showList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shows);

		showList = (ListView) findViewById(R.id.showsListV);

		String name = getIntent().getExtras().getString("selection");

		artist = (TextView) findViewById(R.id.artistNameSView);
		artist.setText(name);

		showDisp = (TextView) findViewById(R.id.showNoView);
		CrawlerActivity crawl = new CrawlerActivity();
		String returned;

		try {
			returned = crawl.getInternetData();
			showDisp.setText(returned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shows, menu);
		return true;
	}

}
