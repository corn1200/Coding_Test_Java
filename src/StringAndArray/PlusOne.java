package StringAndArray;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8, 9, 9};

        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.println("val: " + i);
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }

            if (i == 0) {
                int[] result = new int[digits.length+1];
                result[0] = 1;
                return result;
            }
        }
        return digits;
    }
}
