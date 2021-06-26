package com.dproject.alibi_o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomAdapterFrag4 extends RecyclerView.Adapter<CustomAdapterFrag4.CustomViewHolder> {

    private ArrayList<UserAccount> arrayList;
    private ArrayList<UserAccount> filteredUserDataList;
   // private ArrayList<UserAccount> arrayListCopy;

    private Context context;

    public CustomAdapterFrag4(ArrayList<UserAccount> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
       // this.arrayListCopy = new ArrayList<>();
       // arrayListCopy.addAll(arrayList);
        this.filteredUserDataList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // EmailId, Name을 recyclerview로 나타나게
        holder.email_text.setText(String.valueOf(arrayList.get(position).getEmailId()));
        holder.name_text.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 검색한 item 클릭 시 name 받아옴
                Intent intent = new Intent(context,WorkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("name", filteredUserDataList.get(position).getName());
                context.startActivity(intent);

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
