package elodie.gross.mareu.ui;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import elodie.gross.mareu.R;
import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;

import static java.security.AccessController.getContext;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements Filterable {

    List <Meeting> mMeetingList;
    List<Meeting> mMeetingListFull;


    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView description, participants, date, heure, room;
        ImageView roundColor;
        ImageButton delButton;



        public Meeting meeting;
        public MyViewHolder(View v) {
            super(v);

            roundColor = v.findViewById(R.id.item_circle_color);
            description = v.findViewById(R.id.item_description);
            participants = v.findViewById(R.id.item_participants);
            date = v.findViewById(R.id.item_date);
            heure = v.findViewById(R.id.item_heure);
            delButton = itemView.findViewById(R.id.delete_item);
            room = v.findViewById(R.id.item_salle);

            Resources resources=v.getResources();
            final TypedArray imgs = v.getResources().obtainTypedArray(R.array.roundColor);
            final Random rand = new Random();
            final int rndInt = rand.nextInt(imgs.length());
            final int resID = imgs.getResourceId(rndInt, 0);


            roundColor.setImageResource(resID);


        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyRecyclerViewAdapter(List<Meeting> mMeetingList) {
        this.mMeetingList = mMeetingList;
        this.mMeetingListFull = new ArrayList<>(mMeetingList);
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
        holder.participants.setText(mMeetingList.get(position).getmParticipants());
        SimpleDateFormat mDate = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        String setDate = mDate.format(mMeetingList.get(position).getmDate().getTime());
        holder.date.setText(setDate);
        SimpleDateFormat mHeure = new SimpleDateFormat(("hh:mm"), Locale.FRANCE);
        String setHeure = mHeure.format(mMeetingList.get(position).getmDate().getTime());
        holder.heure.setText(setHeure);
        holder.room.setText(mMeetingList.get(position).getmRoom());


        /// holder.delButton.setOnClickListener(view -> callback.onClickDelete(meeting)); ///
        final Meeting meeting = mMeetingList.get(position);
        holder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DI.getApiMeeting().delMeeting(meeting);
                notifyDataSetChanged();
            }

        });


        // Return the size of your dataset (invoked by the layout manager)
    }
    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }

    /// Gestion des filtres ///


    @Override
    public Filter getFilter() {
        return filter;
    }
/***
        public void onDateSet (DatePicker view, int month, int dayOfMonth ) {
        if (month<10){
            DateFilter = dayOfMonth + "/0" + "/" + Year;
        } else {

        }
    }
***/
    Filter filter = new Filter() {

        /// FILTRE SEARCHVIEW ///

        // Run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Meeting> filteredList = new ArrayList<>();
            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(mMeetingListFull);
            } else {

                for (Meeting meeting : mMeetingListFull) {
                    if (meeting.getmRoom().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(meeting);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

            // Run on an UI thread
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mMeetingList.clear();
                mMeetingList.addAll((Collection<? extends Meeting>) filterResults.values);
                notifyDataSetChanged();
            }

    };


    }

