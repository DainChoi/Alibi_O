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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        empty_imageview = (ImageView) view.findViewById(R.id.empty_imageview);
        no_data = (TextView) view.findViewById(R.id.no_data);

       // String s = getIntent().getStringExtra("name");
       // recyclerView.setText(s);


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
