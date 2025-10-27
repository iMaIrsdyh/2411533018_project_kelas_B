package config;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {

    private static final int SALT_LENGTH = 16; // bytes
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256; // bits

    // Generate random salt (base64)
    public static String generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash password with provided salt (salt in base64). Return hash in base64.
    public static String hashPassword(String password, String saltBase64) {
        try {
            byte[] salt = Base64.getDecoder().decode(saltBase64);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException("Error hashing password: " + ex.getMessage(), ex);
        }
    }

    // Create stored value: salt + "$" + hash (both base64)
    public static String createStoredPassword(String password) {
        String salt = generateSalt();
        String hash = hashPassword(password, salt);
        return salt + "$" + hash;
    }

    // Verify plain password against stored value (salt$hash)
    public static boolean verifyPassword(String password, String stored) {
        if (stored == null || !stored.contains("$")) return false;
        String[] parts = stored.split("\\$");
        if (parts.length != 2) return false;
        String salt = parts[0];
        String hash = parts[1];
        String computed = hashPassword(password, salt);
        return computed.equals(hash);
    }
}