# Public Transportation Project - Java Spring Boot

## 📦 Project Overview

This is a public transportation management system built using **Java Spring Boot**.  
It includes full support for bus lines, stations, drivers, travels, and administrative operations.

---

## 🗂️ Project Structure

The core entities of the system:

- **Travel**  
  Represents a single travel instance.  
  - `id` (PK)  
  - `bus_id` (FK)  
  - `driver_id` (FK)  
  - `line_id` (FK)  
  - `departure_time`  

- **Bus**  
  - `id` (PK)  
  - `license_plate`  
  - `seats`  

- **Driver**  
  - `id` (PK)  
  - `name`  
  - `phone`  
  - `rating`  

- **Line**  
  - `id` (PK)  
  - `number`  
  - `source`  
  - `destination`  

- **Station**  
  - `id` (PK)  
  - `name`  
  - `phone`  

- **Station_Line** (join table for many-to-many relationship between Statio**_**

