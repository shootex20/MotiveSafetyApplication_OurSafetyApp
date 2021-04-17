package services;

import dataaccess.UserDB;
import domain.Logins;

import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

// TODO: Auto-generated Javadoc
/**
 * Original Password hashing PBKDF2 algorithm by MicleBrick Dec 3, 2018 contains
 * salting and hashing algorithm as well other password methods
 * https://github.com/defuse/password-hashing
 * https://github.com/defuse/password-hashing/blob/master/PasswordStorage.java
 *
 * @author Daniel Quach
 */
public class PasswordStorage {

    /**
     * Internal class to define a user defined exception for bad hashes.
     */
    @SuppressWarnings("serial")
    static public class InvalidHashException extends Exception {

        /**
         * Custom exception for invalid hashes.
         *
         * @param message the message to be displayed
         */
        public InvalidHashException(String message) {
            super(message);
        }

        /**
         * Custom exception for invalid hashes.
         *
         * @param message the message to be displayed
         * @param source the source of the issue
         */
        public InvalidHashException(String message, Throwable source) {
            super(message, source);
        }
    }

    /**
     * Internal class to define a user defined exception for operations that are
     * not possible.
     */
    @SuppressWarnings("serial")
    static public class CannotPerformOperationException extends Exception {

        /**
         * Custom exception for invalid operations.
         *
         * @param message the message to be displayed
         */
        public CannotPerformOperationException(String message) {
            super(message);
        }

        /**
         * Custom exception for invalid operations.
         *
         * @param message the message to be displayed
         * @param source the source of the issue
         */
        public CannotPerformOperationException(String message, Throwable source) {
            super(message, source);
        }
    }

    /** The Constant PBKDF2_ALGORITHM. */
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    // These constants may be changed without breaking existing hashes.

    /** The Constant SALT_BYTE_SIZE. */
    public static final int SALT_BYTE_SIZE = 24;

    /** The Constant HASH_BYTE_SIZE. */
    public static final int HASH_BYTE_SIZE = 18;

    /** The Constant PBKDF2_ITERATIONS. */
    public static final int PBKDF2_ITERATIONS = 64000;

    // These constants define the encoding and may not be changed.

    /** The Constant HASH_SECTIONS. */
    public static final int HASH_SECTIONS = 5;

    /** The Constant HASH_ALGORITHM_INDEX. */
    public static final int HASH_ALGORITHM_INDEX = 0;

    /** The Constant ITERATION_INDEX. */
    public static final int ITERATION_INDEX = 1;

    /** The Constant HASH_SIZE_INDEX. */
    public static final int HASH_SIZE_INDEX = 2;

    /** The Constant SALT_INDEX. */
    public static final int SALT_INDEX = 3;

    /** The Constant PBKDF2_INDEX. */
    public static final int PBKDF2_INDEX = 4;

    /**
     * Method for creating hashes.
     *
     * @param password password created by administrators
     * @return recursive call to the other overloaded method
     * @throws CannotPerformOperationException the cannot perform operation exception
     */
    public static String createHash(String password) throws CannotPerformOperationException {
        return createHash(password.toCharArray());
    }

    /**
     * Creates a secure random salt with a PBKDF2 hash and combines the parts.
     *
     * @param password the password created but casted to a char array
     * @return the salted and hashed password
     * @throws CannotPerformOperationException the cannot perform operation exception
     */
    public static String createHash(char[] password) throws CannotPerformOperationException {
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);

        // Hash the password
        byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        int hashSize = hash.length;

