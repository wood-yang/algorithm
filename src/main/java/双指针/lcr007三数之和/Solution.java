package 双指针.lcr007三数之和;

import java.util.*;

/**
 * LCR 007. 三数之和
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }

                while (l < r && nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }
                while (l < r && nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                if (l >= r) {
                    break;
                }

                if (nums[i] + nums[l] + nums[r] == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                }
            }
        }
        return list;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        //排序
//        Arrays.sort(nums);
//        for (int a = 0; a < nums.length; a++) {
//            if (a > 0 && nums[a] == nums[a - 1]) {
//                continue;
//            }
//            int b = a + 1;
//            int c = nums.length - 1;
//            while (b < c) {
//                while (b > a + 1 && b < c && nums[b] == nums[b - 1]) {
//                    b++;
//                }
//                if (b == c) {
//                    break;
//                }
//                if (nums[a] + nums[b] + nums[c] > 0) {
//                    c--;
//                }
//                else if (nums[a] + nums[b] + nums[c] == 0) {
//                    List list = List.of(nums[a], nums[b], nums[c]);
//                    ans.add(list);
//                    b++;
//                }
//                else if (nums[a] + nums[b] + nums[c] < 0) {
//                    b++;
//                }
//            }
//        }
//        return ans;
//    }
}
