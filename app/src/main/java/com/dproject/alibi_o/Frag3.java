package com.dproject.alibi_o;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.ArrayList;

public class Frag3 extends Fragment {

    private View view;

    ImageButton btn_check;
    DatabaseReference databaseReference_time;

    private CustomAdapterFrag3 customAdapterFrag3;
    RecyclerView recyclerView;
    TextView name_text;
    private ArrayList<Member> arrayList;
    private ArrayList<Time> arrayList2;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        //  customAdapterFrag3 = new CustomAdapterFrag3(arrayList, arrayList2, getActivity());
        //  recyclerView.setAdapter(customAdapterFrag3); // 리사이클러뷰에 어댑터 연결

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // UserAccount 객체를 담을 어레이리스트 (어댑터쪽으로)
        arrayList2 = new ArrayList<>();

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동


        databaseReference = database.getReference("Alibi").child("Member"); // DB 테이블 연결
       // databaseReference2 = database.getReference("Alibi").child("Member").child("Time"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    Member member = snapshot.getValue(Member.class); // Member 객체에 데이터 담음
                    arrayList.add(member); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                    Time time = snapshot.getValue(Time.class); // Time 객체에 데이터 담음
                    arrayList2.add(time); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비;

                    /* error
                    for (DataSnapshot dSnapshot : dataSnapshot.child("Time").getChildren()) {
                        Time time = dSnapshot.getValue(Time.class); // Time 객체에 데이터 담음
                        arrayList2.add(time); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비;

                    }

                     */

                }

                customAdapterFrag3.notifyDataSetChanged(); // 리스트 저장 및 새로고침

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("Frag3", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });






        /*
        databaseReference = database.getReference("Alibi").child("Member");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Member member = ds.getValue(Member.class);
                    arrayList.add(member);
                   // Log.d("TAG", name);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        databaseReference.addListenerForSingleValueEvent(eventListener);
         */



        /*
        databaseReference2 = database.getReference("Alibi").child("Member").child("time"); // DB 테이블 연결
        databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList2.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    Time time = snapshot.getValue(Time.class); // Member 객체에 데이터 담음
                    arrayList2.add(time); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                }

                customAdapterFrag3.notifyDataSetChanged(); // 리스트 저장 및 새로고침

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("Frag3", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

         */








        /* No Use -> 나중에 imageview로 chg.
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */



        customAdapterFrag3 = new CustomAdapterFrag3(arrayList, arrayList2, getActivity().getApplicationContext());
        recyclerView.setAdapter(customAdapterFrag3); // 리사이클러뷰에 어댑터 연결


        /*
        databaseReference_time = FirebaseDatabase.getInstance().getReference("Alibi").child("time");

        btn_check = view.findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Time time = new Time(name, sun_in, mon_in, tue_in, wed_in, thu_in, fri_in, sat_in,
                        sun_out, mon_out, tue_out, wed_out, thu_out, fri_out, sat_out);
                // databaseReference.push().setValue(work);
                databaseReference.child(time.getName()).setValue(time);
                Toast.makeText(getActivity(), "스케줄이 등록되었습니다!", Toast.LENGTH_SHORT).show();

                //  Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
                //  startActivity(intent);
                //  finish();
            }
        });

         */

        // 캘린더
        final CollapsibleCalendar collapsibleCalendar = view.findViewById(R.id.calendarView);
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDayChanged() {

            }

            @Override
            public void onClickListener() {

            }

            @Override
            public void onDaySelect() {
                Day day = collapsibleCalendar.getSelectedDay();
                Log.i(getClass().getName(), "Selected Day: "
                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());
            }

            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });

        return view;
    }



}
