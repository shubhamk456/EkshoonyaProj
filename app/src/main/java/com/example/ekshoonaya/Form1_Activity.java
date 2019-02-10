package com.example.ekshoonaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Form1_Activity extends AppCompatActivity {
    private ArrayList<CountryItem> countrylist;
    private CountryAdapter countryAdapter;
    EditText editText;
    Spinner spinner;
    String countrycode;
    String num;
Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1_);
        initList();
        spinner=findViewById(R.id.spinner1);
        countryAdapter= new CountryAdapter(this,countrylist);
        spinner.setAdapter(countryAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickItem=(CountryItem) parent.getItemAtPosition(position);
countrycode=clickItem.getCountrycode();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        editText=findViewById(R.id.editText3);

        button=findViewById(R.id.buttonform);
                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    num=editText.getText().toString();

                if (num.isEmpty() || num.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }
                String phoneNumber =countrycode+ num;



                Intent intent =new Intent(Form1_Activity.this,OtpActivity.class);
                intent.putExtra("PhoneNumber",phoneNumber);
                startActivity(intent);

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

}
