package com.example.ekshoonaya;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<CountryItem> countrylist;
    private CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        Spinner spinner=findViewById(R.id.spinner);
       countryAdapter= new CountryAdapter(this,countrylist);
       spinner.setAdapter(countryAdapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               CountryItem clickItem=(CountryItem) parent.getItemAtPosition(position);

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });



    }

    private void initList() {
countrylist =new ArrayList<>();
countrylist.add(new CountryItem("+61",R.drawable.ic_austraila));
        countrylist.add(new CountryItem("+55",R.drawable.ic_brazil));
        countrylist.add(new CountryItem("+1",R.drawable.ic_canada));
        countrylist.add(new CountryItem("+86",R.drawable.ic_china));
        countrylist.add(new CountryItem("+49",R.drawable.ic_germany));
        countrylist.add(new CountryItem("+91",R.drawable.ic_india));
        countrylist.add(new CountryItem("+81",R.drawable.ic_japan));
        countrylist.add(new CountryItem("+1",R.drawable.ic_usa));
        countrylist.add(new CountryItem("+44",R.drawable.ic_uk));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
