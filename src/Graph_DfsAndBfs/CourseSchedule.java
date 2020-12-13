package Graph_DfsAndBfs;

import java.util.*;

// nums 배열이 순서 규칙을 잘 지킨채로
// 정렬되어 있는가를 판단하는 프로그램입니다.
public class CourseSchedule {

    public static void main(String[] args) {
        int course = 4;
        int[][] nums = { { 1, 0 },
                { 2, 1 },
                { 3, 2 } };

        CourseSchedule a = new CourseSchedule();
        System.out.println(a.solve(course, nums));
    }

    //
    public boolean solve(int courseNumber, int[][] nums) {
        if (courseNumber <= 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        int numsLength = nums.length;

        //
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]]++;
        }

        int completeLength = inDegree.length;
        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int zeroVal = queue.poll();
            for (int i = 0; i < numsLength; i++) {
                if (zeroVal == nums[i][0]) {
                    inDegree[nums[i][1]]--;
                    if (inDegree[nums[i][1]] == 0) {
                        queue.offer(nums[i][1]);
                    }
                }
            }
        }

        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }
}