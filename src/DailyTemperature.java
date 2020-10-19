import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(nums);

        System.out.println("===result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    private static int[] dailyTemperatures(int[] temper) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];
        return null;
    }
}
