package com.dproject.alibi_o;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

class CustomAdapterFrag1 extends RecyclerView.Adapter<CustomAdapterFrag1.CustomViewHolder> {

    private ArrayList<TimeIn> arrayList;
    private ArrayList<TimeOut> arrayList2;

    private Context context;
    DatabaseReference databaseReference;

    //  EditText sun_in_input, mon_in_input, tue_in_input, wed_in_input, thu_in_input, fri_in_input, sat_in_input;
    //  EditText sun_out_input, mon_out_input, tue_out_input, wed_out_input, thu_out_input, fri_out_input, sat_out_input;


    public CustomAdapterFrag1(ArrayList<TimeIn> arrayList, ArrayList<TimeOut> arrayList2,  Context context) {
        this.arrayList = arrayList;
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_time, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("TimeIn");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //  Name을 recyclerview로 나타나게
        // Error: 다른 fragment를 들어갔다 나와야 추가되어 있음
        // holder.name_text.setText(arrayList.get(position).getName());


        // Name을 recyclerview로 나타나게
        // holder.name_text.setText(arrayList.get(position).getName());
        holder.time_in.setText(arrayList.get(position).getTime_in());
        holder.time_out.setText(arrayList2.get(position).getTime_out());



    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name_text, time_in, time_out;
        // LinearLayout mainLayout;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text = (TextView) itemView.findViewById(R.id.name_text);
            time_in = (TextView) itemView.findViewById(R.id.time_in);
            time_out = (TextView) itemView.findViewById(R.id.time_out);

        }
    }



}
