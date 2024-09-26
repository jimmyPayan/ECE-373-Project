# ECE-373-Project
We are working on a weather GUI. It will pull information from weather station APIs and output weather data (from a specific input date + time) for a user to see.

## Team Members:
### Ryan Fong, Jacob Missbrenner, Aayush Patel, Jimmy Payan, Ahmad Qureshi

Specific weather station API (tenative): https://www.weather.gov/documentation/services-web-api

## List of classes used in this project

### Login
1.  User: Generic User class - this base class is assigned to everyone running the program by default
2.  Admin: Subclass of User with additional permissions
3.  LoginGUI: Allows users to be assigned admin/maintenance class if they enter username + password. Login first, then go to MainMenuGUI
4.  Login: Carries out actions as specified by LoginGUI inputs
5.  CredentialDatabase: Holds all valid username + password combinations
6.  PasswordEncrypter: Takes the plain text and scrambles it for safe storage
7.  PasswordDecrypter: Decrypts the Password for usage later

### Main Menu
8.  MainMenuGUI: Takes user to different actions: UserSettingsGUI, DateGUI, LoginGUI, ExitGUI
9.  MainMenu: Carries out actions as specified by MainMenuGUI inputs
10.  DateGUI: Allows user to change desired date and time for weather data
11.  Date: Provides "desired date" value to WeatherAPIPuller (default to current date + time)
12. ExitGUI: Allows user to end the program

### User Settings
13. UserSettingsGUI: Allows user to change settings
14. UserSettings: Changes settings as desired from user (C to F, Color of Dialog Boxes)
15. ColorSettingsGUI: Allows user to change color of dialog boxes
16. ColorSetings: Changes color of dialog boxes depending on user settings (defaults to... default color)

### Weather Data
17. WeatherDisplayGUI: Displays forecast based on info stored in WeatherData, depending on UserLocation + UserSettings
18. APIPuller: Interfaces with national weather database and pulls JSON file
19. JSONParser: Searches WeatherData file from APIPuller and  
20. WeatherData: Object created by "WeatherAPIPuller" which stores WeatherData
    - Precipitation Data
    - Temperature Data
    - Wind Data
21. TemperatureConverter: Convert F to C or C to F depending on user settings
22. WeatherSettingsGUI: Accessible from WeatherDisplayGUI, allows user to access MainMenuGUI, DateGUI, ExitGUI

### Additional Functionality
23. UserLocationGUI: "Allow this device to access your location?" || "Enter your location"
24. UserLocation: Pulls location from device or UserLocationGUI
25. WeatherInfoPanel (possibly, just call this "main"): Main class that other classes will interface with
26. Exit: Carries out actions as specified by ExitGUI inputs

***********************************************************************************************************










