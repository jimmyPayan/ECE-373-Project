# ECE-373-Project
We are working on a weather GUI. It will pull information from weather station APIs and output weather data (from a specific input date + time) for a user to see.

## Team Members:
### Ryan Fong, Jacob Missbrenner, Aayush Patel, Jimmy Payan, Ahmad Qureshi

Specific weather station API (tenative): https://www.weather.gov/documentation/services-web-api

<<<<<<< HEAD
## List of classes used in this project

### Login
1.  User: Generic User class - this base class is assigned to everyone running the program by default
2.  Admin: Subclass of User with additional permissions
3.  LoginGUI: Allows users to be assigned admin/maintenance class if they enter username + password. Login first, then go to MainMenuGUI
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
16. MapUnit: Allows users to specify miles or kilometers. (See about rolling scale and unit into one class)

### Weather Data
17. WeatherDisplayGUI: Displays forecast based on info stored in WeatherData, depending on UserLocation + UserSettings + MapScale + MapUnit
18. WeatherAPIPuller: Pulls data from website and stores into "WeatherData" class
    - Data requester: Requests from weather database data for user
    - Data processor: Processes the response from the weather database
19. WeatherData: Object created by "WeatherAPIPuller" which stores... WeatherData
20. TemperatureConverter: Convert F to C or C to F depending on user settings
21. WeatherSettingsGUI: Accessible from WeatherDisplayGUI, allows user to access MainMenuGUI, DateGUI, ExitGUI

### Additional Functionality
22. UserLocationGUI: "Allow this device to access your location?" || "Enter your location"
23. UserLocation: Pulls location from device or UserLocationGUI
24. WeatherInfoPanel (possibly, just call this "main"): Main class that other classes will interface with
25. Exit: Ends the program

***********************************************************************************************************










=======
### List of classes used in this project:
1.  MainMenuGUI: Takes user to different actions: UserSettingsGUI, DateGUI, LoginGUI, ExitGUI
2.  MainMenuAction: Carries out actions as specified by MainMenuGUI inputs
3.  WeatherAPIPuller: Pulls data from website
    - Data requester: Requests from weather database data for user
    - Data processor: Processes the response from the weather database
4.  UserLocationGUI: "Allow this device to access your location?" || "Enter your location"
5.  UserLocation: Pulls location from device or UserLocationGUI
6.  UserSettingsGUI: Allows user to change settings
7.  UserSettings: Changes settings as desired from user (C to F, Color of Dialog Boxes)
8.  TemperatureConverter: Convert F to C or C to F depending on user settings
9.  ColorSettingsGUI: Allows user to change color of dialog boxes
10. ColorSetings: Changes color of dialog boxes depending on user settings (defaults to... default color)
11. DateGUI: Allows user to change desired date and time for weather data
12. Date: Provides "desired date" value to WeatherAPIPuller (default to current date + time)
13. User: Generic User class - this base class is assigned to everyone running the program by default
14. Admin: Subclass of User w/ additional perms
15. Maintenance: Subclass of User w/ additional perms (less than Admin)
16. LoginGUI: Allows users to be assigned admin/maintenance class if they enter username + password
17. Login: Checks if entered credentials are in CredentialDatabase and modifies "user" accordingly
18. CredentialDatabase: Reads all valid username + password combinations and compares against a file
19. WeatherDisplayGUI: Displays forecast based on info stored in WeatherData, depending on UserLocation + UserSettings
20. WeatherSettingsGUI: Accessible from WeatherDisplayGUI, allows user to access MainMenuGUI, DateGUI, ExitGUI
21. ExitGUI: Allows user to end the program
22. Exit: Ends the program
23. SaveDataGUI: Allows user to save snapshot of weather data to their PC
24. SaveData: Saves snapshot of weather data to user PC
25. WeatherData: Object created by "WeatherAPIPuller"
26. GUIPanel: Superclass for all GUI panels to inherit from
>>>>>>> 3d54ea0 (Added a superclass for all GUI panels and updated to simpler database)
