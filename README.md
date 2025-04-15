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

- `feature/`  
  Modularized features for better separation of concerns.

    - `account/` - Account management UI and logic
    - `home/` - Home screen display
    - `login/` - Authentication and sign-in feature
    - `product/` - Product list and detail screens

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

| Home Screen                           | Cart Page                            |
|----------------------------------------|-----------------------------------------|
| 

![Home]https://github.com/user-attachments/assets/39e1463d-1674-4ee0-80d6-4d1d02c7bbc8) | ![Cart](https://github.com/user-attachments/assets/a9d2ba93-dc8f-4a24-ab14-d86538c7dd4c) |

| Login Page                            | Profile Page               |
|----------------------------------------|-----------------------------------------|
| ![Login](https://github.com/user-attachments/assets/7d1dc6bb-a404-4e1c-a851-1337fd47bf80) | ![Profile](https://github.com/user-attachments/assets/56932594-66b2-49ce-9f3c-82f745c0dcc3) |

| Detail Page
|---------------------------------------------------------------------------------|
| ![Detail](https://github.com/user-attachments/assets/7ebd814a-2334-4fa8-afdc-cdcfe3063d93)



1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/shopfinity.git
   cd shopfinity
