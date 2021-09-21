package com.dproject.alibi_o;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

public class Frag3 extends Fragment {

    private View view;
    EditText name_input;
    EditText sun_in_input, mon_in_input, tue_in_input, wed_in_input, thu_in_input, fri_in_input, sat_in_input;
    EditText sun_out_input, mon_out_input, tue_out_input, wed_out_input, thu_out_input, fri_out_input, sat_out_input;
    ImageButton btn_check;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        name_input = view.findViewById(R.id.name_input);
        sun_in_input = view.findViewById(R.id.sun_in);
        mon_in_input = view.findViewById(R.id.mon_in);
        tue_in_input = view.findViewById(R.id.tue_in);
        wed_in_input = view.findViewById(R.id.wed_in);
        thu_in_input = view.findViewById(R.id.thu_in);
        fri_in_input = view.findViewById(R.id.fri_in);
        sat_in_input = view.findViewById(R.id.sat_in);

        sun_out_input = view.findViewById(R.id.sun_out);
        mon_out_input = view.findViewById(R.id.mon_out);
        tue_out_input = view.findViewById(R.id.tue_out);
        wed_out_input = view.findViewById(R.id.wed_out);
        thu_out_input = view.findViewById(R.id.thu_out);
        fri_out_input = view.findViewById(R.id.fri_out);
        sat_out_input = view.findViewById(R.id.sat_out);


        databaseReference = FirebaseDatabase.getInstance().getReference("Alibi").child("time");

        btn_check = view.findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_input.getText().toString();
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

                Time time = new Time(name, sun_in, mon_in, tue_in, wed_in, thu_in, fri_in, sat_in,
                        sun_out, mon_out, tue_out, wed_out, thu_out, fri_out, sat_out);
                // databaseReference.push().setValue(work);
                databaseReference.child(time.getName()).setValue(time);
                Toast.makeText(getActivity(), "스케줄이 등록되었습니다!", Toast.LENGTH_SHORT).show();

                //  Intent intent = new Intent(WorkaddActivity.this, MainActivity.class);
                //  startActivity(intent);
                //  finish();
            }
        });


        final CollapsibleCalendar collapsibleCalendar = view.findViewById(R.id.calendarView);
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDayChanged() {

            }

            @Override
            public void onClickListener() {

            }

            @Override
            public void onDaySelect() {
                Day day = collapsibleCalendar.getSelectedDay();
                Log.i(getClass().getName(), "Selected Day: "
                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());
            }

            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });

        return view;
    }



}
