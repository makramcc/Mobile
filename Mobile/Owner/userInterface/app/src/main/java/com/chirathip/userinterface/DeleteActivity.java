package com.chirathip.userinterface;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class DeleteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    List<String> listStr = new ArrayList<>();
    TextView text;
    ArrayList<String> arrlist = new ArrayList<>();
    String arr2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        String url = "http://172.20.10.2:8080/com/showData.html";

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
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url = "http://172.20.10.2:8080/com/deleteData.html?select="+(position+1);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "ลบสำเร็จ", Toast.LENGTH_SHORT).show();
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
}
