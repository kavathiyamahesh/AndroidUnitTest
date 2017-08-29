package xeksy.android.unittesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Tulsi Kavathiya on 8/29/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangWork() {
        onView(withId(R.id.inputField))
                .perform(typeText("Mahesh"), closeSoftKeyboard());
        onView(withId(R.id.changeText))
                .perform(click());
        onView(withId(R.id.inputField))
                .check(matches(withText("Lalala")));
    }

    @Test
    public void changeNewActivity() {
        onView(withId(R.id.inputField))
                .perform(typeText("NewText"));
        onView(withId(R.id.switchActivity)).perform(click());
        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
    }

}
