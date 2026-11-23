package koneksi;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class BuatHash {
    public static void main(String[] args) throws Exception {
        String password = "admin123";   // ganti sesuai keinginan
        int iterasi = 600000;

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterasi, 256);
        byte[] hash = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                .generateSecret(spec).getEncoded();

        System.out.println("pbkdf2-sha256:" + iterasi + ":"
                + Base64.getEncoder().encodeToString(salt) + ":"
                + Base64.getEncoder().encodeToString(hash));
    }
}