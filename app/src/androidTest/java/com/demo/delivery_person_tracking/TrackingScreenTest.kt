package com.demo.delivery_person_tracking

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.demo.delivery_person_tracking.ui.TrackingScreen
import com.demo.delivery_person_tracking.ui.theme.Delivery_Person_TrackingTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TrackingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun trackingScreen_initialState_displaysTitleAndControls() {
        composeTestRule.setContent {
            Delivery_Person_TrackingTheme {
                TrackingScreen()
            }
        }

        // Verify Top Bar Title
        composeTestRule.onNodeWithText("Delivery Person Tracker")
            .assertIsDisplayed()

        // Verify Initial Tracking Status
        composeTestRule.onNodeWithText("Tracking Status")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("INACTIVE")
            .assertIsDisplayed()

        // Verify Live GPS Coordinates header
        composeTestRule.onNodeWithText("Live GPS Coordinates")
            .assertIsDisplayed()

        // Verify Action Buttons
        composeTestRule.onNodeWithText("Start Tracking")
            .assertIsDisplayed()
            .assertIsEnabled()

        composeTestRule.onNodeWithText("Stop Tracking")
            .assertIsDisplayed()
            .assertIsNotEnabled()

        // Verify Architecture Diagram Card
        composeTestRule.onNodeWithText("Tracking Data Architecture")
            .assertIsDisplayed()
    }
}
