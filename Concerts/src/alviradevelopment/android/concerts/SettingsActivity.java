package alviradevelopment.android.concerts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		final EditText zip = (EditText) findViewById(R.id.zipEdit);
		String zipS = zip.getText().toString();
		final EditText phone = (EditText) findViewById(R.id.phoneEdit);
		String phoneS = phone.getText().toString();
		final EditText email = (EditText) findViewById(R.id.emailEdit);
		String emailS = email.getText().toString();
		
		final Button importLib = (Button) findViewById(R.id.importBtn);
		
		//country spinner
		final Spinner countrySpinner = (Spinner) findViewById(R.id.countrySpin);
		ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this,
		        R.array.country_array, android.R.layout.simple_spinner_item);
		countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		countrySpinner.setAdapter(countryAdapter);
		
		//state spinner
		Spinner stateSpinner = (Spinner) findViewById(R.id.stateSpin);
		ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this,
		        R.array.state_array, android.R.layout.simple_spinner_item);
		stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		stateSpinner.setAdapter(stateAdapter);
		
		//city spinner
		Spinner citySpinner = (Spinner) findViewById(R.id.citySpin);
		ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this,
		        R.array.city_array, android.R.layout.simple_spinner_item);
		cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		citySpinner.setAdapter(cityAdapter);
		
		//travel spinner
		Spinner travelSpinner = (Spinner) findViewById(R.id.travelSpin);
		ArrayAdapter<CharSequence> travelAdapter = ArrayAdapter.createFromResource(this,
		        R.array.travel_array, android.R.layout.simple_spinner_item);
		travelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		travelSpinner.setAdapter(travelAdapter);
		
		

		importLib.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent nextIntent = new Intent(SettingsActivity.this,
						ArtistsActivity.class);
				startActivity(nextIntent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
