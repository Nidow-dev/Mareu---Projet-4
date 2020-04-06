package elodie.gross.mareu.service;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;

public class ApiMeetingService implements ApiMeeting {

    private List <Meeting> meeting = DummyMeetingGenerator.generateMeeting();

// Afficher la liste des salles de reunions

  /**  @Override
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

    } **/

// Afficher la liste des réunions


  @Override
    public List<Meeting> getMeeting() {
        return meeting;
    }

// Ajouter une réunion

    @Override
    public void addMeeting(Meeting meeting){

        new DI();
      // Rajouter la classe DI
    }

// Supprimer une réunion
    @Override
    public void delMeeting(Meeting meeting) {

      DI.delMeeting;
      // Rajouter la classe DI
    }
}
