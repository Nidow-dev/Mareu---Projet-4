package elodie.gross.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public interface FakeApiMeeting {



    List<Meeting> getMeeting();

    // Ajouter une réunion

    void addMeeting(Meeting meeting);

    // Supprimer une réunion

    void delMeeting(Meeting meeting);
}

