package com.setting.thailandmetromap.project_mobile_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String str_City,str_model,str_brand;
    List<String> list_city,list_model,list_brand,list_car_honda,list_car_toyota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addList_car_honda();
        addList_car_toyata();
        addListCity();
        addListBrand();
        addListModel();
        Log.i("img",""+R.mipmap.c2);

        Spinner spinner1 = findViewById(R.id.spinnerCity);
        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataadapter1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_city);
        dataadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataadapter1);

        Spinner spinner2 = findViewById(R.id.spinnerBrand);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataadapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_brand);
        dataadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataadapter2);

        Spinner spinner3 = findViewById(R.id.spinnerModel);
        spinner3.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataadapter3 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_model);
        dataadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataadapter3);

    }
    private void addList_car_honda(){
        list_car_honda = new ArrayList<String>();
        list_car_honda.add("JAZZ");
        list_car_honda.add("CIVIC");
        list_car_honda.add("CRV");
        list_car_honda.add("HRV");
        list_car_honda.add("ACCORD");
    }

    private void addList_car_toyata(){
        list_car_toyota =new ArrayList<String>();
        list_car_toyota.add("CAMMRY");
        list_car_toyota.add("VIOS");
        list_car_toyota.add("ALTIS");
        list_car_toyota.add("YARIS");
        list_car_toyota.add("CHR");

    }

    private void addListModel() {
        list_model = new ArrayList<String>();
        list_model.add("");
        for (int i=0;i<list_car_honda.size();i++){
            list_model.add(list_car_honda.get(i).toString());
        }
        for (int i=0;i<list_car_toyota.size();i++){
            list_model.add(list_car_toyota.get(i).toString());
        }

    }

    private void addListBrand() {
        list_brand = new ArrayList<String>();
        list_brand.add("");
        list_brand.add("HONDA");
        list_brand.add("TOYOTA");
    }

    private void addListCity() {
        list_city = new ArrayList<String>();
        list_city.add("");
        list_city.add("กรุงเทพมหานคร");
        list_city.add("ลำปาง");
        list_city.add("จันทบุรี");
    }

    public void searchcar(View view){
        Intent intent = new Intent(this,DetailListCar.class);
        intent.putExtra("city",str_City);
        intent.putExtra("model",str_model);
        intent.putExtra("brand",str_brand);
        TextView textView=(TextView)findViewById(R.id.fDate);
        String fdate=textView.getText().toString();
        intent.putExtra("f_date",fdate);
        textView =(TextView)findViewById(R.id.eDate);
        String edaet=textView.getText().toString();
        intent.putExtra("e_date",edaet);
        if(fdate.equals("") && edaet.equals("")){
            Toast.makeText(getApplicationContext(),"กรุณาป้อนวันที่จองให้ครบ",Toast.LENGTH_LONG).show();
        }else {
        startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.spinnerCity:
                str_City=list_city.get(position);

                break;

            case R.id.spinnerBrand:
                str_brand=list_brand.get(position);
                updateListModel();
                break;

            case R.id.spinnerModel:
                str_model=list_model.get(position);
                break;
        }
    }

    private void updateListModel() {
       // Log.i("update","in");
        list_model = new ArrayList<String>();
        if (str_brand==""){
            Log.i("update","1");

            list_model.add("");
            for (int i=0;i<list_car_honda.size();i++){
                list_model.add(list_car_honda.get(i).toString());
            }
            for (int i=0;i<list_car_toyota.size();i++){
                list_model.add(list_car_toyota.get(i).toString());
            }
        }else if(str_brand=="TOYOTA"){
            Log.i("update","2");
            for (int i=0;i<list_car_toyota.size();i++){
                list_model.add(list_car_toyota.get(i).toString());
            }
        }else if(str_brand=="HONDA"){
            Log.i("update","3");
            for (int i=0;i<list_car_honda.size();i++){
                list_model.add(list_car_honda.get(i).toString());
            }
        }
        for(int i=0;i<list_model.size();i++){
            Log.i("update","in="+list_model.get(i).toString());
        }
        Spinner spinner3 = findViewById(R.id.spinnerModel);
        ArrayAdapter<String> dataadapter3 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list_model);
        dataadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataadapter3);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
