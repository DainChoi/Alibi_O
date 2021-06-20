package com.dproject.alibi_o;

import android.content.Intent;
import android.os.Bundle;
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

public class Frag1 extends Fragment {

    private View view;
/*
    RecyclerView recycle1;
    RecycleAdapter adapter;

    int imgID[] = {R.drawable.icon, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo,
            R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};

    String title[] = {"logo1", "logo2", "logo3", "logo4", "logo5", "logo6", "logo7", "logo8", "logo9", "logo10"};

    String content[] = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10"};

*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

/*
        recycle1 = (RecyclerView) view.findViewById(R.id.recycle1);

        adapter = new RecycleAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycle1.setLayoutManager(layoutManager);

        for (int i = 0; i < imgID.length; i++){
            adapter.addItem(new ItemData(imgID[i],title[i],content[i]));
        }

        recycle1.setAdapter(adapter);

        adapter.setOnItemClickListner(new OnItemDataClickListener() {

            public void OnItemClick(RecycleAdapter.ViewHolder holder, View view, int position) {
                ItemData data = adapter.getItem(position);
               // Toast.makeText(getApplicationContext(),data.title+"가 선택됨",Toast.LENGTH_SHORT).show();

            }
        });*/

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
