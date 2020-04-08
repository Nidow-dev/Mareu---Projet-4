package elodie.gross.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import elodie.gross.mareu.R;
import elodie.gross.mareu.model.Meeting;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
        List <Meeting> mMeetingList;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case

TextView description, participants;
ImageView roundColor;


            public Meeting meeting;
            public MyViewHolder(View v) {
                super(v);

                roundColor = v.findViewById(R.id.item_circle_color);
                description = v.findViewById(R.id.item_description);
                participants = v.findViewById(R.id.item_participants);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyRecyclerViewAdapter(List<Meeting> mMeetingList) {
            this.mMeetingList = mMeetingList;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.meeting_items_list, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.description.setText(mMeetingList.get(position).getmMeetingName());


        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mMeetingList.size();
        }
    }

