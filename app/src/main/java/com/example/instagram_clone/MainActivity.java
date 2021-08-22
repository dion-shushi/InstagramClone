package com.example.instagram_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.instagram_clone.fragments.ComposeFragment;
import com.example.instagram_clone.fragments.PostsFragment;
import com.example.instagram_clone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    Button logout_btn, createPost_btn;
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();



    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        logout_btn = findViewById(R.id.logout_btn);
//        createPost_btn = findViewById(R.id.createPost_btn);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        logout_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ParseUser.logOut();
//                ParseUser currentUser = ParseUser.getCurrentUser();
//                if (currentUser == null){
//                    Log.i(TAG, "Successfully logged out");
//                    goToLogIn();
//                }
//            }
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // TODO: UPDATE FRAGMENT
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        // do something here
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        // do something here
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);

//        createPost_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToCreatePost();
//            }
//        });
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