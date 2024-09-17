# ECE-373-Project
We are working on a weather GUI. It will pull information from weather station APIs and output weather data (from a specific input date + time) for a user to see.

## Team Members:
### Ryan Fong, Jacob Missbrenner, Aayush Patel, Jimmy Payan, Ahmad Qureshi

Specific weather station API (tenative): https://www.weather.gov/documentation/services-web-api

## List of classes used in this project

### Login
1.  User: Generic User class - this base class is assigned to everyone running the program by default
2.  Admin: Subclass of User w/ additional perms
3.  LoginGUI: Allows users to be assigned admin/maintenance class if they enter username + password
4.  Login: Checks if entered credentials are in CredentialDatabase and modifies "user" accordingly
5.  CredentialDatabase: Holds all valid username + password combinations

### Main Menu
6.  MainMenuGUI: Takes user to different actions: UserSettingsGUI, DateGUI, LoginGUI, ExitGUI
7.  MainMenu: Carries out actions as specified by MainMenuGUI inputs
8.  DateGUI: Allows user to change desired date and time for weather data
9.  Date: Provides "desired date" value to WeatherAPIPuller (default to current date + time)
10. ExitGUI: Allows user to end the program

### User Settings
11. UserSettingsGUI: Allows user to change settings
12. UserSettings: Changes settings as desired from user (C to F, Color of Dialog Boxes)
13. ColorSettingsGUI: Allows user to change color of dialog boxes
14. ColorSetings: Changes color of dialog boxes depending on user settings (defaults to... default color)
15. MapScale: Custom radius for weather pulling. Max of 100 miles, changeable in UserSettings.

### Weather Data
16. WeatherDisplayGUI: Displays forecast based on info stored in WeatherData, depending on UserLocation + UserSettings + MapScale
17. WeatherAPIPuller: Pulls data from website and stores into "WeatherData" class
18. WeatherData: Object created by "WeatherAPIPuller" which stores... WeatherData
19. TemperatureConverter: Convert F to C or C to F depending on user settings
20. WeatherSettingsGUI: Accessible from WeatherDisplayGUI, allows user to access MainMenuGUI, DateGUI, ExitGUI

### Additional Functionality
21. UserLocationGUI: "Allow this device to access your location?" || "Enter your location"
22. UserLocation: Pulls location from device or UserLocationGUI
23. SaveDataGUI: Allows user to save snapshot of weather data to their PC
24. SaveData: Saves snapshot of weather data to user PC
25. Exit: Ends the program

***********************************************************************************************************










