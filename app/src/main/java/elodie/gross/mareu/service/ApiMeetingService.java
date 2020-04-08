package elodie.gross.mareu.service;

import java.util.List;

import elodie.gross.mareu.model.Meeting;

public class ApiMeetingService implements FakeApiMeeting {



    private List <Meeting> meeting = DummyMeetingGenerator.generateMeeting();



// Afficher la liste des réunions


  @Override
    public List<Meeting> getMeeting() {

      return meeting;
    }

// Ajouter une réunion

    @Override
    public void addMeeting(Meeting meeting){

        this.meeting.add(meeting);

    }

// Supprimer une réunion
    @Override
    public void delMeeting(Meeting meeting) {
        this.meeting.remove(meeting);

    }
}
