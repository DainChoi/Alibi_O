package com.dproject.alibi_o;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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

import java.util.ArrayList;

public class Frag4 extends Fragment {

    private View view;
    RecyclerView recyclerView;
    ImageView empty_imageview;
    TextView no_data;


    MyDatabaseHelperFrag4 myDB;
    ArrayList<String> work_num, work_title;
    CustomAdapterFrag4 customAdapterfrag4;
    ImageButton btn_delete2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        empty_imageview = (ImageView) view.findViewById(R.id.empty_imageview);
        no_data = (TextView) view.findViewById(R.id.no_data);


        FloatingActionButton btn_add = (FloatingActionButton) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AddActivity로 이동
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelperFrag4(getActivity().getApplicationContext());
        work_num = new ArrayList<>();
        work_title = new ArrayList<>();

        storeDataInArrays();

        customAdapterfrag4 = new CustomAdapterFrag4(getActivity(),getActivity().getApplicationContext(),
                work_num, work_title, btn_delete2);
        recyclerView.setAdapter(customAdapterfrag4);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));



        return view;
    }




    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                work_num.add(cursor.getString(0));
                work_title.add(cursor.getString(1));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}
