package com.chirathip.userinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

        List<String> listStr = new ArrayList<>();
        TextView text;
        ArrayList<String> arrlist = new ArrayList<>();
        String arr2[];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order);
            String url = "http://192.168.2.10:8080/com/checkOrder.html";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            String arr[] = response.split(",");
                            String temp[] = arr[0].split("\\[");
                            arr[0] = temp[temp.length-1];
                            temp = arr[arr.length-1].split("\\]");
                            arr[arr.length-1] = temp[0];
                            String result = "";
                            for(String str : arr){
                                arr2 = str.split("\\_");
                                String strTemp = "";
                                for(int i = 1; i <  arr2.length; i++){
                                    strTemp+=arr2[i]+"\n";
                                }
                                listStr.add(strTemp);
                            }
                            showData();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("error", error.getMessage());
                        }
                    });
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);

        }

        public void showData(){
            ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listStr);
            ListView listView = (ListView) findViewById(R.id.listview);
            listView.setAdapter(adapter);
        }
    }


