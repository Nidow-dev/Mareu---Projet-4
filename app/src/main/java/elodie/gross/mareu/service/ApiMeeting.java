package elodie.gross.mareu.service;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;

public interface ApiMeeting {

   /** List<String> getRooms();

    // Ajouter une réunion

    void addRoom(String room);

    // Supprimer une réunion

    void delRoom(String room);

   // Tout effacer

    void delAllRooms();

    // Liste des réunions **/

    List<Meeting> getMeeting();

    // Ajouter une réunion

    void addMeeting(Meeting meeting);

    // Supprimer une réunion

    void delMeeting(Meeting meeting);
}

