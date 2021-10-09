package com.dproject.alibi_o;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

class CustomAdapterFrag3 extends RecyclerView.Adapter<CustomAdapterFrag3.CustomViewHolder> {

    private ArrayList<Member> arrayList;
    private ArrayList<Time> arrayList2;

    private Context context;
    DatabaseReference databaseReference;

    //  EditText sun_in_input, mon_in_input, tue_in_input, wed_in_input, thu_in_input, fri_in_input, sat_in_input;
    //  EditText sun_out_input, mon_out_input, tue_out_input, wed_out_input, thu_out_input, fri_out_input, sat_out_input;


    public CustomAdapterFrag3(ArrayList<Member> arrayList, ArrayList<Time> arrayList2, Context context) {
        this.arrayList = arrayList;
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_frag3, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("Member");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //  Name을 recyclerview로 나타나게
        // Error: 다른 fragment를 들어갔다 나와야 추가되어 있음
        // holder.name_text.setText(arrayList.get(position).getName());

        final Member member = arrayList.get(position);
        //  final Time time = arrayList2.get(position);
        // Name을 recyclerview로 나타나게
        holder.name_text.setText(arrayList.get(position).getName());


        /*
        holder.sun_in_input.setText(String.valueOf(arrayList2.get(position).getSun_in()));
        holder.mon_in_input.setText(String.valueOf(arrayList2.get(position).getMon_in()));
        holder.tue_in_input.setText(String.valueOf(arrayList2.get(position).getTue_in()));
        holder.wed_in_input.setText(String.valueOf(arrayList2.get(position).getWed_in()));
        holder.thu_in_input.setText(String.valueOf(arrayList2.get(position).getThu_in()));
        holder.fri_in_input.setText(String.valueOf(arrayList2.get(position).getFri_in()));
        holder.sat_in_input.setText(String.valueOf(arrayList2.get(position).getSat_in()));

        holder.sun_out_input.setText(String.valueOf(arrayList2.get(position).getSun_out()));
        holder.mon_out_input.setText(String.valueOf(arrayList2.get(position).getMon_out()));
        holder.tue_out_input.setText(String.valueOf(arrayList2.get(position).getTue_out()));
        holder.wed_out_input.setText(String.valueOf(arrayList2.get(position).getWed_out()));
        holder.thu_out_input.setText(String.valueOf(arrayList2.get(position).getThu_out()));
        holder.fri_out_input.setText(String.valueOf(arrayList2.get(position).getFri_out()));
        holder.sat_out_input.setText(String.valueOf(arrayList2.get(position).getSat_out()));


         */


        // ERROR?
        holder.sun_in_input.setText(arrayList2.get(position).getSun_in());
        holder.mon_in_input.setText(arrayList2.get(position).getMon_in());
        holder.tue_in_input.setText(arrayList2.get(position).getTue_in());
        holder.wed_in_input.setText(arrayList2.get(position).getWed_in());
        holder.thu_in_input.setText(arrayList2.get(position).getThu_in());
        holder.fri_in_input.setText(arrayList2.get(position).getFri_in());
        holder.sat_in_input.setText(arrayList2.get(position).getSat_in());

        holder.sun_out_input.setText(arrayList2.get(position).getSun_out());
        holder.mon_out_input.setText(arrayList2.get(position).getMon_out());
        holder.tue_out_input.setText(arrayList2.get(position).getTue_out());
        holder.wed_out_input.setText(arrayList2.get(position).getWed_out());
        holder.thu_out_input.setText(arrayList2.get(position).getThu_out());
        holder.fri_out_input.setText(arrayList2.get(position).getFri_out());
        holder.sat_out_input.setText(arrayList2.get(position).getSat_out());





    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name_text;
        // LinearLayout mainLayout;
        ImageButton btn_modify;

        EditText sun_in_input, mon_in_input, tue_in_input, wed_in_input, thu_in_input, fri_in_input, sat_in_input;
        EditText sun_out_input, mon_out_input, tue_out_input, wed_out_input, thu_out_input, fri_out_input, sat_out_input;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text = (TextView) itemView.findViewById(R.id.name_text);
            btn_modify = (ImageButton) itemView.findViewById(R.id.btn_modify);

            sun_in_input = (EditText) itemView.findViewById(R.id.sun_in);
            mon_in_input = (EditText) itemView.findViewById(R.id.mon_in);
            tue_in_input = (EditText) itemView.findViewById(R.id.tue_in);
            wed_in_input = (EditText) itemView.findViewById(R.id.wed_in);
            thu_in_input = (EditText) itemView.findViewById(R.id.thu_in);
            fri_in_input = (EditText) itemView.findViewById(R.id.fri_in);
            sat_in_input = (EditText) itemView.findViewById(R.id.sat_in);

            sun_out_input = (EditText) itemView.findViewById(R.id.sun_out);
            mon_out_input = (EditText) itemView.findViewById(R.id.mon_out);
            tue_out_input = (EditText) itemView.findViewById(R.id.tue_out);
            wed_out_input = (EditText) itemView.findViewById(R.id.wed_out);
            thu_out_input = (EditText) itemView.findViewById(R.id.thu_out);
            fri_out_input = (EditText) itemView.findViewById(R.id.fri_out);
            sat_out_input = (EditText) itemView.findViewById(R.id.sat_out);

            btn_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("스케줄 등록하기");
                    builder.setMessage("스케줄을 등록하시겠습니까?"); // 나중에 직원app으로 push알림 보낸 후 수락 가능하도록
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(view.getContext(),"스케줄이 등록되었습니다.", Toast.LENGTH_SHORT).show();

                            String sun_in = sun_in_input.getText().toString();
                            String mon_in = mon_in_input.getText().toString();
                            String tue_in = tue_in_input.getText().toString();
                            String wed_in = wed_in_input.getText().toString();
                            String thu_in = thu_in_input.getText().toString();
                            String fri_in = fri_in_input.getText().toString();
                            String sat_in = sat_in_input.getText().toString();

                            String sun_out = sun_out_input.getText().toString();
                            String mon_out = mon_out_input.getText().toString();
                            String tue_out = tue_out_input.getText().toString();
                            String wed_out = wed_out_input.getText().toString();
                            String thu_out = thu_out_input.getText().toString();
                            String fri_out = fri_out_input.getText().toString();
                            String sat_out = sat_out_input.getText().toString();

                            Time time = new Time(sun_in, mon_in, tue_in, wed_in, thu_in, fri_in, sat_in,
                                    sun_out, mon_out, tue_out, wed_out, thu_out, fri_out, sat_out);
                            // databaseReference.push().setValue(work);
                            int position = getAdapterPosition();
                            final Member member = arrayList.get(position);

                            databaseReference.child(member.getName()).child("Time").setValue(time);
                            // holder.name_text.setText(arrayList.get(position).getName());

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
    }



}
