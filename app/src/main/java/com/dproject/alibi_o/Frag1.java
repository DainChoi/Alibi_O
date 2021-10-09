package com.dproject.alibi_o;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

import java.util.ArrayList;

public class Frag1 extends Fragment {

    private View view;
    RecyclerView recyclerView;
    private ArrayList<TimeIn> arrayList;
    private ArrayList<TimeOut> arrayList2;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference2;
    private CustomAdapterFrag1 customAdapterFrag1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // UserAccount 객체를 담을 어레이리스트 (어댑터쪽으로)
        arrayList2 = new ArrayList<>();

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동


        databaseReference = database.getReference("Alibi");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.child("TimeIn").getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    TimeIn timeIn = snapshot.getValue(TimeIn.class); // Member 객체에 데이터 담음
                    arrayList.add(timeIn); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                    for (DataSnapshot dSnapshot : dataSnapshot.child("TimeOut").getChildren()) {
                        TimeOut timeOut = dSnapshot.getValue(TimeOut.class); // Member 객체에 데이터 담음
                        arrayList2.add(timeOut); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                        // Error "timeout"을 불러오지 못함

                    }
                }

                customAdapterFrag1.notifyDataSetChanged(); // 리스트 저장 및 새로고침

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("Frag1", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        customAdapterFrag1 = new CustomAdapterFrag1(arrayList, arrayList2, getActivity().getApplicationContext());
        recyclerView.setAdapter(customAdapterFrag1); // 리사이클러뷰에 어댑터 연결




        ImageButton btn_back = (ImageButton) view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
