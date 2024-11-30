import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CredentialDatabase {
    private File databaseFile = new File("DB.txt");
    public CredentialDatabase(File databaseFile) {
        this.databaseFile = databaseFile;
    }
    public void addEntry(String name, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFile, true))) {
            if(!inDatabase(name, Encryptor.encrypt(password, 1))) {
                writer.write(name + " " + Encryptor.encrypt(password, 1));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public boolean inDatabase(String name, String password) {
        try (Scanner scanner = new Scanner(databaseFile)) {
            while (scanner.hasNextLine()) {
                String[] entry = scanner.nextLine().split(" ");
                if (entry.length == 2 && entry[0].equals(name) && entry[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
    public void removeEntry(String name, String password) {
        List<String> entries = new ArrayList<>();

        // Read all entries and keep the ones that don't match
        try (Scanner scanner = new Scanner(databaseFile)) {
            while (scanner.hasNextLine()) {
                String entry = scanner.nextLine();
                String[] parts = entry.split(" ");
                if (!(parts.length == 2 && parts[0].equals(name) && parts[1].equals(password))) {
                    entries.add(entry);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Rewrite the file with the remaining entries
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFile, false))) {
            for (String entry : entries) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // Example usage
        File file = new File("credentials.txt");
        CredentialDatabase db = new CredentialDatabase(file);

        db.addEntry("username1", Encryptor.encrypt("password1", 1));
        db.addEntry("username2", Encryptor.encrypt("password2", 1));

        System.out.println(db.inDatabase("username1", Encryptor.encrypt("password1",1)));  // true
        System.out.println(db.inDatabase("username2", Encryptor.encrypt("wrongpass", 1)));  // false

        db.removeEntry("username1", Encryptor.encrypt("password1", 1));

        System.out.println(db.inDatabase("username1", Encryptor.encrypt("password1", 1)));  // false
    }

}