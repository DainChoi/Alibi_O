package com.dproject.alibi_o;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private EditText searchBar;
    private ImageButton btn_check, mSearchBtn;
    private RecyclerView recyclerView;
  //  private RecyclerView.Adapter adapter;
    private CustomAdapterAdd customAdapterAdd;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<UserAccount> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private CharSequence search="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        searchBar = (EditText) findViewById(R.id.search_bar);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // UserAccount 객체를 담을 어레이리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("Alibi").child("UserAccount"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    UserAccount userAccount = snapshot.getValue(UserAccount.class); // UserAccount 객체에 데이터 담음
                    arrayList.add(userAccount); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
               // adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
                customAdapterAdd.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("AddActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


        /* No Use -> 나중에 imageview로 chg.
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */

        customAdapterAdd = new CustomAdapterAdd(arrayList, this);
        recyclerView.setAdapter(customAdapterAdd); // 리사이클러뷰에 어댑터 연결

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i3) {

                customAdapterAdd.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

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



}