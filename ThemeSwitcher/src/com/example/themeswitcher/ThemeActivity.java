package com.example.themeswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;


public class ThemeActivity extends Activity {
	private Spinner spThemes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Utils.onActivityCreateSetTheme(this);
		setContentView(R.layout.activity_theme);
		setupSpinnerItemSelection();
	}

	private void setupSpinnerItemSelection() {
		spThemes = (Spinner) findViewById(R.id.spThemes);
		spThemes.setSelection(ThemeApplication.currentPosition);
		ThemeApplication.currentPosition = spThemes.getSelectedItemPosition();

		spThemes.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (ThemeApplication.currentPosition != position) {
					Utils.changeToTheme(ThemeActivity.this, position);
				}
				ThemeApplication.currentPosition = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}
}