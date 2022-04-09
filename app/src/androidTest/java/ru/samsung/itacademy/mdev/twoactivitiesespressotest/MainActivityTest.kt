package ru.samsung.itacademy.mdev.twoactivitiesespressotest

import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import androidx.test.runner.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun isVisible(){
        onView(withId(R.id.button_main)).check(matches(isDisplayed()))
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.text_message_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.editText_main)).check(matches(isDisplayed()))
    }
    @Test
    fun openSecondActivity(){
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_header)).check(matches(isDisplayed()))
        onView(withId(R.id.text_message)).check(matches(isDisplayed()))
        onView(withId(R.id.button_second)).check(matches(isDisplayed()))
        onView(withId(R.id.editText_second)).check(matches(isDisplayed()))
    }
    private val text = "text_from_main"
    @Test
    fun accordanceText(){
        onView(withId(R.id.editText_main)).perform(ViewActions.typeText(text))
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText("text_from_main")))
    }
}