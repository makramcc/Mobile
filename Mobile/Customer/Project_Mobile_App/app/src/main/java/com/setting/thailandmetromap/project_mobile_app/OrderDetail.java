package com.setting.thailandmetromap.project_mobile_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static com.setting.thailandmetromap.project_mobile_app.DetailListCar.list_car;

public class OrderDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        String name =getIntent().getStringExtra("name");
        String pass =getIntent().getStringExtra("passport");
        String driving =getIntent().getStringExtra("driving");
        String tel =getIntent().getStringExtra("tel");
        String mail=getIntent().getStringExtra("Email");
        String fdate=getIntent().getStringExtra("f_date");
        String edate=getIntent().getStringExtra("e_date");
        int position=getIntent().getIntExtra("position",-1);
        String time=getIntent().getStringExtra("time");
        String place=getIntent().getStringExtra("place");

        Log.i("OderDetail",name+pass+driving+tel+mail+fdate+edate+position+time+place);

        TextView tx = (TextView)findViewById(R.id.name);
        tx.setText(name);



    }

}
