package com.chirathip.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }
    public void Submit(View v){

        EditText brand =  (EditText) findViewById(R.id.brandFill);
        EditText model =  (EditText) findViewById(R.id.modelFill);
        EditText detail =  (EditText) findViewById(R.id.detailFill);
        EditText city = (EditText) findViewById(R.id.cityFill);
        String str = "";
        str += brand.getText().toString()+"_";
        str += model.getText().toString()+"_";
        str += detail.getText().toString()+"_";
        str += city.getText().toString();
        String url = "http://172.20.10.2:8080/com/addData.html?str="+str;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "เพิ่มข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() { // กรณี Error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", error.getMessage());
                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }

}
