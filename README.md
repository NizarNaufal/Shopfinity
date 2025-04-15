# 🛍️ Shopfinity Android App

Shopfinity is a modern e-commerce Android application developed with clean architecture and modularization in mind. Built using Kotlin and Jetpack Compose, this app is designed for scalability, maintainability, and high performance.

---

## 🚀 Tech Stack

- **Kotlin** – Modern, concise, and safe programming language for Android development.
- **Coroutines** – Asynchronous programming for smooth, non-blocking operations.
- **Jetpack Compose** – Declarative UI toolkit for native Android interfaces.
- **Room** – SQLite abstraction layer for local persistence.
- **Proto DataStore** – Typed and efficient data storage solution, replacing SharedPreferences.
- **Coil** – Fast, lightweight image loading for Android.
- **Custom Build Logic** – Convention-based Gradle plugins for simplified project setup.

---

## 🧱 Project Structure

- `app/`  
  Entry point of the application. Contains the main activity, navigation host, and Compose setup. Also includes the `AndroidManifest.xml`.

    - `src/main/java/id/devnzr/shopfinity/`
        - `splash/` - Splash screen feature
        - `App.kt` - Application class
        - `MainActivity.kt` - Main launcher activity

- `core/`  
  Shared modules across features. Contains business logic, data sources, and utility layers.

    - `data/` - Repository implementations and interfaces
    - `datastore/` - Proto DataStore configuration and usage
    - `domain/` - UseCases and domain models
    - `extension/` - Kotlin extension functions
    - `network/` - API configuration, service interfaces
    - `ui-kit/` - Theme, Colors, Typography

- `feature/`  
  Modularized features for better separation of concerns.

    - `account/` - Account management UI and logic
    - `home/` - Home screen display
    - `login/` - Authentication and sign-in feature
    - `detail/` - detail product screens
    - `carts/` - Cart screen with Room DB

- `build-logic/`  
  Contains custom Gradle convention plugins to standardize module configurations (e.g., Compose setup, Kotlin config, testing setup).

- `build.gradle.kts`, `settings.gradle.kts`  
  Root-level Gradle configuration files.

---

## 📦 Module Overview

Each module is designed to be loosely coupled and independently testable. The project applies clean architecture principles with the following layers:

- **App Layer** – Handles navigation and root Compose scaffolding.
- **Core Layer** – Contains reusable and shared code like networking, data handling, and extensions.
- **Feature Layer** – Self-contained features for modular UI and logic.
- **Build Logic** – Convention plugins that reduce duplication and keep Gradle setup clean.

---


## 📸 **Screenshots**



https://github.com/user-attachments/assets/ae5dfb5e-8dec-4fd7-ad69-2b48a740f5ae



https://github.com/user-attachments/assets/3c19177a-aee0-429b-b173-384618dcd10b



https://github.com/user-attachments/assets/b1c5e82e-0814-4175-9acf-94448c5d2ffa



https://github.com/user-attachments/assets/e434b69a-7c40-4913-89b9-f558b9b8f41d



https://github.com/user-attachments/assets/8b104b26-016b-4d46-a796-d3d2668b37ef

                                    |


1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/shopfinity.git
   cd shopfinity
