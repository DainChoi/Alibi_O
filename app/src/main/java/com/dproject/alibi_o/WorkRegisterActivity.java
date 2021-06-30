package com.dproject.alibi_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkRegisterActivity extends AppCompatActivity {

    EditText title_input, id_input, address_input;
    ImageButton btn_check;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_register);

        title_input = findViewById(R.id.title_input);
        id_input = findViewById(R.id.id_input);
        address_input = findViewById(R.id.address_input);
        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("Work");

        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_input.getText().toString();
                String workid = id_input.getText().toString();
                String address = address_input.getText().toString();
                Work work = new Work(title, workid, address);
                databaseReference.push().setValue(work);
                Toast.makeText(WorkRegisterActivity.this, "매장이 등록되었습니다!", Toast.LENGTH_SHORT).show();

              //  Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
              //  startActivity(intent);
              //  finish();
            }
        });


        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkRegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}