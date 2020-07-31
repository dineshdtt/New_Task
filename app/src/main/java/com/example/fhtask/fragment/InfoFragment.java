package com.example.fhtask.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;

import com.example.fhtask.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InfoFragment extends Fragment {

    TextInputLayout til_invest,til_date,til_unit,til_price;
    TextInputEditText edt_invest,edt_date,edt_unit,edt_price;
    Switch mSwitch;
    Button btn_Add;
    Calendar myCalendar;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info, container, false);

        til_invest = (TextInputLayout) root.findViewById(R.id.til_1);
        til_date = (TextInputLayout) root.findViewById(R.id.til_2);
        til_unit = (TextInputLayout) root.findViewById(R.id.til_3);
        til_price = (TextInputLayout) root.findViewById(R.id.til_4);

        edt_invest = (TextInputEditText) root.findViewById(R.id.edt_1);
        edt_date = (TextInputEditText) root.findViewById(R.id.edt_date);
        edt_unit = (TextInputEditText) root.findViewById(R.id.edt_no_unit);
        edt_price = (TextInputEditText) root.findViewById(R.id.edt_price);

        mSwitch = (Switch) root.findViewById(R.id.btn_switch);
        btn_Add = (Button)root.findViewById(R.id.add);

           myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        return root;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edt_date.setText(sdf.format(myCalendar.getTime()));
    }
}