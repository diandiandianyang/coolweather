package com.example.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> dataList=new ArrayList<>();
    private List<String> provinces = Arrays.asList(new String[]{"北京市","浙江省","上海市", "湖南省"});
    private List<String> city01 = Arrays.asList(new String[]{"大兴","通州","密云","怀柔"});
    private List<String> city02 = Arrays.asList(new String[]{"杭州","宁波","温州","绍兴","湖州","嘉兴"
            ,"金华","衢州","台州","丽水","舟山"});
    private List<String> city03=Arrays.asList(new String[]{"浦东新区","南汇区","金山区","奉贤区","松江区","普陀区","崇明岛"});
    private List<String> city04=Arrays.asList(new String[]{"张家界","常德","怀化市","益阳市","岳阳市","永州市","长沙市"});
    private List<String> county0201 =Arrays.asList(new String[]{"路桥","黄岩","椒江","温岭","临海"});
    private int level=1;
    private Button backButton =null;
    private ListView  listView =null;
    private ArrayAdapter adapter;

    private void showCities(int position) {
        level=2;
        this.backButton.setVisibility(View.VISIBLE);
        this.dataList.clear();
        if("北京市".equals(this.provinces.get(position))){
            this.dataList.addAll(city01);
        }
        if("浙江省".equals(this.provinces.get(position))){
            this.dataList.addAll(city02);
        }
        if("上海市".equals(this.provinces.get(position))){
            this.dataList.addAll(city03);
        }
        if("湖南省".equals(this.provinces.get(position))){
            this.dataList.addAll(city04);
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
///       button.setVisibility(View.GONE);
       this.backButton= (Button) findViewById(R.id.Button);
       listView =(ListView) findViewById(R.id.list_view);
        this.dataList.addAll(this.provinces);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(level==1){
                    showCities(position);
            }else if(level==2){
                level=3;
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList.addAll(county0201);
                    adapter.notifyDataSetChanged();
            }else{
                //TODO 选定区县，去显示天气界面
            }
        }
    });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level==3){
                    level=2;
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList.addAll(city01);


                    MainActivity.this.adapter.notifyDataSetChanged();
                }else if(level==2){
                    level=1;
                    backButton.setVisibility(View.GONE);
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList.addAll(provinces);
                    MainActivity.this.adapter.notifyDataSetChanged();
                }
            }
        });

    }

}
