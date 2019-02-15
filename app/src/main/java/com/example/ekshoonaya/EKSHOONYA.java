package com.example.ekshoonaya;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class EKSHOONYA extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Item> arrayList;
    RecyclerView recyclerView;
    Custom_Adapter custum_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("EKSHOONYA");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        arrayList = new ArrayList<>();
        init(arrayList);
        recyclerView = findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        custum_adapter = new Custom_Adapter(arrayList, this, new Custom_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent=new Intent(EKSHOONYA.this,Instructor.class);
                Item item=arrayList.get(position);
                intent.putExtra("Ins_name",item.inst_name);
                intent.putExtra("Ins_Image_Id",item.ins_image);
                intent.putExtra("Ins_Decs",item.ins_desc);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(custum_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notification) {
            Intent intent=new Intent(EKSHOONYA.this,NOTIFICATION.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

      /*  if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
        }
*/
        if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void init(ArrayList<Item> arrayList) {
        arrayList.add(new Item(R.drawable.s_medi_pic, "Meditation","MANISH KHANDELWAL","IIT(Delhi)",R.drawable.manish));
        arrayList.add(new Item(R.drawable.s_dance, "Dance","SHAKTI SINGH","Choreographer",R.drawable.sakti_sing));
        arrayList.add(new Item(R.drawable.s_datascience, "Data Science","ASHISH SONI","IIT(Bombay)",R.drawable.ashish_soni));
        arrayList.add(new Item(R.drawable.s_english, "English","RAVI KHANDELWAL","B.Tech In EC.",R.drawable.ravi));
        arrayList.add(new Item(R.drawable.s_gmap, "Google Map","MANISH KHANDELWAL","IIT(Delhi)",R.drawable.manish));
        arrayList.add(new Item(R.drawable.s_maths_eins, "Maths","RAVI KHANDELWAL","B.Tech In EC.",R.drawable.ravi));
        //arrayList.add(new Item(R.drawable.s_math2, "tstststsst"));

    }
}
