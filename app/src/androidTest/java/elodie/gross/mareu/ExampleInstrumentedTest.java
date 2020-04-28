package elodie.gross.mareu;

import android.content.Context;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/***public class MainActivityTest {

    private static int ITEMS_COUNT = 12;

    private MainActivity mActivity;
    private ApiMeetingService mApiService;
    private List<Meeting> mNeighbours;


    @Test
    void givenValidEmailAddresses_whenInstatiateMeeting_thenGetValidParticipants() {
        List<String> participants = Arrays.asList(
                "participant@test.fr");
    }
}

   /*** @Test
    public void checkAddButton(){
        onView(allOf(ViewMatchers.withId(R.id.fab), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));

        onView(ViewMatchers.withId(R.id.btn_valider)).perform(click()).check(matches(isEnabled()));
} ***/