package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        return parts[parts.length - 1]; // ambil kata terakhir
    }
}
 