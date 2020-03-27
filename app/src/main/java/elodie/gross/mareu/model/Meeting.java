package elodie.gross.mareu.model;

import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Meeting implements Serializable {

    private String mTopic;
    private String mMeetingName;
    private Calendar mDate;
    private Calendar mHeure;
    private List<String> mParticipants;

    // private Integer mColor;

    public Meeting(String meetingName, Calendar date, Calendar heure, List<String> participants) {
        mMeetingName = meetingName;
        mDate = date;
        mHeure = heure;
        mParticipants = participants;

        // Couleur aléatoire //

        // Random rnd = new Random();
        // int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        // view.setBackgroundColor(color);
    }

    public String getmMeetingName() {
        return mMeetingName;
    }

    public Calendar getmDate() {
        return mDate;
    }

    public Calendar getHeure() {
        return mHeure;
    }

    public String getTopic() {
        return mTopic;
    }

}
