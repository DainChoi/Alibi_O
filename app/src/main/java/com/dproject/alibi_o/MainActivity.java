package com.dproject.alibi_o;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {



    RecyclerView recycle1;
    RecycleAdapter adapter;

    int imgID[] = {R.drawable.icon, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5,
            R.drawable.icon6, R.drawable.icon7, R.drawable.icon8, R.drawable.icon9, R.drawable.icon9};

    String title[] = {"버거킹 충북대점", "노랑통닭 복대점", "설빙 율량점", "logo4", "logo5", "logo6", "logo7", "logo8", "logo9", "logo10"};

    String content[] = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle1 = findViewById(R.id.recycle1);

        adapter = new RecycleAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycle1.setLayoutManager(layoutManager);

        for (int i = 0; i < imgID.length; i++){
            adapter.addItem(new ItemData(imgID[i],title[i],content[i]));
        }

        recycle1.setAdapter(adapter);

        adapter.setOnItemClickListner(new OnItemDataClickListener() {

            public void OnItemClick(RecycleAdapter.ViewHolder holder, View view, int position) {
                ItemData data = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),data.title+"가 선택됨",Toast.LENGTH_SHORT).show();

            }
        });

        Button btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WorkActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton btn_workadd = findViewById(R.id.btn_workadd);
        btn_workadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WorkaddActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 탈퇴 처리
        // mFirebaseAuth.getCurrentUser().delete();
    }
}
