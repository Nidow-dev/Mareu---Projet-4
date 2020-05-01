package elodie.gross.mareu;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TimePicker;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.List;

import elodie.gross.mareu.model.Meeting;
import elodie.gross.mareu.service.ApiMeetingService;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddMeetingInstrumentedTest {

    private static int ITEMS_COUNT = 6;

    private MainActivity mActivity;
    private ApiMeetingService mApiMeetingService;
    private List<Meeting> mMeeting;




/// Ajouter une réunion avec le Floating Button ///



        @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

        @Test
        public void testAjoutReunion() {
            ViewInteraction floatingActionButton = onView(
                    allOf(withId(R.id.fab),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            floatingActionButton.perform(click());

            ViewInteraction floatingActionButton2 = onView(
                    allOf(withId(R.id.fab),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    2),
                            isDisplayed()));
            floatingActionButton2.perform(click());

            ViewInteraction appCompatEditText = onView(
                    allOf(withId(R.id.mareu_type_name),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    2)));
            appCompatEditText.perform(scrollTo(), replaceText("Hebdomadaire"), closeSoftKeyboard());

            ViewInteraction appCompatButton = onView(
                    allOf(withId(R.id.btn_date), withText("DATE"),
                            childAtPosition(
                                    allOf(withId(R.id.date_et_heure),
                                            childAtPosition(
                                                    withClassName(is("android.widget.LinearLayout")),
                                                    3)),
                                    2)));
            appCompatButton.perform(scrollTo(), click());

            ViewInteraction appCompatButton2 = onView(
                    allOf(withId(android.R.id.button1), withText("OK"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    3)));
            appCompatButton2.perform(scrollTo(), click());

            ViewInteraction appCompatButton3 = onView(
                    allOf(withId(R.id.btn_time), withText("HEURE"),
                            childAtPosition(
                                    allOf(withId(R.id.date_et_heure),
                                            childAtPosition(
                                                    withClassName(is("android.widget.LinearLayout")),
                                                    3)),
                                    4)));
            appCompatButton3.perform(scrollTo(), click());

            ViewInteraction appCompatButton4 = onView(
                    allOf(withId(android.R.id.button1), withText("OK"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    3)));
            appCompatButton4.perform(scrollTo(), click());

            ViewInteraction appCompatEditText2 = onView(
                    allOf(withId(R.id.emails),
                            childAtPosition(
                                    allOf(withId(R.id.salle_choice),
                                            childAtPosition(
                                                    withClassName(is("android.widget.LinearLayout")),
                                                    4)),
                                    1)));
            appCompatEditText2.perform(scrollTo(), replaceText("ines@mareu.com"), closeSoftKeyboard());

            ViewInteraction appCompatSpinner = onView(
                    allOf(withId(R.id.spinner_salles),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    6)));
            appCompatSpinner.perform(scrollTo(), click());

            DataInteraction appCompatCheckedTextView = onData(anything())
                    .inAdapterView(childAtPosition(
                            withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                            0))
                    .atPosition(5);
            appCompatCheckedTextView.perform(click());

            ViewInteraction appCompatButton5 = onView(
                    allOf(withId(R.id.btn_valider), withText("VALIDER"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            7),
                                    0)));
            appCompatButton5.perform(scrollTo(), click());

            ViewInteraction appCompatImageButton = onView(
                    allOf(withContentDescription("Navigate up"),
                            childAtPosition(
                                    allOf(withId(R.id.action_bar),
                                            childAtPosition(
                                                    withId(R.id.action_bar_container),
                                                    0)),
                                    1),
                            isDisplayed()));
            appCompatImageButton.perform(click());
        }


/// Supprimer une réunion ///

    @Test
    public void deleteReunion() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.delete_item), withContentDescription("Effacer la réunion"),
                        childAtPosition(
                                allOf(withId(R.id.items_layout),
                                        childAtPosition(
                                                withId(R.id.recyclerView),
                                                5)),
                                6),
                        isDisplayed()));
        appCompatImageButton.perform(click());
    }

      /***  // Given : We remove the element at position 2
        onView(withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.recyclerView)).perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT-1));
    }***/
/// Test la liste de meeting ///

 @Test
 public void myNeighboursList_shouldNotBeEmpty() {
     // First scroll to the position that needs to be matched and click on it.
     onView(ViewMatchers.withId(R.id.recyclerView))
             .check(matches(hasMinimumChildCount(1)));
 }
/// Test le filtre nom ///

 @Test
 public void filtreNom() {
     ViewInteraction overflowMenuButton = onView(
             allOf(withContentDescription("More options"),
                     childAtPosition(
                             childAtPosition(
                                     withId(R.id.toolbar),
                                     1),
                             0),
                     isDisplayed()));
     overflowMenuButton.perform(click());

     ViewInteraction appCompatTextView = onView(
             allOf(withId(R.id.title), withText("Par Salle"),
                     childAtPosition(
                             childAtPosition(
                                     withId(R.id.content),
                                     0),
                             0),
                     isDisplayed()));
     appCompatTextView.perform(click());

     ViewInteraction searchAutoComplete = onView(
             allOf(withId(R.id.search_src_text),
                     childAtPosition(
                             allOf(withId(R.id.search_plate),
                                     childAtPosition(
                                             withId(R.id.search_edit_frame),
                                             1)),
                             0),
                     isDisplayed()));
     searchAutoComplete.perform(replaceText("peach"), closeSoftKeyboard());
 }

/// Test le filtre Date ///

 @Test
 public void testFiltreDate() {
     ViewInteraction overflowMenuButton = onView(
             allOf(withContentDescription("More options"),
                     childAtPosition(
                             childAtPosition(
                                     withId(R.id.toolbar),
                                     1),
                             0),
                     isDisplayed()));
     overflowMenuButton.perform(click());

     ViewInteraction appCompatTextView = onView(
             allOf(withId(R.id.title), withText("Par date"),
                     childAtPosition(
                             childAtPosition(
                                     withId(R.id.content),
                                     0),
                             0),
                     isDisplayed()));
     appCompatTextView.perform(click());

     ViewInteraction appCompatButton = onView(
             allOf(withId(android.R.id.button1), withText("OK"),
                     childAtPosition(
                             childAtPosition(
                                     withClassName(is("android.widget.ScrollView")),
                                     0),
                             3)));
     appCompatButton.perform(scrollTo(), click());
 }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


}

