package elodie.gross.mareu;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;

import static elodie.gross.mareu.service.DummyMeetingGenerator.FAKE_MEETING;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class ApiUnitaireTest {

    private ApiMeetingService service;

    private MainActivity mActivity;
    private ApiMeetingService mApiService;
    private List<Meeting> mMeetings;

    @Before
    public void setup() {
        mApiService = DI.getNewInstanceFakeApiMeeting();
    }
/// Ajouter la réunion depuis l'API ///

    void addMeeting() {
        Meeting meeting = new Meeting(
                "Reunion A",
                Calendar.getInstance(),
                Calendar.getInstance(),
                "participant@mareu.com",
                "Peach");

        finally{
            mApiService.addMeeting(meeting);
        }
    }


/// Afficher la liste des réunion depuis l'API ///

    @Test
    public void getMeetingWithSuccess() {
        List<Meeting> meetings = service.getMeeting();
        List<Meeting> expectedMeeting = FAKE_MEETING;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeeting.toArray()));
    }


    /// Supprimer une réunion depuis l'API
    @Test
    public void deleteMeetingWithSuccess() {
        Meeting meetingToDelete = service.getMeeting().get(0);
        service.delMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));
    }

    // Filtre Heure

    @Test
    public void filterByDate(){
            Date date = new Date();

            mApiService.addMeeting(new Meeting(1, date, new Date(), "Reunion A", mApiService.getMeetingRoom().get(0), mApiService.getParticipants()));
            mApiService.addMeeting(new Meeting(2, date, new Date(), "Reunion B", mApiService.getMeetingRoom().get(1), mApiService.getParticipants()));

            date = new Date();
            mApiService.addMeeting(new Meeting(3, date, new Date(), "Meeting n°3", mApiService.getMeetingRoom().get(1), mApiService.getParticipants()));

            List<Meeting> meetings = mApiService.getMeetingsByDate("15/01/2020");
            assertEquals(2, meetings.size());
            assertEquals("Reunion A", meetings.get(0).getmMeetingName());
            assertEquals("Reunion B", meetings.get(1).getmMeetingName());

            meetings = mApiService.getMeetingsByDate("01/05/2020");
            assertEquals(1, meetings.size());
            assertEquals("Meeting n°3", meetings.get(0).getmMeetingName());
        }


   /*** public void sortMeetingByDate(){
        mMeetings = service.getMeeting();
        Collections.sort(mMeetings, new DummyMeetingGenerator.MeetingComparatorTime());
        Date date1 = null, date2 = null;
        for (Meeting meeting : mMeetings){
            if (date1 == null && date2 == null){
                date1 = meeting.getDate();
            }else if (date1 != null && date2 == null){
                date2 = meeting.getDate();
                assertTrue(date1.before(date2));
            }else {
                date1 = date2;
                date2 = null;
            }
        }
    } ***/

    /// Fltre par nom

@Test
    public void FilterByRoom(){
        mApiService.addMeeting(new Meeting(1, new Date(), new Date(), "Meeting n°1", mApiService.getMeetingRoom().get(0), mApiService.getParticipants()));
        mApiService.addMeeting(new Meeting(2, new Date(), new Date(), "Meeting n°2", mApiService.getMeetingRoom().get(0), mApiService.getParticipants()));

        List<MeetingRoom> meetingRooms = new ArrayList<>();
        meetingRooms.add(mApiService.getMeetingRooms().get(0));

        Meeting meeting_inList = mApiService.getMeeting().get(0);
        meeting_inList.setMeetingRoom(mApiService.getMeetingRoom().get(0));

        Meeting meeting_notInList = mApiService.getMeeting().get(1);
        meeting_notInList.setMeetingRoom(mApiService.getMeetingRooms().get(2));

        List<Meeting> meetings = mApiService.getMeeting(MeetingRoom);
        assertTrue(meetings.contains(meeting_inList));
        assertFalse(meetings.contains(meeting_notInList));
        }
        }

/***
        mMeetings = mApiService.getMeetings();
        Collections.sort(mMeetings, new DummyMeetingGenerator.MeetingComparatorRoom());
        String room1 = null, room2 = null;
        for (Meeting meeting : mMeetings){
            if (room1 == null && room2 == null){
                room1 = meeting.getmMeetingName();
            }else if (room1 != null && room2 == null){
                room2 = meeting.getMeetingName();
                assertTrue(room1.compareTo(room2)<=0);
            }else {
                room1 = room2;
                room2 = null;
            }
        }
    }***/