        // format: algorithm:iterations:hashSize:salt:hash
        String parts = "sha1:" + PBKDF2_ITERATIONS + ":" + hashSize + ":" + toBase64(salt) + ":"
                + toBase64(hash);
        return parts;
    }

    /**
     * Uses to verify if a password matches the stored value.
     *
     * @param password a string input during login
     * @param correctHash the value stored in the database
     * @return a recursive call to the other overloaded method
     * @throws CannotPerformOperationException the cannot perform operation exception
     * @throws InvalidHashException the invalid hash exception
     */
    public boolean verifyPassword(String password, String correctHash) throws CannotPerformOperationException, InvalidHashException {
        return verifyPassword(password.toCharArray(), correctHash);
    }

    /**
     * Hashes the string password and compares it with the stored value to
     * determine if there is a match.
     *
     * @param password the string password converted to a char array
     * @param correctHash the correct password in the database
     * @return true or false if both hashes are equal
     * @throws CannotPerformOperationException the cannot perform operation exception
     * @throws InvalidHashException the invalid hash exception
     */
    public boolean verifyPassword(char[] password, String correctHash) throws CannotPerformOperationException, InvalidHashException {
        // Decode the hash into its parameters
        String[] params = correctHash.split(":");
        if (params.length != HASH_SECTIONS) {
            throw new InvalidHashException("Fields are missing from the password hash.");
        }

        // Currently, Java only supports SHA1.
        if (!params[HASH_ALGORITHM_INDEX].equals("sha1")) {
            throw new CannotPerformOperationException("Unsupported hash type.");
        }

        int iterations = 0;
        try {
            iterations = Integer.parseInt(params[ITERATION_INDEX]);
        } catch (NumberFormatException ex) {
            throw new InvalidHashException("Could not parse the iteration count as an integer.", ex);
        }

        if (iterations < 1) {
            throw new InvalidHashException("Invalid number of iterations. Must be >= 1.");
        }

        byte[] salt = null;
        try {
            salt = fromBase64(params[SALT_INDEX]);
        } catch (IllegalArgumentException ex) {
            throw new InvalidHashException("Base64 decoding of salt failed.", ex);
        }

        byte[] hash = null;
        try {
            hash = fromBase64(params[PBKDF2_INDEX]);
        } catch (IllegalArgumentException ex) {
            throw new InvalidHashException("Base64 decoding of pbkdf2 output failed.", ex);
        }

        int storedHashSize = 0;
        try {
            storedHashSize = Integer.parseInt(params[HASH_SIZE_INDEX]);
        } catch (NumberFormatException ex) {
            throw new InvalidHashException("Could not parse the hash size as an integer.", ex);
        }

        if (storedHashSize != hash.length) {
            throw new InvalidHashException("Hash length doesn't match stored hash length.");
        }

        // Compute the hash of the provided password, using the same salt, 
        // iteration count, and hash length
        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
        // Compare the hashes in constant time. The password is correct if
        // both hashes match.

        return slowEquals(hash, testHash);
    }

    /**
     * Compares each password character by character.
     *
     * @param a byte array of password input
     * @param b byte array of of stored password
     * @return true or false if there is a difference
     */
    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }

    /**
     * The pbkdf2 hashing algorithm with a salt.
     *
     * @param password the original password string converted to a char array
     * @param salt the passed salt byte array
     * @param iterations total number of passes
     * @param bytes the size of the hash
     * @return a salted and hashed password
     * @throws CannotPerformOperationException the cannot perform operation exception
     */
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws CannotPerformOperationException {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new CannotPerformOperationException("Hash algorithm not supported.", ex);
        } catch (InvalidKeySpecException ex) {
            throw new CannotPerformOperationException("Invalid key spec.", ex);
        }
    }

    /**
     * For decoding from base64.
     *
     * @param hex a hexadecimal string
     * @return the decoded byte array
     * @throws IllegalArgumentException if there is an error with the passed
     * argument
     */
    private static byte[] fromBase64(String hex) throws IllegalArgumentException {
        return Base64.getDecoder().decode(hex);
    }

    /**
     * For encoding to base64.
     *
     * @param array an array of bytes
     * @return a string encoded to base64
     */
    private static String toBase64(byte[] array) {
        return Base64.getEncoder().encodeToString(array);
    }

    /**
     * Used for replacing a forgotten password with a new randomized one.
     *
     * @return a securely randomized password string
     */
    public String newRandomPassword() {
        String temporary = Long.toHexString(Double.doubleToLongBits(Math.random()));
        return temporary;
    }

    /**
     * Used to reset the password for an account.
     *
     * @param username the string of an existing accounts username
     * @throws Exception if there is any issue during the process
     */
    public void passwordReset(String username) throws Exception {

        UserDB udb = new UserDB();
        final String SUBJECT = "Your password has been reset";
        String to = username;

        Logins user = udb.getUser(username);

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new Exception();
        }

        LoginService ls = new LoginService();
        String tempPassword = newRandomPassword();
        String body = "Your new temporary password is: " + tempPassword;

        ls.updatePassword(username, tempPassword);
        EmailService es = new EmailService();
        es.sendMail(to, SUBJECT, body, false);
    }

}
