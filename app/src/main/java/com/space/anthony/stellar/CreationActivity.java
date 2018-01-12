package com.space.anthony.stellar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreationActivity extends AppCompatActivity {

	FirebaseDatabase database;
	DatabaseReference myRef;
	StellarSystem system;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creation);

		createSystem();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Intent intent = new Intent(CreationActivity.this, LoopActivity.class);
		finish();
		startActivity(intent);
	}

	private void createSystem() {
		Toast.makeText(CreationActivity.this, "createSystem", Toast.LENGTH_SHORT).show();
		system = new StellarSystem();
		system.setName("Céléno");

		database = FirebaseDatabase.getInstance();
		myRef = database.getReference("message");
		myRef.setValue(system);
	}
}
