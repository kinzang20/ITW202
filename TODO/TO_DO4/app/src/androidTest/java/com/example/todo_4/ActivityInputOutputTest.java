package com.example.todo_4;

import android.content.Context;

import androidx.annotation.ContentView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    public static final String message = "This is the test";
    public static final String reply = "This is the reply";
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.todo_4", appContext.getPackageName());
    }
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void activityLaunch(){
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.textView3)).check(matches(isDisplayed()));
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));

    }
    @Test
    public void textInputOutput(){
        onView(withId(R.id.send)).perform(typeText(message),closeSoftKeyboard());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.reply)).perform(typeText(message),closeSoftKeyboard());
        onView(withId(R.id.btn2)).perform(click());
    }
}