package com.example.bmiapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BmiFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void calculateBmi_displaysCorrectStatus() {
        onView(withId(R.id.weightInput)).perform(typeText("35"), closeSoftKeyboard());

        onView(withId(R.id.haightInput)).perform(typeText("1.75"), closeSoftKeyboard());

        onView(withId(R.id.calculateButton)).perform(click());

        onView(withId(R.id.bmiStatus)).check(matches(withText("NIEDOWAGA")));
    }
}