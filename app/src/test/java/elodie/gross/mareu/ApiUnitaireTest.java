package elodie.gross.mareu;

import android.widget.DatePicker;
import android.widget.TimePicker;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.di.DI;
import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;

import static elodie.gross.mareu.service.DummyMeetingGenerator.FAKE_MEETING;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
public class ApiUnitaireTest {

    private ApiMeetingService service;


    private MaingActivityRule mActivity;
    private ApiMeetingService mApiService;
    private List<Meeting> mMeetings;

    @Rule
    public MaintActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setUp() {

        service = (ApiMeetingService) DI.getNewInstanceApiMeeting();
        MainActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mApiService = DI.getNewInstanceApiService();
        mNeighbours = mApiService.getNeighbours();
    }

    @Test
    public void addMeetingWithSuccess() {

    }

    @Test
    public void getMeetingWithSuccess() {
        List<Meeting> meetings = service.getMeeting();
        List<Meeting> expectedMeeting = FAKE_MEETING;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeeting.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Meeting meetingToDelete = service.getMeeting().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));
    }

    // date
    @Test
    public void check_filtre_date() {
        onView(ViewMatchers.withId(R.id.list))
                .check(itemCountAssertion(ITEMS_COUNT));

        onView(ViewMatchers.withId(R.id.filter))
                .perform(click());

        onView(withId(R.id.filtre_date))
                .perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(
                        TOMORROW.get(Calendar.YEAR),
                        TOMORROW.get(Calendar.MONTH) + 1,
                        TOMORROW.get(Calendar.DAY_OF_MONTH)));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(android.R.id.button1)).perform(click());

        onView(ViewMatchers.withId(R.id.list))
                .check(itemCountAssertion(TOMORROW_MEETINGS_COUNT));
    }

}