package elodie.gross.mareu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.R;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeeting;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
        private String[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public Meetings meeting;
            public MyViewHolder(Meeting v) {
                super(v);
                Meeting = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyRecyclerViewAdapter(String[] Meetings) {
            mMeetings = myMeetings;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.setText(mMeetings[position]);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mMeetings.length;
        }
    }

