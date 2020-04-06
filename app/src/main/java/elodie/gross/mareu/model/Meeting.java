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
    private String mParticipants;
    private String mRoom;

    // private Integer mColor;

    public Meeting(String meetingName, Calendar date, Calendar heure, String participants, String room) {
        mMeetingName = meetingName;
        mDate = date;
        mHeure = heure;
        mParticipants = participants;
        mRoom = room;


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
