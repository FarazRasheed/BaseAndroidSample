# BaseAndroidSample
This is Sample Project for Base Architecture.

## Modules:
* app - Main app module or parent module to run the application for next route
* region - Its a multi-region application with code bases.
* core - Base classes
* Networking  - Network related code

## 🏗 Tech Stack
### Architecture
* 100% Kotlin based, including Gradle files
* MVVM  Multi-Module Architecture
* Repository Pattern
* Dagger-Hilt - for dependency injection.
* Kotlin-DSL - Used to handle gradle dependencies and config versions
* JetPack
  - LiveData - For reactive style programming (from VM to UI).
  - Lifecycle - Used get lifecyle event of an activity or fragment and performs some action in response to change
  - ViewModel - Stores UI-related data that isn't destroyed on UI changes.
  - Room - Used to create room db and store the data.
  - Navigation - Used to navigate between fragments
  - Data Binding - Used to bind UI components in your XML layouts.
* Material-Components - Material design components like ripple animation, cardView.
* Retrofit - Used for REST api communication.
* OkHttp - HTTP client that's efficient by default: HTTP/2 support allows all requests to the same host to share a socket
* Moshi - Used to convert Java Objects into their JSON representation and vice versa.
* Timber - Used for logging.
* Glide - Glide is a fast and efficient image loading library for Android




