package com.demo.delivery_person_tracking

import com.demo.delivery_person_tracking.data.LocationData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.util.Calendar

class LocationDataTest {

    @Test
    fun locationData_creation_holdsCorrectValues() {
        val lat = 28.6139
        val lng = 77.2090
        val timestamp = System.currentTimeMillis()

        val locationData = LocationData(
            latitude = lat,
            longitude = lng,
            timestamp = timestamp
        )

        assertEquals(lat, locationData.latitude, 0.0001)
        assertEquals(lng, locationData.longitude, 0.0001)
        assertEquals(timestamp, locationData.timestamp)
    }

    @Test
    fun locationData_getFormattedTime_returnsNonEmptyFormattedString() {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 14)
            set(Calendar.MINUTE, 30)
            set(Calendar.SECOND, 15)
        }

        val locationData = LocationData(
            latitude = 12.9716,
            longitude = 77.5946,
            timestamp = calendar.timeInMillis
        )

        val formattedTime = locationData.getFormattedTime()

        assertNotNull(formattedTime)
        assertEquals("14:30:15", formattedTime)
    }
}
