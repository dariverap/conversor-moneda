# 💱 Conversor de Monedas (Currency Converter)

Welcome to the **Conversor de Monedas** project. This is a robust desktop application built to perform precise currency exchange calculations. Developed with a focus on clean architecture and type safety, it demonstrates the power of **Java 17** combined with the modern **JavaFX** UI toolkit.

## 🚀 Business Overview

In an increasingly globalized economy, quick access to exchange rates is essential. This application provides a streamlined interface for users to convert values between major global currencies (USD, EUR, GBP, JPY, KRW, PEN).

**Key Features:**
*   **Precision:** Uses `BigDecimal` for financial calculations to avoid floating-point errors.
*   **User Experience:** Clean, minimalist interface using FXML.
*   **Flexibility:** easily extensible architecture to add more currencies or connect to live APIs.

---

## 🛠️ Tech Stack

This project leverages a modern Java ecosystem ensuring maintainability and performance:

*   **Language:** Java 17 (LTS)
*   **GUI Framework:** JavaFX 17.0.2 (Controls & FXML)
*   **Build Tool:** Maven 3.8+ (via Maven Wrapper)
*   **Testing:** JUnit 5 (Jupiter)
*   **Architecture:** MVC (Model-View-Controller)

---

## 🏛️ Architecture & Core Modules

The application follows the **Model-View-Controller (MVC)** design pattern, strictly separating business logic from the user interface. Here are the three main pillars of the codebase:

### 1. The Domain Model (`Moneda.java`)
This module represents the core business entity. It encapsulates the properties of a currency (Country Name, ISO Code, and Exchange Rate).
*   **Responsibility:** Data holding and state management for individual currencies.
*   **Design:** Utilizes `BigDecimal` for the `tipoCambio` (exchange rate) to ensure financial accuracy during mathematical operations.

### 2. The Controller (`ConversorController.java`)
This is the "brain" of the application. It orchestrates the interaction between the view and the model.
*   **Responsibility:**
    *   Initializes the list of available currencies (USD, EUR, GBP, etc.).
    *   Captures user events (button clicks).
    *   Performs the conversion algorithm: `(TargetRate / SourceRate) * Amount`.
*   **Highlights:** Implements `RoundingMode.HALF_UP` to handle currency rounding standardly.

### 3. The View Layer (`conversor-view.fxml` & `AppConversor.java`)
This module handles the presentation and application lifecycle.
*   **AppConversor.java:** The entry point extending `javafx.application.Application`. It loads the FXML loader and sets up the primary Stage.
*   **conversor-view.fxml:** A declarative XML file defining the layout (VBox, ComboBoxes, TextFields). This allows designers to modify the UI without touching Java code.

---

## ⚡ Installation & Setup

You can run this project immediately without installing Maven globally, thanks to the included **Maven Wrapper**.

### Prerequisites
*   **Java JDK 17** or higher installed.

### Steps

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/dariverap-conversor-moneda.git
    cd dariverap-conversor-moneda
    ```

2.  **Build and Run (Windows):**
    ```cmd
    ./mvnw.cmd clean javafx:run
    ```

3.  **Build and Run (Linux/macOS):**
    ```bash
    chmod +x mvnw
    ./mvnw clean javafx:run
    ```

### Troubleshooting
If you encounter `module-info` errors, ensure your IDE (IntelliJ/Eclipse) is configured to use SDK 17 and that Maven properly reloads the project context.

---

_Authored by [Diego Rivera] - 2023_
