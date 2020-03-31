package elodie.gross.mareu;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public class AddMeeting extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime, meetingName, participants;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Spinner spinner;
    Button btnValider;
    Calendar calendarDate, calendarTime;
    Meeting meeting;

    // finir liste participants

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mareu_add);


        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);
        spinner = (Spinner) findViewById(R.id.spinner_salles);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnValider = (Button) findViewById(R.id.btn_valider);
        meetingName = (EditText) findViewById(R.id.mareu_type_name);
        participants = (EditText) findViewById(R.id.emails);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meeting meeting = new Meeting(meetingName.getText().toString(), calendarDate, calendarTime, participants.getText().toString(), spinner);  // liste participants
            }
        });

 /** Salle de Réunion Spinner **/

        List<String> rooms = Arrays.asList("Salle A", "Salle B", "Salle C", "Salle D", "Salle E");
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, rooms));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            calendarDate = Calendar.getInstance();
                            calendarDate.set(year, monthOfYear, dayOfMonth);

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);


            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            calendarTime = Calendar.getInstance();
                            calendarTime.set(calendarDate.get(Calendar.YEAR), calendarDate.get(Calendar.MONTH), calendarDate.get(Calendar.DATE), hourOfDay, minute);

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
    }



    /** private void addReunion() {
        String roomName = validateTextInput(mRoomNameTextInputLayout);
        String topic = validateTextInput(mTopicTextInputLayout);
        Calendar date = validateDateInput(mDateTextInputLayout);
        Calendar heure = validateTimeInput(mHeureTimeTextInputLayout);
        Calendar minutes = validateTimeInput(mMinutesTimeTextInputLayout);
        List<String> participants = validateEmailInput;

    }**/
}