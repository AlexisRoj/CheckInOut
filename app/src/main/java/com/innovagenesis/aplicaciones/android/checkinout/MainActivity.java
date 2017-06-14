package com.innovagenesis.aplicaciones.android.checkinout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.checkinout.fragments.PrincipalFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FloatingActionButton fab;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fab.setImageResource(R.drawable.ic_clientes);

                    return true;
        /*        case R.id.navigation_dashboard:

                    fab.setImageResource(R.drawable.ic_acuerdos);
                    return true;*/
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
        //navigation.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new PrincipalFragment())
                .commit();


    }

}
