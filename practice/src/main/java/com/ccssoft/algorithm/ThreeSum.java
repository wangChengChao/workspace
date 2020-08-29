package com.ccssoft.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: kermit
 * @date: 2020/8/29/8:04
 */
public class ThreeSum {

  public static void main(String[] args) {
    int a[] = {0, 0, 0};
    System.out.println(threeSum(a));
  }

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> ret = new ArrayList<>();

    // 排序

    Arrays.sort(nums);

    // -2 -1 -1 -1 1 2 3 3 4

    int left, right;

    for (int i = 0; i < nums.length - 2; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      left = i + 1;
      right = nums.length - 1;

      while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {

          ArrayList<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[left]);
          list.add(nums[right]);
          ret.add(list);
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }

        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return ret;
  }
}
