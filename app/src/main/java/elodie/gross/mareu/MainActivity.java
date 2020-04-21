package elodie.gross.mareu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.FakeApiMeeting;
import elodie.gross.mareu.ui.MyRecyclerViewAdapter;

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
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        Intent intent = new Intent("SORT_ACTION");
        switch (item.getItemId()) {
            case R.id.sort_by_name:
                Log.e("room", "onOptionsItemSelected: ROOM");
                intent.putExtra("SORTBY", "ROOM");
                break;
            case R.id.sort_by_date:
                intent.putExtra("SORTBY", "DATE");
                break;

            return super.onOptionsItemSelected(item);
        }
        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
        return super.onOptionsItemSelected(item);

        // Rafraichir la list de la RecyclerView onResume ou onStart et initList

    }
}
