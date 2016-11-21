package com.udacity.stockhawk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.udacity.stockhawk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockOvertimeActivity extends AppCompatActivity {
    @BindView(R.id.stockOvertimeImageview)
    ImageView stockOvertimeImageview;
    String imagePath = "";
    String symbol = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_overtime);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            symbol = intent.getStringExtra("symbol");
        }
        imagePath = getString(R.string.stock_overtime_symbol, symbol);
        Picasso.with(this).load(imagePath).placeholder(R.drawable.ic_place_holder)
                .error(R.drawable.ic_error_fallback).into(stockOvertimeImageview, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Picasso.with(getApplicationContext())
                        .load(imagePath)
                        .into(stockOvertimeImageview, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
//                                        Log.v("Picasso","Could not fetch image");
                            }
                        });
            }
        });
    }
}
