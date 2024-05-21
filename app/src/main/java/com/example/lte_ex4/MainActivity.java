package com.example.lte_ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class
MainActivity extends AppCompatActivity{

    private TabLayout tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabBar = findViewById(R.id.tabBar);


        tabBar.addTab(tabBar.newTab().setText("Home Page").setIcon(R.drawable.ic_house));
        tabBar.addTab(tabBar.newTab().setText("Classification").setIcon(R.drawable.ic_launcher_background));
        tabBar.addTab(tabBar.newTab().setText("Shopping Cart").setIcon(R.drawable.ic_launcher_background));

        // 启动显示AppleFragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =
                manager.beginTransaction();
        transaction.replace(R.id.frame_01, new HomePageFragment());
        transaction.commit();

        tabBar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction =
                            manager.beginTransaction();
                    transaction.replace(R.id.frame_01, new HomePageFragment());
                    transaction.commit();
                } else if (tab.getPosition() == 1) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction =
                            manager.beginTransaction();
                    transaction.replace(R.id.frame_01, new ClassificationFragment());
                    transaction.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}