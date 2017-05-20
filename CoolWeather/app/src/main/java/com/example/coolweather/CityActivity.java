package com.example.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity {
    private String[] city01={"北京市"};
    private String[] city02={"天津"};
    private String[] city17={"杭州","宁波","温州","绍兴","湖州","嘉兴"
            ,"金华","衢州","台州","丽水","舟山"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String p=getIntent().getStringExtra("p");
        String[] data=null;
        if("北京".equals(p)){
            data=city01;
        }
        else if("天津".equals(p)){
            data=city02;
    }
        else if("浙江".equals(p)){
            data=city17;
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                CityActivity.this, android.R.layout.simple_list_item_1, data);
        ListView ListView =(ListView) findViewById(R.id.list_view);
        ListView.setAdapter(adapter);
    }
}
