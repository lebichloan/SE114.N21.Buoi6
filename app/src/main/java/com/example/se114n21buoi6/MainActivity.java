package com.example.se114n21buoi6;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listviewItems;
    String flag;
    private ArrayList<ItemList>  listItems;
    adapter_item_list adapter;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        ItemList item = (ItemList) intent.getSerializableExtra("item");
                        if (flag.equals("Add")){
                            listItems.add(item);
                        }
                        else if (flag.equals("Edit")){
                            int position = intent.getExtras().getInt("position");
                            listItems.get(position).setName(item.getName());
                            listItems.get(position).setDescription(item.getDescription());
                            listItems.get(position).setFinishDate(item.getFinishDate());
                            listItems.get(position).setMark(item.isMark());
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constructor();
        adapter = new adapter_item_list(this, R.layout.list_item, listItems);
        listviewItems = findViewById(R.id.listView);
        listviewItems.setAdapter(adapter);
        registerForContextMenu(listviewItems);
    }
    private void constructor(){

        listItems = new ArrayList<>(Arrays.asList(
                new ItemList("Ăn","Ăn","01/01/2023",true),
                new ItemList("Ngủ","Ngủ","01/01/2023",false)
        ));
    }
}