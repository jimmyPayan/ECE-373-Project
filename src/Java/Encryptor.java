public class Encryptor {
    public static String encrypt(String old, int seed) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < old.length(); i++) {
            char c = old.charAt(i);

            if (Character.isLowerCase(c)) {
                // Shift lowercase letters
                char shifted = (char) ('a' + (c - 'a' + seed) % 26);
                encrypted.append(shifted);
            } else if (Character.isUpperCase(c)) {
                // Shift uppercase letters
                char shifted = (char) ('A' + (c - 'A' + seed) % 26);
                encrypted.append(shifted);
            } else {
                // Leave non-letter characters as they are
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String originalText = "Hello World!";
        String encryptedText = encrypt(originalText, 1);
        System.out.println("Original: " + originalText);
        System.out.println("Encrypted: " + encryptedText);
    }
}
