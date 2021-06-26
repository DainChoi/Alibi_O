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

import java.util.ArrayList;

class CustomAdapterAdd extends RecyclerView.Adapter<CustomAdapterAdd.CustomViewHolder> {

    private ArrayList<UserAccount> arrayList;
    private ArrayList<UserAccount> filteredUserDataList;

    private Context context;

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
            public void onClick(View view) { // 검색한 item 클릭 시 name 받아옴
                confirmDialog();

                /*
                Intent intent = new Intent(context,WorkActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("name", filteredUserDataList.get(position).getName());
                context.startActivity(intent); // ERROR: frag1으로 이동됨.
                */


              //  Bundle bundle = new Bundle();
              //  bundle.putString("name", userAccount.getName());
              //  bundle.putString("name", arrayList.get(position).getName().getText().toString());
               // CustomAdapterFrag4.setArguments(bundle);
                /*
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Frag4 frag4 = new Frag4();//프래그먼트2 선언
                frag4.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.frame, frag4);
                transaction.commit();

                FragmentTransaction transection = getFragmentManager().beginTransaction();
                SecondFragment mfragment=new SecondFragment();
                transection.replace(R.id.main_fragment, mfragment);
                transection.commit();
                */



            }
        });





    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("직원 추가하기");
        builder.setMessage("해당 직원을 추가하시겠습니까?"); // 나중에 직원app으로 push알림 보낸 후 수락 가능하도록
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
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
