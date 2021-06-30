package com.dproject.alibi_o;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

class CustomAdapterAdd extends RecyclerView.Adapter<CustomAdapterAdd.CustomViewHolder> {

    private ArrayList<UserAccount> arrayList;
    private ArrayList<UserAccount> filteredUserDataList;

    private Context context;
    DatabaseReference databaseReference;


    public CustomAdapterAdd(ArrayList<UserAccount> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.filteredUserDataList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("Member");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final UserAccount userAccount = arrayList.get(position);
        // EmailId, Name을 recyclerview로 나타나게
        holder.email_text.setText(String.valueOf(arrayList.get(position).getEmailId()));
        holder.name_text.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("직원 추가하기");
                builder.setMessage("해당 직원을 추가하시겠습니까?"); // 나중에 직원app으로 push알림 보낸 후 수락 가능하도록
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"추가되었습니다.", Toast.LENGTH_SHORT).show();
                        String emailId = holder.email_text.getText().toString();
                        String name = holder.name_text.getText().toString();
                        Member member = new Member(emailId, name);
                        databaseReference.push().setValue(member);



                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

            }
        });


    }



    @Override
    public int getItemCount() {
        // 상향 연산자
       // return (arrayList != null ? arrayList.size() : 0);
        //return arrayList.size();
        return filteredUserDataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView email_text;
        TextView name_text;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.email_text = itemView.findViewById(R.id.email_text);
            this.name_text = itemView.findViewById(R.id.name_text);
        }

    }


    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if (Key.isEmpty()){
                    filteredUserDataList = arrayList;
                }
                else{
                    ArrayList<UserAccount> listFiltered = new ArrayList<>();
                    for(UserAccount row : arrayList){
                        if(row.getEmailId().toLowerCase().contains(Key.toLowerCase())){
                            listFiltered.add(row);
                        }
                    }
                    filteredUserDataList = listFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUserDataList = (ArrayList<UserAccount>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }
    /*
    public void filter(CharSequence charSequence) {
        ArrayList<UserAccount> tempArrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(charSequence)) {
            for (UserAccount row : arrayList) {
                if (row.getEmailId().toLowerCase().contains(charSequence)) {
                    tempArrayList.add(row);
                }
            }
        } else {
            arrayList.addAll(arrayListCopy);
        }

        arrayList.clear();
        arrayList.addAll(tempArrayList);
        notifyDataSetChanged();
        tempArrayList.clear();
    }*/
}
