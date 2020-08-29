package com.example.storybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class secondscreen extends AppCompatActivity {
    ListView listViewDemo;
    Button btn2;
  String[] storyName={"frog and princess", "As you like it","ffffffffff"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewDemo=(ListView)findViewById(R.id.abin);
        final ArrayAdapter<String> adapterDemo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, storyName);
        listViewDemo.setAdapter(adapterDemo);


        listViewDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=adapterDemo.getItem(position);
                //Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),position,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(secondscreen.this,story1.class);
                intent.putExtra("position",position+"");
                startActivity(intent);
                btn2 = findViewById(R.id.back_button);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

            }
        });

    }
}