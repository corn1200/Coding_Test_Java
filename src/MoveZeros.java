public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
                System.out.println(nums[i]);
            }
        }
    }
}
