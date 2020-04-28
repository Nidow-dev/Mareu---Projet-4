package elodie.gross.mareu.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import elodie.gross.mareu.R;
import elodie.gross.mareu.model.Meeting;

public class RecyclerViewFilter extends RecyclerView.Adapter<RecyclerViewFilter.FilterViewHolder> implements Filterable {

    private List<FiltreNom> filtreNomList;
    private Liste<FiltreNom> filtreNomListFull;

    class FilterViewHolder extends RecyclerView.ViewHolder {

        TextView description, participants, date, heure, room;
        ImageView roundColor;
        ImageButton delButton;

        public FilterViewHolder(View v) {
            super(v);


        roundColor = v.findViewById(R.id.item_circle_color);
        description = v.findViewById(R.id.item_description);
        participants = v.findViewById(R.id.item_participants);
        date = v.findViewById(R.id.item_date);
        heure = v.findViewById(R.id.item_heure);
        delButton = itemView.findViewById(R.id.delete_item);
        room = v.findViewById(R.id.item_salle);
    }
}
FilterAdapter(List<FiltreNom>) filtreNom){
this.filtreNomList = filtreNomList}
filtreNomListFull = new ArrayList<>(filtreNomList);
}

@NonNull
@Override
public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    view v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_items_list, parent, attachToRoot false);
    return new FilterViewHolder(v);
}

@Override
public void onBindViewHolder(@NonNull, FilterViewHolder, int position ) {
    FilterItem currentItem = filtreNomList.get(position);

    @Override
    public Filter getFilter () {
        return FiltreNom;
    }

    private Filter FiltreNom = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List <FilterItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(filtreNomListFull);
        } else {
                String FilterPattern = constraint.toString().toLowerCase().trim();
                for (FilterItem item : filtreNomListFull) {
                    if (item.getMeeting).toLowerCase().contains)(FilterPattern)) {
                    filteredList.add(item);
                    }
                }
            }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

        }
    };
}
FilterResults results = new FilterResults();
    results.values = filteredList;

    return; results;

    @Override
            protected void publishResults(CharSequence constraint, fi)
}
