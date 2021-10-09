package com.dproject.alibi_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Frag3AddActivity extends AppCompatActivity {

    EditText name_input, time_in_input, time_out_input;
    ImageButton btn_check;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag3_add);

        name_input = findViewById(R.id.name_input);
        time_in_input = findViewById(R.id.time_in_input);
        time_out_input = findViewById(R.id.time_out_input);
       // databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("Work");

        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
                Date date = new Date();
                date.setMonth(datePicker.getMonth());
                date.setYear(datePicker.getYear()-1900);
                date.setDate(datePicker.getDayOfMonth());


                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

                String dateString = format.format(date);


                Sked sked = new Sked();
                sked.setName(name_input.getText().toString());
                sked.setTime_in(time_in_input.getText().toString());
                sked.setTime_out(time_out_input.getText().toString());
                sked.setDate(dateString);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                String key = database.getReference("Alibi").child("sked").child(sked.getName()).getKey();


                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put(key, sked.toFirebaseObject());
                database.getReference("Alibi").child("sked").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            finish();
                        }
                    }
                });

                /*
                Sked sked = new Sked(title, workid, address);
                // databaseReference.push().setValue(work);
                databaseReference.child(work.getWorkid()).setValue(work);
                Toast.makeText(Frag3AddActivity.this, "스케줄이 등록되었습니다!", Toast.LENGTH_SHORT).show();
                 */

                //  Intent intent = new Intent(Frag3AddActivity.this, MainActivity.class);
                //  startActivity(intent);
                //  finish();
            }
        });


        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Frag3AddActivity.this,WorkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }

}