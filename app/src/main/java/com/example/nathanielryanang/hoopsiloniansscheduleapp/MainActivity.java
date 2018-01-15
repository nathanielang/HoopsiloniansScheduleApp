package com.example.nathanielryanang.hoopsiloniansscheduleapp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button mSetDateBtn;
    AutoCompleteTextView mLocationActv;
    Button mConfirmBtn;


    DatePickerDialog mDatePickerDialog;

    int mTeamOne;
    int mTeamTwo;
    String mStringDate;
    String mLocation;

    final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetDateBtn = findViewById(R.id.set_date_btn);
        mLocationActv = findViewById(R.id.location_actv);
        mConfirmBtn = findViewById(R.id.confirm_btn);

        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(this,R.array.locations_array,android.R.layout.select_dialog_item);
        mLocationActv.setThreshold(1);
        mLocationActv.setAdapter(locationAdapter);

        mSetDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //copied from online
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                mDatePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            // copied from online
                            /*Calendar calendar = Calendar.getInstance();
                            final  SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    Calendar newDate = Calendar.getInstance();
                                    newDate.set(year, monthOfYear, dayOfMonth);
                                    System.out.print(dateFormatter.format(newDate.getTime()));
                                }

                            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();*/

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Calendar newDate = Calendar.getInstance();
                                newDate.set(year, monthOfYear, dayOfMonth);

                                mStringDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;

                                mSetDateBtn.setText(mStringDate);

                                Log.d("Hoops", "the date is "+ mStringDate);
                                //Why does it only set when the variable name is mYearSet? If the variable name is also "year", it doesn't set year = year


                            }
                        }, mYear, mMonth, mDay);

                mDatePickerDialog.show();
                // why is this needed or else crash
                Log.d("Hoops", " "+mStringDate);
            }
        });

        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocation = mLocationActv.getText().toString();
                Log.d("Hoops", " the location is "+mLocation);
                Log.d("Hoops", "the date is "+mStringDate);
            }
        });

    }
}
