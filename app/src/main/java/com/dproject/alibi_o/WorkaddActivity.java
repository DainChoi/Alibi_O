package com.dproject.alibi_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkaddActivity extends AppCompatActivity {

    EditText title_input, id_input, address_input;
    ImageButton btn_check;
    DatabaseReference workDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workadd);

        title_input = findViewById(R.id.title_input);
        id_input = findViewById(R.id.id_input);
        address_input = findViewById(R.id.address_input);

        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(WorkaddActivity.this);
                myDB.addWork(title_input.getText().toString().trim(),
                        id_input.getText().toString().trim(),
                        address_input.getText().toString().trim());

              //  Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
              //  startActivity(intent);
              //  finish();
            }
        });
        /* 최종
        workDbRef = FirebaseDatabase.getInstance().getReference().child("Work");

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               insertWorkData();
            }
        });*/

        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void insertWorkData() {

        String title = title_input.getText().toString();
        String workid = id_input.getText().toString();
        String address = address_input.getText().toString();

        Work work = new Work(title, workid, address);
        workDbRef.push().setValue(work);
        Toast.makeText(WorkaddActivity.this, "Data inserted!", Toast.LENGTH_SHORT).show();

    }
}