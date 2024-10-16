public class TemperatureConverter {
    
    // Convert Celsius to Fahrenheit
    public static double fahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    // Convert Fahrenheit to Celsius
    public static double celsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        // Test the conversion methods
        double tempC = 25.0; // Celsius
        double tempF = 77.0; // Fahrenheit

        System.out.println(tempC + "°C is " + fahrenheit(tempC) + "°F");
        System.out.println(tempF + "°F is " + celsius(tempF) + "°C");

        // Additional test cases
        double freezingC = 0.0;
        double boilingC = 100.0;

        System.out.println(freezingC + "°C (freezing point) is " + fahrenheit(freezingC) + "°F");
        System.out.println(boilingC + "°C (boiling point) is " + fahrenheit(boilingC) + "°F");
    }
}
