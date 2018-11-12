package com.setting.thailandmetromap.project_mobile_app;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailListCar extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static List<Data_Car> list_car = new ArrayList<Data_Car>();
    String city,url,brand,model,f_date,e_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_car);

        url="http://192.168.10.117:8888/Mobile/select_car.php?";
        url="http://192.168.43.227:8888/Mobile/select_car.php?";



         brand=getIntent().getStringExtra("brand");
         model=getIntent().getStringExtra("model");
         city=getIntent().getStringExtra("city");
         f_date=getIntent().getStringExtra("f_date");
         e_date=getIntent().getStringExtra("e_date");

         Log.i("url",brand+model+city+f_date+e_date);

        if (!brand.equals("")){
            url+="brand="+brand+"&";
        }
        if (!model.equals("")){
            url+="model="+model+"&";
        }
        if(!city.equals("")){
            url+="city="+city+"&";
        }
        if(!f_date.equals("") ) {
            url += "first_date=" + f_date + "&" ;
        }
        if(!e_date.equals("")){
            url += "end_date=" + e_date + "&" ;
        }
        Log.i("url",url);
        select_car_db(url);

    }
    private void UpdateUrl(String url) {
        String brand=getIntent().getStringExtra("brand");
        String model=getIntent().getStringExtra("model");
        String city=getIntent().getStringExtra("city");
        String f_date=getIntent().getStringExtra("f_date");
        String e_date=getIntent().getStringExtra("e_date");

        if (!brand.contains("")){
            url+="city="+city+"&";
        }
        if (!model.contains("")){
            url+="model="+model+"&";
        }
        if(!city.contains("")){
            url+="city="+city+"&";
        }
        if(!f_date.contains("") ) {
            url += "first_date=" + f_date + "&" ;
        }
        if(!e_date.contains("")){
            url += "end_date=" + e_date + "&" ;
        }

    }



    public  void Show_List_Detail() {
        MyAdapter adapter= new MyAdapter(this,list_car);
        ListView lv =(ListView)findViewById(R.id.listCar);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    public  void select_car_db(String url) {

        JsonArrayRequest jsRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Gson gson = new Gson();
                        JSONObject jsObj= null;
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                jsObj = response.getJSONObject(i);
                                Log.i("Request", jsObj.getString("car_brand"));
                                Data_Car data_car = gson.fromJson(jsObj.toString(), Data_Car.class);
                                list_car.add(data_car);

                                Log.i("Li",""+ list_car.get(i).getCar_id());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (list_car.size()>0){
                            Show_List_Detail();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error handling
                        Log.w("MyJson",error.getMessage());
                    }
                });




        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsRequest);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetailCar.class);
        intent.putExtra("position", position);
        intent.putExtra("f_date",getIntent().getExtras().getString("f_date"));
        intent.putExtra("e_date",getIntent().getExtras().getString("e_date"));
        intent.putExtra("id_car",list_car.get(position).getCar_id());

        startActivity(intent);

    }
}
