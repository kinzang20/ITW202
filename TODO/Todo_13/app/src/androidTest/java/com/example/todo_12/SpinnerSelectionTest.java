package com.example.todo_12;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest {

  /*  @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(OrderActivity.class);*/

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.todo_12", appContext.getPackageName());
    }

    /*@Test
    public void iterateSpinnerItems(){
        String[] myArray = mActivityRule.getActivity().getResources()
                .getStringArray(R.array.label_array);

        int size = myArray.length;
        for (int i = 0; i < size; i++){
            onView(withId(R.id.spinner)).perform(click());
            onData(is(myArray[i])).perform(click());
            onView(withId(R.id.phone)).check(matches(withText(containsString(myArray[i]))));
        }
    }*/
}