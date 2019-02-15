package com.example.ekshoonaya;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Instructor extends AppCompatActivity {
ImageView imageView;
TextView textView;
TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
String  ins_name=getIntent().getStringExtra("Ins_name");
int ins_image=getIntent().getIntExtra("Ins_Image_Id",0);
String ins_des=getIntent().getStringExtra("Ins_Decs");


        imageView=findViewById(R.id.ins_imageview);
        textView=findViewById(R.id.ins_nameview);
        textView1=findViewById(R.id.ins_des);
        Picasso.get().load(ins_image).transform(new CircleTransform()).into(imageView);
        textView.setText(ins_name);
        textView1.setText(ins_des);




    }

}
