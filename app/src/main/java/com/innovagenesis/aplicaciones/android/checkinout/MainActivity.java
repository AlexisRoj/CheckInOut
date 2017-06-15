package com.innovagenesis.aplicaciones.android.checkinout;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.checkinout.colores.AdminColor;
import com.innovagenesis.aplicaciones.android.checkinout.fragments.PrincipalFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FloatingActionButton fab;

    Window window;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            window = getWindow();

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        window.setStatusBarColor( // Cambia la barra
                                ContextCompat.getColor(MainActivity.this,
                                        AdminColor.COLOR_CLIENTE));

                        window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this,
                                AdminColor.COLOR_CLIENTE));

                    }
                    fab.setImageResource(R.drawable.ic_clientes);

                    return true;

                case R.id.navigation_notifications:

                    fab.setImageResource(R.drawable.ic_precios);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new PrincipalFragment())
                .commit();

    }

}
