# ✈️ Flight Management System

A desktop GUI application built with **Java Swing** that allows users to manage flight reservations — book tickets, cancel bookings, and view reservation details.

---

## 📸 Output Screenshot

![Flight Management System UI](screenshots/main_ui.png)

> The main window showing the booking interface with all available actions.

---

## 🚀 Features

- **Book a Flight** — Enter a passenger name and get an auto-generated ticket number
- **Cancel a Booking** — Remove a reservation by ticket number
- **View All Reservations** — Display every active booking in the output panel
- **View Specific Reservation** — Look up a single booking by ticket number
- **Clear Display** — Reset the output area

---

## 🛠️ Tools & Technologies

| Tool / Technology | Purpose |
|---|---|
| **Java** (JDK 8+) | Core programming language |
| **Java Swing** | GUI framework for building the desktop UI |
| **AWT (Abstract Window Toolkit)** | Layout managers, colors, fonts, and event handling |
| **HashMap** | In-memory data structure to store reservations |
| **JOptionPane** | Dialog boxes for user input and confirmations |
| **JScrollPane / JTextArea** | Scrollable output display area |
| **IntelliJ IDEA / VS Code** | IDE for development |
| **Git & GitHub** | Version control and source hosting |

---

## 📁 Project Structure

```
FlightManagementSystem/
├── FlightManagementSystem.java   # Main source file
├── FlightManagementSystem.class  # Compiled bytecode
├── screenshots/
│   └── main_ui.png               # Application screenshot
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Java added to your system PATH

### Compile & Run

```bash
# Compile
javac FlightManagementSystem.java

# Run
java FlightManagementSystem
```

---

## 🎨 UI Design

- Header: Dark Slate Blue (`#483D8B`)
- Background: Lavender (`#E6E6FA`)
- Buttons: Light Sky Blue (`#87CEEB`)
- Display area: White with a Dark Slate Blue border
- Font: SansSerif (header), Arial Bold (buttons), Monospaced (output)

---

## 📌 Usage

1. Launch the application using the run commands above
2. Click **Book Flight** → enter a passenger name → a ticket number is assigned automatically
3. Click **Cancel Booking** → enter the ticket number to remove the reservation
4. Click **View All Reservations** → see all current bookings in the display area
5. Click **View Specific Reservation** → look up one booking by ticket number
6. Click **Clear Display** → wipe the output panel

---

## ⚠️ Limitations

- Reservations are stored in memory only — data is lost when the application closes
- No persistence layer (database or file storage) yet
- Ticket numbers reset on each run

---

## 👨‍💻 Author

Built as a Java Swing GUI project demonstrating basic CRUD operations with an interactive desktop interface.
