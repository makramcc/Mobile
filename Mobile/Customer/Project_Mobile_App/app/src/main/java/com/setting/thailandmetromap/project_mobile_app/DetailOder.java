package com.setting.thailandmetromap.project_mobile_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.setting.thailandmetromap.project_mobile_app.DetailListCar.list_car;

public class DetailOder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_oder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int position = getIntent().getIntExtra("position",-1);
        String str = list_car.get(position).getBrand();
        Log.i("DT",str);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView1 = (TextView)findViewById(R.id.textViewname);
        textView1.setText(getIntent().getStringExtra("name"));

        TextView textView2=(TextView)findViewById(R.id.textViewCar);
        textView2.setText(str+" " + list_car.get(position).getModel());

        TextView textView3=(TextView)findViewById(R.id.textViewDetail);
        textView3.setText(list_car.get(position).getDetail());

        TextView textView4=(TextView) findViewById(R.id.textViewfdate);
        textView4.setText(getIntent().getStringExtra("f_date"));

        TextView textView5 =(TextView)findViewById(R.id.textViewedate);
        textView5.setText(getIntent().getStringExtra("e_date"));

        TextView textView6 = (TextView)findViewById(R.id.textViewplace);
        textView6.setText(getIntent().getStringExtra("place"));

        TextView textView7 = (TextView)findViewById(R.id.textViewcity);
        textView7.setText(list_car.get(position).getCity());

        TextView textView8 = (TextView)findViewById(R.id.textViewtime);
        textView8.setText(getIntent().getStringExtra("time"));


    }

}
