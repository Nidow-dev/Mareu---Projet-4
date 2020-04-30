package elodie.gross.mareu;

import android.widget.DatePicker;
import android.widget.TimePicker;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;
import elodie.gross.mareu.service.DummyMeetingGenerator;

import static elodie.gross.mareu.service.DummyMeetingGenerator.FAKE_MEETING;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class ApiUnitaireTest {}

    private ApiMeetingService service;

    private MainActivity mActivity;
    private ApiMeetingService mApiService;
    private List<Meeting> mMeetings;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mApiService = DI.getNewInstanceApiMeeting();
        mMeetings = mApiService.getMeetings();
    }

/// Ajouter la réunion depuis l'API ///

    @Test
    public void addMeetingWithSuccess() {

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
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));
    }

    // Filtre Heure

    @Test
    public void sortMeetingByDate(){
        mMeetings = mApiService.getMeetings();
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
    }

    /// Fltre par nom
    @Test
    public void sortMeetingByRoom(){
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
    }
