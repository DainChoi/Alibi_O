package com.dproject.alibi_o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomAdapterFrag4 extends RecyclerView.Adapter<CustomAdapterFrag4.CustomViewHolder> {

    private ArrayList<Member> arrayList;

    private Context context;

    public CustomAdapterFrag4(ArrayList<Member> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_frag4, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //  Name을 recyclerview로 나타나게
        // Error: 다른 fragment를 들어갔다 나와야 추가되어 있음
        holder.name_text.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }

    @Override
    public int getItemCount() {
        // 상향 연산자
       // return (arrayList != null ? arrayList.size() : 0);
        //return arrayList.size();
        return arrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name_text;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name_text = itemView.findViewById(R.id.name_text);
        }
    }



}
