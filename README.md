# Car Rental Management System

Welcome to the **Car Rental Management System** – a streamlined solution for managing car rentals, customers, bookings, and billing. This system is designed to improve the operational efficiency of rental companies, enhance customer experience, and facilitate smooth financial transactions.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Team](#team)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [GitHub Repository](#github-repository)
- [License](#license)

## Overview

The **Car Rental Management System** aims for simplicity, usability, and efficiency. Supporting the full rental lifecycle, this system provides fleet management, customer records, bookings, billing, and discount features. With an intuitive terminal-based interface, it enables smooth data handling and productivity in rental operations.

## Team

### Developers

- **Abylay**: Lead Developer and Architect. Designed the core structure and implemented the `Car` and `Booking` functionalities.
- **Azan**: Customer Management Specialist. Developed all customer-related classes, including VIP and Regular customer types.
- **Ramazan**: Booking System Expert. Built the booking management system, handling booking states and approvals.
- **Daniil**: Billing and Discounts Specialist. Created billing calculations, the `DiscountInterpreter`, and a flexible discount system.

## Installation

To set up and run this project locally, follow these instructions:

### Prerequisites

- **Java Development Kit (JDK)**
- **Git**

### Setup

**How to run**
   ```bash
   git clone https://github.com/username/car-rental-system.git
   cd car-rental-system
   java -cp out Main

## Project Structure

```plaintext
car-rental-system/
│
├── src/
│   ├── car/                  # Car management classes
│   ├── customer/             # Customer-related classes
│   ├── booking/              # Booking management classes
│   ├── billing/              # Billing and discount classes
│   └── Main.java             # Main class to run the project
│
├── README.md                 # Project documentation


# Project Features

1. **Add a New Car**
   - Allows the user to input details and add a new car to the system.

2. **Add a New Customer**
   - Enables adding a new customer profile with all relevant information.

3. **Create a Booking**
   - Facilitates creating a new booking for a customer, including selecting the desired car and rental period.

4. **Add Sports Package to a Car**
   - Allows users to enhance a car's features by adding a sports package.

5. **Move Booking to Next State**
   - Advances a booking through its lifecycle, moving it to the next state (e.g., from pending to approved).

6. **Approve a Booking**
   - Enables the admin to approve a booking, making it ready for rental.

7. **Calculate Total Price with Discounts**
   - Calculates the total rental price, applying any applicable discounts.

8. **View All Cars**
   - Provides a list view of all cars currently available in the system.

9. **View All Customers**
   - Displays all registered customers and their details.

10. **View All Bookings**
    - Shows a list of all bookings, including status and relevant booking information.

11. **Simulate Discount Calculation**
    - Allows for testing discount applications, providing an estimated rental cost with discounts.

12. **Show Summary of All Data**
    - Summarizes all data in the system, including cars, customers, and bookings.

13. **Return to Start-Up Menu**
    - Brings the user back to the main menu for easy navigation.

# Wishing You a Great Experience!

We hope our project makes your work more convenient and efficient. Enjoy managing your car rentals, and best of luck!



