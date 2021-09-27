package com.dproject.alibi_o;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Frag2 extends Fragment {

    private View view;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        ImageButton btn_notify = (ImageButton) view.findViewById(R.id.btn_notify);

        btn_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // activity -> fragment 불가능
                // activity -> frag포함 activity -> fragment 이동
                Intent intent = new Intent(getActivity(),AskActivity.class);
                startActivity(intent);
            }
        });
        TextView whenDate = (TextView) view.findViewById(R.id.textView);
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // todo
                String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                whenDate.setText(date); // 선택한 날짜로 설정

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Alibi").child("TimeIn").child("01:30").child("time_in").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeIn = (TextView) view.findViewById(R.id.S_time1);
                TimeIn.setText(value);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference.child("Alibi").child("TimeOut").child("01:31").child("time_out").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeOut = (TextView) view.findViewById(R.id.E_time1);
                TimeOut.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference.child("Alibi").child("Member").child("가나다").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeOut = (TextView) view.findViewById(R.id.name_1);
                TimeOut.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference.child("Alibi").child("TimeIn").child("06:05").child("time_in").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeIn = (TextView) view.findViewById(R.id.S_time2);
                TimeIn.setText(value);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference.child("Alibi").child("TimeOut").child("08:09").child("time_out").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeOut = (TextView) view.findViewById(R.id.E_time2);
                TimeOut.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        databaseReference.child("Alibi").child("Member").child("테스트").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                TextView TimeOut = (TextView) view.findViewById(R.id.name_2);
                TimeOut.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        return view;
    }
}
