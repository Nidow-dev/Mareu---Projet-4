package elodie.gross.mareu.service;

import java.util.Arrays;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public class DummyReunionGenerator {

    public  static List<Meeting> FAKE_MEETING = Arrays.asList(

            new Meeting("meeting test 1", MeetingRoom.BLANCHE,"30/03/2020","9h40","participant@mareu.fr"),
            new Meeting ("meeting test 2", MeetingRoom.JAUNE,"25/03/2020","18h20","participant@mareu.fr"),
            new Meeting ("meeting test 3", MeetingRoom.BLEUE,"27/03/2020","11h00","participant@mareu.fr"),
            new Meeting ("meeting test 4", MeetingRoom.VERTE,"21/03/2020","15h50","participant@mareu.fr"),
            new Meeting("meeting test 5", MeetingRoom.VIOLETTE,"31/03/2020","10h10","participant@mareu.fr"),
            new Meeting("meeting test 6", MeetingRoom.ROUGE,"24/03/2020","08h00","participant@mareu.fr")

    );
}
