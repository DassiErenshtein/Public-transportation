# 🚍 Public Transport Management System – Java Spring Boot

A backend project for managing a public transport system, built with Java and Spring Boot.

---

## 🗂️ Data Model Overview

- **Travel**: `id`, `bus_id`, `driver_id`, `line_id`, `departure_time`
- **Bus**: `id`, `license_plate`, `seats`
- **Driver**: `id`, `name`, `phone`
- **Line**: `id`, `number`, `source`, `destination`
- **Station**: `id`, `name`
- **Station_Line**: `line_id`, `station_id`, `station_order`  
  _(Join table to manage the many-to-many relationship between lines and stations)_

---

## 🔧 Main Features

- Admin functions:
  - Add travel
  - Add/remove station from a line and update station order
- "Smart Line" functions:
  - Search by station (next 5 relevant travels to this station)
  - Search by line:
    - Show current bus positions along the route
    - Show all stations on the line
  - Saved and recent searches
  - Timetable view:
    - All travels / travels by hour / last travel of the day

> 🕒 Assumptions:
> - Travel time between stations is 1 minute  
> - The list of travels is the same every day

---

## ⚙️ Installation & Run Instructions

### 📋 Prerequisites

- Java JDK 17+
- Maven
- IDE (e.g., IntelliJ IDEA / Eclipse / VSCode)
- Git (if cloning from remote)

---

### 📦 Clone the Project (if applicable)

```bash
git clone https://your-repo-url.git
cd your-project-folder
