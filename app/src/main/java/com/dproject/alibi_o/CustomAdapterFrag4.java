package com.dproject.alibi_o;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

class CustomAdapterFrag4 extends RecyclerView.Adapter<CustomAdapterFrag4.CustomViewHolder> {

    private ArrayList<Member> arrayList;

    private Context context;
    DatabaseReference databaseReference;

    public CustomAdapterFrag4(ArrayList<Member> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_frag4, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("Member");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //  Name을 recyclerview로 나타나게
        // Error: 다른 fragment를 들어갔다 나와야 추가되어 있음
        holder.name_text.setText(arrayList.get(position).getName());

        holder.mainLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("직원 삭제하기");
                builder.setMessage("해당 직원을 삭제하시겠습니까?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                        databaseReference.removeValue(); // 데이터베이스에서 항목 제거
                        deleteItem(position); // 리사이클러뷰 다시 정렬

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

                return true;
            }
        });



    }

    private void deleteItem(int position) {
        arrayList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, arrayList.size());
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
        LinearLayout mainLayout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name_text = itemView.findViewById(R.id.name_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }



}
