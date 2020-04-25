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

            new Meeting("Reunion A", Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "Luigi"),
            new Meeting ("Reunion B",Calendar.getInstance(),Calendar.getInstance() ,"participant@mareu.fr", "Peach"),
            new Meeting ("Reunion C",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr" , "Mario"),
            new Meeting ("Reunion D",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr" , "Wario"),
            new Meeting( "Reunion E",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "Toad"),
            new Meeting("Reunion F",Calendar.getInstance(),Calendar.getInstance(),"participant@mareu.fr", "Daisy"));


    }


