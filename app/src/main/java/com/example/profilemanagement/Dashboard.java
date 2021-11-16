package com.example.profilemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.valdesekamdem.library.mdtoast.MDToast;

public class Dashboard extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView1 = (ImageView)findViewById(R.id.profile);
        imageView2 = (ImageView)findViewById(R.id.logout);
        imageView3 = (ImageView)findViewById(R.id.order);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Dashboard.this, SellerProfile.class);
                Dashboard.this.startActivity(mainIntent);
                Dashboard.this.finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Checkbox", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("remember","false");
                editor.apply();

                Intent i = new Intent(Dashboard.this, Login.class);
                startActivity(i);
                ((Activity) Dashboard.this).overridePendingTransition(0, 0);

                MDToast mdToast = MDToast.makeText(Dashboard.this, "Successfully Logout", MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                mdToast.show();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Dashboard.this, OrderList.class);
                Dashboard.this.startActivity(mainIntent);
                Dashboard.this.finish();
            }
        });
    }
}