package com.dproject.alibi_o;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Frag4 extends Fragment {

    private CustomAdapterFrag4 customAdapterFrag4;
    private View view;
    RecyclerView recyclerView;
    ImageView empty_imageview;
    TextView no_data;
    TextView name_text;
    private ArrayList<Member> arrayList;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private String name;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        empty_imageview = (ImageView) view.findViewById(R.id.empty_imageview);
        no_data = (TextView) view.findViewById(R.id.no_data);

        customAdapterFrag4 = new CustomAdapterFrag4(arrayList, getActivity());
        recyclerView.setAdapter(customAdapterFrag4); // 리사이클러뷰에 어댑터 연결

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // UserAccount 객체를 담을 어레이리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("Alibi").child("Member"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    Member member = snapshot.getValue(Member.class); // UserAccount 객체에 데이터 담음
                    arrayList.add(member); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                // adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
                customAdapterFrag4.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("Frag4", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


        /* No Use -> 나중에 imageview로 chg.
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */

        customAdapterFrag4 = new CustomAdapterFrag4(arrayList, getActivity().getApplicationContext());
        recyclerView.setAdapter(customAdapterFrag4); // 리사이클러뷰에 어댑터 연결




        FloatingActionButton btn_add = (FloatingActionButton) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AddActivity로 이동
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });




        return view;
    }


}
