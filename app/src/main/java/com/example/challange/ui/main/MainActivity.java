package com.example.challange.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.challange.R;
import com.example.challange.model.Digits;
import com.example.challange.ui.main.adapter.ClickListiner;
import com.example.challange.ui.main.adapter.EditTextAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditTextAdapter adapter;
    TextView textView;
    RecyclerView recyclerView;
    ClickListiner listiner;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Digits> list = new ArrayList<>();
        list.add(new Digits(""));
        list.add(new Digits(""));
        list.add(new Digits(""));
        list.add(new Digits(""));
        list.add(new Digits(""));
        setUpRecyclerView(list);

    }
    private void setUpRecyclerView(List<Digits> list){
        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.textView);
        listiner = index -> {
            total = total + Integer.parseInt(index);
            textView.setText(Integer.toString(total));
        };
        adapter = new EditTextAdapter(getApplication(),list,listiner);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}