package elodie.gross.mareu.model;

import java.io.Serializable;
import java.util.Calendar;

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

    public String getmParticipants() {return mParticipants; }

    public String getmRoom () { return mRoom;}

}
