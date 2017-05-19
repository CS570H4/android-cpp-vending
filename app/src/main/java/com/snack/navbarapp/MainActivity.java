package com.snack.navbarapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private SupportMapFragment mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mMap = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMap.getMapAsync(this);//remember getMap() is deprecated!
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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap mMap) {

        // Add a map of CPP and move the camera
        LatLng cpp = new LatLng(34.058929, -117.818898);
        float zoomLevel = 15.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cpp, zoomLevel));

        // Add user marker
        LatLng user = new LatLng(34.058929, -117.818898);
        BitmapDescriptor userIcon = BitmapDescriptorFactory.fromResource(R.mipmap.target_sm);
        mMap.addMarker(new MarkerOptions()
                .position(user)
                .title("You are here")
                .icon(userIcon));

        // Add vending markers
        ArrayList<VenderLocation> vAry = new ArrayList<>();
        vAry.add(new VenderLocation(new LatLng(34.05951, -117.82454), "Bldg. 1", "Bldg. One", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05764, -117.82657), "Bldg. 2", "College of Agriculture", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05785, -117.82595), "Bldg. 3", "Science Laboratory", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05747, -117.82560), "Bldg. 4", "Biotechnology", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05753, -117.82502), "Bldg. 5", "College of Letters, Arts & Social Sciences", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05848, -117.82526), "Bldg. 8", "College of Science", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05894, -117.82209), "Bldg. 9", "College of Engineering", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06231, -117.82048), "Bldg. 20", "Encinitas Residence Hall", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06224, -117.81800), "Bldg. 22", "Alamitos Residence Hall", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06293, -117.81768), "Bldg. 23", "Aliso Residence Hall", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06293, -117.81768), "Bldg. 25", "Drama & Theatre", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05661, -117.82155), "Bldg. 35", "Bronco Student Center", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06109, -117.81114), "Bldg. 45", "Ag. Engr. & Apparel Technology", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06106, -117.82192), "Bldg. 59", "La Cienega", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05470, -117.81849), "Bldg. 60", "Residential Suites", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05481, -117.81804), "Bldg. 61", "Residential Suites", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05595, -117.82063), "Bldg. 66", "Bronco Bookstore", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05671, -117.82467), "Bldg. 76", "Kellogg West Hillside Lodge", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05961, -117.80878), "Bldg. 81", "Facilities Management", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05341, -117.81965), "Bldg. 86", "English Language Institute", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06038, -117.81244), "Bldg. 89", "Interim Design Center", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05784, -117.82348), "Bldg. 97", "Campus Center Marketplace", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05969, -117.82009), "Bldg. 98", "Classroom/Laboratory/Admin", "both"));
        vAry.add(new VenderLocation(new LatLng(34.06086, -117.81580), "Bldg. 109", "Police Department", "both"));
        vAry.add(new VenderLocation(new LatLng(34.04889, -117.81598), "Bldg. 200", "University Village", "both"));
        vAry.add(new VenderLocation(new LatLng(34.05890, -117.82076), "Bldg. 13", "Art Dept./Engineering Annex", "food"));
        vAry.add(new VenderLocation(new LatLng(34.05502, -117.82418), "Bldg. 79", "Collins College", "food"));
        vAry.add(new VenderLocation(new LatLng(34.06216, -117.81947), "Bldg. 21", "Montecito Residene Hall", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05668, -117.82285), "Bldg. 24", "Music", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05883, -117.81479), "Bldg. 29", "W.K. Kellogg Horse Center", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05408, -117.82149), "Bldg. 41", "Darlene May Gymnasium", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05409, -117.81973), "Bldg. 43", "Kellogg Gymnasium", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.0562, -117.81998), "Bldg. 55", "Foundation Administrative Offices", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05625, -117.82579), "Bldg. 77", "Kellogg West Main Lodge", "drink"));
        vAry.add(new VenderLocation(new LatLng(34.05034, -117.81468), "Bldg. 220", "CTTi", "drink"));

        for (Object v : vAry) {
            String type = ((VenderLocation) v).type;
            BitmapDescriptor icon;
            if (type.equals("food")) {
                icon = BitmapDescriptorFactory.fromResource(R.mipmap.food_sm);
            } else if (type.equals("drink")) {
                icon = BitmapDescriptorFactory.fromResource(R.mipmap.drinks2_sm);
            } else {
                icon = BitmapDescriptorFactory.fromResource(R.mipmap.fooddrink_sm);
            }
            mMap.addMarker(new MarkerOptions()
                    .position(((VenderLocation) v).latLng)
                    .title(((VenderLocation) v).bldgNum)
                    .icon(icon));
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private class VenderLocation {
        LatLng latLng;
        String bldgNum;
        String bldgName;
        String type;

        VenderLocation(LatLng latLng, String bldgNum, String bldgName, String type){
            this.latLng = latLng;
            this.bldgNum = bldgNum;
            this.bldgName = bldgName;
            this.type = type;
        }
    }
}
