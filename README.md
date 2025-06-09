# Public Transportation Project - Java Spring Boot

## 📦 Project Overview

This is a public transportation management system built using **Java Spring Boot**.  
It includes full support for bus lines, stations, drivers, travels, and administrative operations.

---

## 🛠️ Admin Features

1. **Create New Travel**  
   Add a travel with selected line, bus, driver, and departure time.

2. **Add/Remove Station from Line**  
   Dynamically update the list of stations for a line, including auto-updating the `station_order`.

---

## 🚏 Passenger-Oriented Features ("קל קו")

### 1. 🔎 Search by Station

**Parameters:**  
- Station ID  
- (Optional) Line Number

**Behavior:**  
- Returns list of travels going through this station.  
- If line number is provided, filters only travels of that line.  
- Filters travels where:  
  `travel_time - current_time >= station_order`  
- Sorts by time and returns the **next 5 travels**.

### 2. 🔎 Search by Line

Two functions:

- **Get All Stations of a Line**  
  Input: Line number → Output: List of stations in correct order.

- **Get Current Bus Positions for a Line**  
  Input: Line number → Output: For each travel of that line, shows expected current location (based on time and station order).

### 3. 🧠 Saved Searches  
  Support for quick access to user's saved searches.

### 4. ⏮️ Last Search  
  Re-perform the most recent user query.

### 5. 📅 Schedules

Three schedule views:
- All travels of the day  
- Travels at a specific time  
- Last travel of the day  

---

## 🚀 Getting Started

1. Clone the project:
   ```bash
   git clone https://your-repo-url
   cd public-transportation
