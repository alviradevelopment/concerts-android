package alviradevelopment.android.concerts;

import java.util.ArrayList;
import java.util.Arrays;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Artists;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ArtistsActivity extends ListActivity {

	ListView artView;
	SimpleCursorAdapter adapter;
	String[] fromColumns = { MediaStore.Audio.Artists.ARTIST };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_artists);

		artView = (ListView) findViewById(R.id.artistsListV);

		final Cursor cursor = getContentResolver().query(
				Artists.EXTERNAL_CONTENT_URI,
				new String[] { Artists._ID, Artists.ARTIST }, null, null, null);
		startManagingCursor(cursor);

		int[] toViews = { R.id.artistNameView3 };
		adapter = new SimpleCursorAdapter(this, R.layout.activity_artists2,
				cursor, fromColumns, toViews, 0);
		artView = getListView();
		artView.setAdapter(adapter);
		

		artView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				String selection = ((Cursor)artView.getAdapter().getItem(position)).getString(1);				
				Intent nextIntent = new Intent(getApplicationContext(), ShowsActivity.class);
				nextIntent.putExtra("selection", selection);
				startActivity(nextIntent);

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artists, menu);
		return true;
	}

}
