package elodie.gross.mareu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.FakeApiMeeting;
import elodie.gross.mareu.ui.MyRecyclerViewAdapter;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public FakeApiMeeting mApiMeeting;

    private List<Meeting> mMeetingList;
    private Meeting adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mApiMeeting = DI.getApiMeeting();
        mMeetingList = mApiMeeting.getMeeting();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMeeting.class);
                startActivity(intent);


            }
        });

        // RecyclerView


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyRecyclerViewAdapter(mMeetingList);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mMeetingList = mApiMeeting.getMeeting();
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Inflate the options menu from XML

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.filtre_nom).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        


        return true;
    }


    // Do not iconify the widget; expand it by default


    /*** public void setOnQueryTextListener (SearchView.OnQueryTextListener listener); ***/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.filtre_nom) {
        }

        if (id == R.id.filtre_date) {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog mDatePickerDialog;

            mDatePickerDialog = new DatePickerDialog(Objects.requireNonNull(this),
                    (view, year, month, dayOfMonth) -> {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        // methode qui prends Calendar en parametre, et va vérifier les meeting pour afficher celles de la date choisies et afficher la nouvelle liste


                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));

            mDatePickerDialog.show();


            return true;
        }


        return super.onOptionsItemSelected(item);

        // Rafraichir la list de la RecyclerView onResume ou onStart et initList

    }
}

