package elodie.gross.mareu.service;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public class ApiMeetingService implements ApiMeeting {

// Afficher la liste des salles de reunions

    @Override
    public List<String> getRooms() {
        return Rooms;
    }
// Ajouter une salle de réunion

    @Override
    public void addRoom(String room){

    }

// Supprimer une salle de réunion

    @Override
    public void delRoom(String room) {

    }

// Supprimer toute les salles de réunions
    @Override
    public void delAllRooms() {

    }

// Afficher la liste des réunions

    @Override
    List<Meeting> getMeetings(Calendar date, String roomName);

    @Override
    public List<Meeting> getMeeting() {
        return Meeting;
    }

// Ajouter une réunion

    @Override
    void addMeeting(Meeting meeting){

    }

// Supprimer une réunion
    @Override
    public void delMeeting(Meeting meeting) {

    }
}
