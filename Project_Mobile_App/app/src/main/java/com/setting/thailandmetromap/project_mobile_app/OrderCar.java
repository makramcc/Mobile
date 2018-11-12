package com.setting.thailandmetromap.project_mobile_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderCar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String name,passport,driving,tel,mail,time="1",place="1",id;
    List<String> list_time,list_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_car);

        Log.i("OrderCar","" + getIntent().getIntExtra("position",-1));
        setListTime();
        setListPlace();

        Spinner spinner1 = findViewById(R.id.stime);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataadapter1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_time);
        dataadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataadapter1);

        Spinner spinner2 = findViewById(R.id.splace);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_place);
        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataadapter2);

    }

    private void setListPlace() {
        list_place = new ArrayList<String >();
        list_place.add("BMTA");
        list_place.add("AIR PORT");
    }

    private void setListTime() {
        list_time=new ArrayList<String>();
        list_time.add("9:00");
        list_time.add("11:00");
        list_time.add("14:00");
        list_time.add("16:00");
    }

    public void openDetail(){
        Intent intent=new Intent(this,DetailOder.class);
        intent.putExtra("name",name);
        intent.putExtra("passport",passport);
        intent.putExtra("driving",driving);
        intent.putExtra("tel",tel);
        intent.putExtra("Email",mail);
        intent.putExtra("f_date",getIntent().getExtras().getString("f_date"));
        intent.putExtra("e_date",getIntent().getExtras().getString("e_date"));
        intent.putExtra("position",getIntent().getExtras().getInt("position",-1));
        intent.putExtra("time",time);
        intent.putExtra("place",place);
        startActivity(intent);
    }
    public void submit(View view){
        EditText editname = (EditText)findViewById(R.id.editname);
        name = editname.getText().toString();
        EditText editpassport = (EditText)findViewById(R.id.editNoThaiNational);
        passport = editpassport.getText().toString();
        EditText editdrive = (EditText)findViewById(R.id.editNoDriving);
        driving = editdrive.getText().toString();
        EditText editTel = (EditText)findViewById(R.id.editname);
        tel = editTel.getText().toString();
        EditText editmail = (EditText)findViewById(R.id.editname);
        mail = editmail.getText().toString();


        if(name.equals("")&&passport.equals("")&&driving.equals("")&&tel.equals("")&&mail.equals("")){
            Toast.makeText(getApplicationContext(),"ใส่ข้อมูลให้ครบ",Toast.LENGTH_SHORT).show();

        }else {
            String url;
            url="http://192.168.43.227:8888/Mobile/insert_order.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new
                    Response.Listener<String>() {


                        @Override
                        public void onResponse(String response) {
                            Log.i("StringRequest",response.toString());
                            id= response.toString();
                            openDetail();
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error){
                            Log.i("StringRequest",error.getMessage());
                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String>params = new HashMap<String, String>();
                    params.put("car_id",""+getIntent().getIntExtra("car_id",-1));
                    params.put("first_date", getIntent().getStringExtra("f_date"));
                    params.put("end_date", getIntent().getStringExtra("e_date"));
                    params.put("name", name);
                    params.put("tel", tel);
                    params.put("passport", passport);
                    params.put("id_driving", driving);
                    params.put("Email", mail);
                    params.put("time", time);
                    params.put("city", getIntent().getStringExtra("city"));
                    params.put("place",place);
                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.stime:
                time=list_time.get(position);

                break;

            case R.id.splace:
                place=list_place.get(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
