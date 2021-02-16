package com.example.parstagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.parstagram.fragments.ComposeFragment;
import com.example.parstagram.fragments.PostsFragment;
import com.example.parstagram.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final FragmentManager fragmentManager = getSupportFragmentManager();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigation);

//        btnLogout = findViewById(R.id.btnLogout);
//
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "Attempting to Logout User");
//                ParseUser.logOut();
//                ParseUser currentUser = ParseUser.getCurrentUser();
//                Intent intent = new Intent();
//                setResult(RESULT_OK, intent);
//                finish();
//            }
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // TODO: Update Fragment

                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        // TODO: Update Fragment

                        fragment = new ProfileFragment();
                        break;


                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;

            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }


}