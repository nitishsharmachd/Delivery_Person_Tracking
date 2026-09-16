package com.demo.delivery_person_tracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demo.delivery_person_tracking.ui.TrackingScreen
import com.demo.delivery_person_tracking.ui.theme.Delivery_Person_TrackingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Delivery_Person_TrackingTheme {
                TrackingScreen()
            }
        }
    }
}
