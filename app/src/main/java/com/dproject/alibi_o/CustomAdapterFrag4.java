package com.dproject.alibi_o;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterFrag4 extends RecyclerView.Adapter<CustomAdapterFrag4.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList work_num, work_title;
    private ImageButton btn_delete2;
    String num;



    CustomAdapterFrag4(Activity activity, Context context, ArrayList work_num, ArrayList work_title,
                       ImageButton btn_delete2){
        this.activity = activity;
        this.context = context;
        this.work_num = work_num;
        this.work_title = work_title;
        this.btn_delete2 = btn_delete2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_frag4, parent, false);

        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //holder.work_num_txt.setText(String.valueOf(work_num.get(position)));
        holder.work_title_txt.setText(String.valueOf(work_title.get(position)));
        //Recyclerview onClickListener
        holder.btn_delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //work_num.remove(position);
                //notifyItemRemoved(position);
                //notifyItemRangeChanged(position, getItemCount());

                //MyDatabaseHelperFrag4 myDB = new MyDatabaseHelperFrag4(context);
                //myDB.deleteOneRow(num);
                // ERROR: 삭제 안됨.
                // Swipe to delete btn change.

            }
        });


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MemberActivity.class);
                activity.startActivityForResult(intent, 1);

            }
        });



    }


    @Override
    public int getItemCount() {
        return work_num.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView work_num_txt;
        TextView  work_title_txt;
        LinearLayout mainLayout;
        ImageButton btn_delete2;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            work_num_txt = itemView.findViewById(R.id.work_num_txt);
            work_title_txt = itemView.findViewById(R.id.work_title_txt);
            btn_delete2 = itemView.findViewById(R.id.btn_delete2);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}