package elodie.gross.mareu;

import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static elodie.gross.mareu.service.DummyMeetingGenerator.FAKE_MEETING;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

public class AddMeetingInstrumentedTest {

    private static int ITEMS_COUNT = 12;

    private MainActivity mActivity;
    private ApiMeetingService mApiMeetingService;
    private List<Meeting> mMeeting;


/// Test le bouton ajouter ///

   @Test
    public void checkAddButton(){
        onView(allOf(ViewMatchers.withId(R.id.fab), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));

        onView(ViewMatchers.withId(R.id.btn_valider)).perform(click()).check(matches(isEnabled()));
       }

/// Affiche la nouvelle réunion lorsqu'elle est ajoutée avec le bouton ///

    @Test
    public void givenMeetingList_when_Add_With_Floating_Button() {
        Intents.init();
        onView(ViewMatchers.withId(R.id.add))
        .perform(click());
        intended(hasComponent(AddMeeting.class.getName()));
        Intents.release();
        }


/// Afficher la liste sans la réunion une fois supprimée ///
@Test
public void checkIfRemovingUserIsWorking() {
    onView(ViewMatchers.withId(R.id.delete_item))
            .perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildView(R.id.delete_item)));
    onView(withId(R.id.delete_item)).check(new RecyclerViewUtils.ItemCount(currentUsersSize - 1));
}


/// Ajouter une réunion

    @Test
    public void addMeeting() {
        Meeting meeting = new Meeting(1, new Date(), new Date(), "First meeting", mApiMeetingService.getMeetingRoom().get(0), mApiMeetingService.getParticipants());
        mApiMeetingService.addMeeting(meeting);
        assertTrue(mApiMeetingService.getMeeting().contains(meeting));
        assertEquals(1, mApiMeetingService.getMeeting().size());
    }

    /// Test la liste de meeting ///

    @Test
    public void resetMeetingListWithSuccess() {
        //Add fake meetings to the list
        ApiMeetingService.getMeeting().addAll(FAKE_MEETING);
        //Meeting list size list should be 6
        assertEquals(6, ApiMeetingService.getMeeting().size());
        //Reset meeting list
        ApiMeetingService.resetMeeting();
        assertEquals(0, ApiMeetingService.getMeeting().size());

    }
    /// Test le filtre nom ///

    @Test
    public void filterByName() {
        mApiMeetingService.addMeeting(new Meeting(1, new Date(), new Date(), "Meeting n°1", mApiMeetingService.getMeetingRooms().get(0), mApiMeetingService.getParticipants()));
        mApiMeetingService.addMeeting(new Meeting(2, new Date(), new Date(), "Meeting n°2", mApiMeetingService.getMeetingRooms().get(0), mApiMeetingService.getParticipants()));

        List<MeetingRoom> meetingRooms = new ArrayList<>();
        meetingRooms.add(mApiService.getMeetingRooms().get(0));

        Meeting meeting_inList = mApiService.getMeetings().get(0);
        meeting_inList.setMeetingRoom(mApiService.getMeetingRooms().get(0));

        Meeting meeting_notInList = mApiService.getMeetings().get(1);
        meeting_notInList.setMeetingRoom(mApiService.getMeetingRooms().get(2));

        List<Meeting> meetings = mApiService.getMeetingsByMeetingRoom(meetingRooms);
        assertTrue(meetings.contains(meeting_inList));
        assertFalse(meetings.contains(meeting_notInList));
    }
}



    /// Test le filtre Heure ///

    @Test
    public void FilterByHour (){

    // from (time)
    onView(withId(R.id.from)).perform(click());
    onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
            .perform(PickerActions.setTime(
            from.get(Calendar.HOUR_OF_DAY),
                        from.get(Calendar.MINUTE)));
    onView(withText(android.R.string.ok)).perform(click());
    // to (time)
    onView(withId(R.id.to)).perform(click());
    onView(withClassName(Matchers.equalTo(TimePicker.class.getName())))
            .perform(PickerActions.setTime(
            to.get(Calendar.HOUR_OF_DAY),
                        to.get(Calendar.MINUTE)));
    onView(withText(android.R.string.ok)).perform(click());
}
}