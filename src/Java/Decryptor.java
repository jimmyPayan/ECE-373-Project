public class Decryptor {
    public static String decrypt(String old, int seed) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < old.length(); i++) {
            char c = old.charAt(i);

            if (Character.isLowerCase(c)) {
                // Shift lowercase letters
                char shifted = (char) ('a' + (c - 'a' - seed) % 26);
                decrypted.append(shifted);
            } else if (Character.isUpperCase(c)) {
                // Shift uppercase letters
                char shifted = (char) ('A' + (c - 'A' - seed) % 26);
                decrypted.append(shifted);
            } else {
                // Leave non-letter characters as they are
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }
    public static void main(String[] args) {
        // Example usage
        String originalText = "Ifmmp Xpsme!";
        String encryptedText = decrypt(originalText, 1);
        System.out.println("Original: " + originalText);
        System.out.println("Decrypted: " + encryptedText);
    }
}
