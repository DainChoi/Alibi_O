package com.dproject.alibi_o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddActivity extends AppCompatActivity {

    EditText title_input;
    ImageButton btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);

        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelperFrag4 myDB = new MyDatabaseHelperFrag4(AddActivity.this);
                myDB.addWork(title_input.getText().toString().trim());
                // ERROR: 추가한 후 MainActivity를 갔다 와야 추가 되어있음
                /*
                Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); */
            }
        });

        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // activity -> fragment 불가능
                // activity -> frag포함 activity -> fragment 이동
                Intent intent = new Intent(AddActivity.this,WorkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }

/*
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_add, container, false);

        ImageButton btn_back = (ImageButton) view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AddActivity로 이동
                Intent intent = new Intent(getActivity(), Frag4.class);
                startActivity(intent);
            }
        });

        return view;
    }*/
}