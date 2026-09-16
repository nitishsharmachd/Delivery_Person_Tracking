package com.demo.delivery_person_tracking.location

import com.demo.delivery_person_tracking.data.LocationData
import kotlinx.coroutines.flow.Flow

interface LocationClient {
    fun getLocationUpdates(intervalMs: Long): Flow<LocationData>

    class LocationException(message: String) : Exception(message)
}
