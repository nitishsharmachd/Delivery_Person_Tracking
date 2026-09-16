package com.demo.delivery_person_tracking

import com.demo.delivery_person_tracking.data.LocationData
import com.demo.delivery_person_tracking.location.LocationClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLocationClient(
    private val locationsToEmit: List<LocationData> = emptyList(),
    private val shouldThrowError: Boolean = false
) : LocationClient {

    override fun getLocationUpdates(intervalMs: Long): Flow<LocationData> {
        return flow {
            if (shouldThrowError) {
                throw LocationClient.LocationException("GPS is disabled or permission missing")
            }
            for (location in locationsToEmit) {
                emit(location)
            }
        }
    }
}
