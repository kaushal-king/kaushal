package com.appsnipp.loginsamples.Navigation_Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.appsnipp.loginsamples.Navigation_Profile.ui.account.AccountFragment;
import com.appsnipp.loginsamples.Navigation_Profile.ui.dashboard.DashBoardFragment;
import com.appsnipp.loginsamples.Navigation_Profile.ui.resource.ResourceFragment;
import com.appsnipp.loginsamples.Navigation_Profile.ui.document.DocumentFragment;
import com.appsnipp.loginsamples.Navigation_Profile.ui.members.MembersFragment;
import com.appsnipp.loginsamples.Navigation_Profile.ui.electionandpoll.ElectionFragment;
import com.appsnipp.loginsamples.R;

public class Navigation_Activity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    Fragment fragment;
    FragmentManager manager;
    FragmentTransaction transaction;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_member,
                R.id.nav_election, R.id.nav_document, R.id.nav_resource)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Activity is refresh", Toast.LENGTH_SHORT).show();
            fragment = new DashBoardFragment();


        } else if (id == R.id.nav_account) {
            fragment = new AccountFragment();


        } else if (id == R.id.nav_member) {
            fragment = new MembersFragment();

        } else if (id == R.id.nav_election) {
            fragment = new ElectionFragment();

        } else if (id == R.id.nav_document) {
            fragment = new DocumentFragment();

        } else if (id == R.id.nav_resource) {
            fragment = new ResourceFragment();


        }
        transaction = manager.beginTransaction();
        transaction.add(R.id.nav_host_fragment, fragment, "A");
        transaction.addToBackStack("addA");
        transaction.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    }

