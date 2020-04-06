package elodie.gross.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public class DummyMeetingGenerator {

    static List <Meeting> generateMeeting() {

        return new ArrayList<>(FAKE_MEETING);
    }
    public  static List<Meeting> FAKE_MEETING = Arrays.asList(

            new Meeting("meeting test 1", Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "MeetingRoom.BLANCHE"),
            new Meeting ("meeting test 2",Calendar.getInstance(),Calendar.getInstance() ,"participant@mareu.fr", "MeetingRoom.JAUNE"),
            new Meeting ("meeting test 3",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr" , "MeetingRoom.BLEUE"),
            new Meeting ("meeting test 4",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr" , "MeetingRoom.VERTE"),
            new Meeting( "meeting test 5",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "MeetingRoom.VIOLETTE"),
            new Meeting("meeting test 6",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "MeetingRoom.ROUGE"));


    }


