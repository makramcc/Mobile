package com.setting.thailandmetromap.project_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import static com.setting.thailandmetromap.project_mobile_app.DetailListCar.list_car;

public class DetailCar extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_car);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        position = getIntent().getIntExtra("position",-1);
        Log.i("DetailCar"," "+position + "list="+list_car.get(position).getCar_id());

        TextView txtBrand = (TextView)findViewById(R.id.brand);
        TextView txtModel = (TextView)findViewById(R.id.txtModel);
        TextView txtDetail = (TextView)findViewById(R.id.detail);
        ImageView imageView = (ImageView)findViewById(R.id.imgCar);

        txtBrand.setText(list_car.get(position).getBrand());
        txtModel.setText(list_car.get(position).getModel());
        txtDetail.setText(list_car.get(position).getDetail());
        imageView.setImageResource(list_car.get(position).getImage());

    }
        public void reserve(View view){
            Intent intent = new Intent(this,OrderCar.class);
            intent.putExtra("position",position);
            intent.putExtra("f_date",getIntent().getExtras().getString("f_date"));
            intent.putExtra("e_date",getIntent().getExtras().getString("e_date"));
            intent.putExtra("city",list_car.get(position).getCity());
            intent.putExtra("car_id",list_car.get(position).getCar_id());
            startActivity(intent);
        }

}
