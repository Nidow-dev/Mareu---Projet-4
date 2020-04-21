package elodie.gross.mareu.ui;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import elodie.gross.mareu.R;
import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
        List <Meeting> mMeetingList;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case

TextView description, participants, date, heure, room;
ImageView roundColor;





            public Meeting meeting;
            public MyViewHolder(View v) {
                super(v);

                roundColor = v.findViewById(R.id.item_circle_color);
                description = v.findViewById(R.id.item_description);
                participants = v.findViewById(R.id.item_participants);
                date = v.findViewById(R.id.item_date);
                delButton = itemView.findViewById(R.id.delete_item);
                room = v.findViewById(R.id.item_salle);

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
            holder.participants.setText(mMeetingList.get(position).getmParticipants());
          /// ajouter les images  holder.roundColor.setImageDrawable();

            SimpleDateFormat mDate = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
            String setDate = mDate.format(mMeetingList.get(position).getmDate().getTime());
           holder.date.setText(setDate);
           holder.room.setText(mMeetingList.get(position).getmRoom());
           holder.roundColor.setImageDrawable(R.id.);


            delButton.setOnClickListener(view -> callback.onClickDelete(meeting));
            delButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Meeting meeting = delete Meeting();
                    DI.getApiMeeting().delMeeting(meeting);
                    finish(); }

            });




           Resources resources=getResources();
            final TypedArray imgs = getResources().obtainTypedArray(R.array.random_images_array);
            final Random rand = new Random();
            final int rndInt = rand.nextInt(imgs.length());
            final int resID = imgs.getResourceId(rndInt, 0);


            int[] images = {R.drawable.circle_0,R.drawable.circle_1,R.drawable.circle_2,R.drawable.circle_3, R.drawable.circle_4, R.drawable.circle_5};
            Random rand = new Random();


        }


        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mMeetingList.size();
        }
    }

