package com.example.instagram_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    Button logout_btn, createPost_btn;
    private BottomNavigationView bottomNavigationView;

    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout_btn = findViewById(R.id.logout_btn);
        createPost_btn = findViewById(R.id.createPost_btn);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser == null){
                    Log.i(TAG, "Successfully logged out");
                    goToLogIn();
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // do something here
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_compose:
                        // do something here
                        Toast.makeText(MainActivity.this, "Compose!!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                    default:
                        // do something here
                        Toast.makeText(MainActivity.this, "Profile!!", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        createPost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreatePost();
            }
        });
    }

    private void goToLogIn() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void goToCreatePost() {
        Intent i = new Intent(this, CreatePost.class);
        startActivity(i);
    }
}