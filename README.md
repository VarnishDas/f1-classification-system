# F1 Classification System

This is my final assignement for Programming Languages 1 course at TAMK. 
This Java-based project is a race management system for Formula 1. It includes functionalities to manage races, track driver standings and constructor standings.

## Quick guide to F1 points system
|**Positon**|**Points**|
| ------------- |:-------------:|
|1|25|
|2|18|
|3|15|
|4|12|
|5|10|
|6|8|
|7|6|
|8|4|
|9|2|
|10|1|

Additionally, if a driver classified 10th or above sets the fastest lap during the race, an additional point is awarded to the driver.

## Project Structure
### Files
- `App.java`: Main file to run the application.
- `Driver.java`: Class representing a driver participating in the races.
- `RaceManager.java`: Manages the race events, adding points to drivers and teams based on race outcomes.
- `Standings.java`: Displays driver and team standings.
- `Team.java`: Represents a team participating in the races.
- `Utilities.java`: Contains utility functions to handle file operations and setup.

## Usage
### Menu Options
1. **New Race**: Start a new race and input race results.
2. **View Driver's Standings**: Display standings of drivers.
3. **View Team's Standings**: Display standings of teams.
4. **Exit**: Terminate the application.

## Setup Options
### Custom Setup
- Create custom teams and drivers.

### Automatic Setup
- Generates a preset grid of teams and drivers according to this list:

|**Team Name (Abbreviation)**|**Drivers (Abbreviation)**|
|---------------------------|-----------------------------------|
|McLaren (MCL)|Lando Norris (NOR), Oscar Piastri (PIA)|
|Ferrari (FER)|Charles Leclerc (LEC), Carlos Sainz (SAI)|
|Red Bull (RBR)|Max Verstappen (VER), Sergio Perez (PER)|
|Mercedes (MER)|Lewis Hamilton (HAM), George Russell (RUS)|
|Alpine (ALP)|Pierre Gasly (GAS), Esteban Ocon (OCO)|
|AlphaTauri (ATR)|Yuki Tsunoda (TSU), Daniel Ricciardo (RIC)|
|Aston Martin (AMR)|Fernando Alonso(ALO), Lance Stroll (STR)|
|Alfa Romeo (ARO)|Valtteri Bottas (BOT), Guanyu Zhou (ZHO)|
|Williams (WIL)|Logan Sargeant (SAR), Alex Albon (ALB)|
|Haas (HAS)|Kevin Magnussen (MAG), Nico Hülkenberg (HUL)|
