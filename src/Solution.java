public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        while(b <= 100) {
            int c = b;
            System.out.println(b + a);
            b += a;
            a = c;
        }
    }
}