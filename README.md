# Delivery Person Tracking Android App

A modern Android application designed for real-time delivery driver location tracking. The app utilizes Google Play Services Location API, an Android Foreground Service with continuous notification updates, Google Maps route polylines, and Jetpack Compose.

---

## 🚀 Features

- **High-Accuracy GPS Tracking**: Streams real-time latitude & longitude using `FusedLocationProviderClient` with `PRIORITY_HIGH_ACCURACY` every 5 seconds.
- **Foreground Location Service**: Runs a resilient foreground service (`LocationTrackingService`) displaying live coordinates and update timestamps directly in the system notification bar.
- **Interactive Google Maps Route**: Displays a live marker at the current location and draws a continuous **Polyline** route history on Google Maps.
- **Automatic GPS Enable Prompt**: Detects if device location/GPS services are turned off and prompts the user with an automatic system resolution popup (`ResolvableApiException`).
- **Modern Permissions Handling**: Supports Android 13+ runtime permissions (`POST_NOTIFICATIONS`) and Android 14+ foreground service location types (`FOREGROUND_SERVICE_LOCATION`).
- **Clean Architecture**: Built with Kotlin Coroutines, `Flow`, `StateFlow`, and Jetpack Compose Material 3.
- **Testing Suite**: Includes unit tests with `Turbine` flow testing and Android Compose UI instrumentation tests.

---

## 📐 Architecture & Data Flow

```text
Driver Android App (GPS)
  │
  ▼ [LocationCallback every 5 seconds]
FusedLocationProviderClient
  │
  ▼
LocationTrackingService (Foreground Service)
  │
  ├──► Live Notification Bar Update (Lat, Long, Timestamp)
  ├──► Google Maps Live Polyline Route & Marker
  └──► Backend API Stream (Conceptual Payload)
```

---

## 📁 Project Structure

```text
app/src/main/java/com/demo/delivery_person_tracking/
├── data/
│   └── LocationData.kt                # Data class (latitude, longitude, timestamp)
├── location/
│   ├── LocationClient.kt              # Interface for location streaming
│   ├── DefaultLocationClient.kt       # FusedLocationProviderClient implementation
│   └── LocationTrackingService.kt     # Foreground Service & notification manager
├── ui/
│   └── TrackingScreen.kt              # Jetpack Compose UI & Google Maps view
└── MainActivity.kt                    # Main Activity entry point
```

---

## 🛠️ Setup Instructions

### 1. Google Maps API Key Setup
To keep API keys secure and out of version control:

1. Open `local.properties` in the root directory.
2. Add your Google Maps API Key:
   ```properties
   MAPS_API_KEY=YOUR_GOOGLE_MAPS_API_KEY_HERE
   ```
3. The build system will automatically inject this key into `AndroidManifest.xml` via `manifestPlaceholders`.

---

## 🧪 Running Tests

### Unit Tests
Executes local unit tests on JVM using JUnit 4 and Turbine:
```bash
./gradlew testDebugUnitTest
```

### Instrumentation / UI Tests
Executes Compose UI tests on a connected device or emulator:
```bash
./gradlew connectedAndroidTest
```

---

## 🧰 Tech Stack & Libraries

- **Language**: Kotlin 2.2
- **UI Framework**: Jetpack Compose (Material 3)
- **Location Services**: Google Play Services Location (`21.4.0`)
- **Maps**: Google Maps Compose (`6.5.0`) & Play Services Maps (`20.0.0`)
- **Asynchronous Flow**: Kotlin Coroutines & `StateFlow`
- **Testing**: JUnit 4, `kotlinx-coroutines-test`, `app.cash.turbine`, Compose UI Test
