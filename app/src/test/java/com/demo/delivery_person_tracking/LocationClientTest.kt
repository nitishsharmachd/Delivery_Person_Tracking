package com.demo.delivery_person_tracking

import app.cash.turbine.test
import com.demo.delivery_person_tracking.data.LocationData
import com.demo.delivery_person_tracking.location.LocationClient
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class LocationClientTest {

    @Test
    fun fakeLocationClient_emitsLocationUpdatesSuccessfully() = runTest {
        val sampleLocations = listOf(
            LocationData(latitude = 28.6139, longitude = 77.2090, timestamp = 1000L),
            LocationData(latitude = 28.6140, longitude = 77.2091, timestamp = 2000L),
            LocationData(latitude = 28.6141, longitude = 77.2092, timestamp = 3000L)
        )

        val fakeClient = FakeLocationClient(locationsToEmit = sampleLocations)

        fakeClient.getLocationUpdates(5000L).test {
            val item1 = awaitItem()
            assertEquals(28.6139, item1.latitude, 0.0001)
            assertEquals(77.2090, item1.longitude, 0.0001)

            val item2 = awaitItem()
            assertEquals(28.6140, item2.latitude, 0.0001)

            val item3 = awaitItem()
            assertEquals(28.6141, item3.latitude, 0.0001)

            awaitComplete()
        }
    }

    @Test
    fun fakeLocationClient_throwsLocationException_whenGpsDisabled() = runTest {
        val fakeClient = FakeLocationClient(shouldThrowError = true)

        fakeClient.getLocationUpdates(5000L).test {
            val error = awaitError()
            assertEquals("GPS is disabled or permission missing", error.message)
        }
    }
}
