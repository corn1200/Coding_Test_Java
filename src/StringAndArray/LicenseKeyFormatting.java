package StringAndArray;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int k = 4;
        System.out.println(licenseKetFormatting(S, k));
    }

    public static String licenseKetFormatting(String s, int k) {
        String S1 = s.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            sb.append(S1.charAt(i));
        }
        int len = sb.toString().length();
        for (int i = k; i < len; i = i + k) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
