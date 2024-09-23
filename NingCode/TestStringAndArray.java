package NingCode;

import java.util.*;

/* LeetCode：字符串和数组
 * command + shift + o ：查看当前类的Structure
 * 思路调优题：1.删除有序数组中的重复项II（L104） 
 *           2.多数元素（L169）
 */
public class TestStringAndArray {
  
  String url = "https://leetcode.cn/studyplan/top-interview-150/";

  public static void main(String[] args) {
    int num = 
    // merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    // removeElement(new int[]{3, 2, 2, 3}, 3);    
    //removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    //removeDuplicatesII(new int[]{0,0,1,1,1,1,2,3,3,4,4,4,4,4,5,5,6,6,6});
    //int number = majorityElement(new int[]{1,1,1,2,2,2});
    //majorityElementII(new int[]{2,2,1,1,1});
    //majorityElementIII(new int[]{2,2,1,1,1});
    //rotate(new int[]{1,2,3,4,5,6,7}, 3);
    //maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    maxProfitII(new int[]{7, 1, 5, 3, 6, 4});
    System.out.println(num);
    
  } 

  //1.合并两个有序数组
  /* 题目描述：
   * 给你两个按非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n
   * 分别表示 nums1 和 nums2 中的元素数目。请你合并 nums2 到 nums1 中，使合并后的数组同样按非递减顺序排列。
   * PS:合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n
   * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * 输出：[1,2,2,3,5,6]
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n){
    int i = m - 1, j = n - 1;
    while(i >= 0 && j >= 0){
      if(nums1[i] > nums2[j]){
        nums1[i + j + 1] = nums1[i];
        i--;
      }else {
        nums1[i + j + 1] = nums2[j];
        j--;
      }
    }
    while(j >= 0){
      nums1[j] = nums2[j];
      j--;
    }
    for(int num : nums1){
      System.out.print(num + "");
    }
  }

  //2. 移除元素
  /* 题目描述：
   * 给你一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素。元素的顺序可能发生改变。
   * 然后返回 nums 中与 val 不同的元素的数量。假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
   *    1.更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
   *    2.返回k
   * 输入：nums = [3,2,2,3], val = 3
   * 输出：2, nums = [2,2,_,_]
   */
  public static int removeElement(int[] nums, int val){
    int flag = nums.length - 1;
    for(int i = nums.length - 1; i >= 0; i--){
      if(nums[i] == val){
        nums[i] = 0;
        int temp = nums[flag];
        nums[flag] = nums[i];
        nums[i] = temp;
        flag--;
      }
    }
    for(int num : nums){
      System.out.print(num + " ");
    }
    System.out.print(", flag = " + ++flag);
    return ++flag;
  }

  //3. 删除有序数组中的重复项
  /* 题目描述：
   * 给你一个非严格递增排列的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持一致 。然后返回nums中唯一元素的个数。
   * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
   * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。返回 k 。
   * 输入:  nums = [1,1,2]          
   * 输出:  2, nums = [1,2,_]
   * 输入2: nums = [0,0,1,1,1,2,2,3,3,4]
   * 输出2: 5, nums = [0,1,2,3,4]
   */
  public static int removeDuplicates(int[] nums) {
    //原地删除
    int temp = nums[0];
    int j = 1; //双指针
    int length = nums.length;
    if(length == 0 || length == 1){
      return length;
    }
    for(int i = 1; i < length; i++){
      if(nums[i] != temp){
        nums[j] = nums[i];
        j++;
        temp = nums[i]; 
      }
    }
    return j;
  }

  //4. 删除有序数组中的重复项II
  /* 题目描述：
   * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
   * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
   * 输入：nums = [0,0,1,1,1,1,2,3,3] 0,0,1,1,1,1,2,3,3,4,4,4,4,4,5,5,6,6,6
   * 输出：7, nums = [0,0,1,1,2,3,3]  
   */
  public static int removeDuplicatesII(int[] nums) {
    int temp = 1, count = 1, length = nums.length, flag = nums[0];
    if(length == 0) return 0;
    for(int i = 1; i < length; i++){
      if(nums[i] == flag){
        if(count < 2){
          nums[temp] = nums[i];
          count++;
          temp++;
        }else{
          count++;
        }
      }else{
        nums[temp] = nums[i];
        flag = nums[i];
        temp++;
        count = 1;
      }
    }
    return temp;
  }
  
  public static int removeDuplicatesII(int[] nums, int placeholder) {  //官解做法：思路调优
    int n = nums.length;
    if (n <= 2) {
      return n;
    }
    int slow = 2, fast = 2;
    while (fast < n) {
      if (nums[slow - 2] != nums[fast]) {
        nums[slow] = nums[fast];
        ++slow;
      }
      ++fast;
    }
    return slow;
  }

  //5.多数元素
  /* 题目描述:
   * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
   * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 时间复杂度On、空间复杂度O1
   * 输入: [2,2,1,1,1,2,2]
   * 输出: 2
   * 思路: 哈希表、排序（众数，类似于中位数）、分治、Boyer-Moore 投票算法
   */
  public static int majorityElement(int[] nums) { //哈希表做法
    if(nums.length == 1)return nums[0];
    int baseline = nums.length / 2 + nums.length % 2;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (hashMap.containsKey(nums[i])) {
            int num = hashMap.get(nums[i]);
            num++;
            hashMap.put(nums[i], num);
            if (num >= baseline) {
                return nums[i];
            }
        } else {
            hashMap.put(nums[i], 1);
        }
    }
    return 0;
  }

  public static int majorityElementII(int[] nums){ //做法二：分治 
    int answer = divideAndConquer(nums, 0, nums.length - 1);
    System.out.println(answer);
    return answer;
  }
  public static int divideAndConquer(int[] nums, int i, int j) { //0 ~ 7[8]   3    0~6[7] 3
    if(i == j){
      return nums[i];
    }
    int mid = (i + j) / 2;
    int numA = divideAndConquer(nums, i, mid); //0 1 2 3 //01 23//
    int numB = divideAndConquer(nums, mid + 1, j);//4 5 6//45 6//4 5 6
    if(numA == numB) return numA;

    int countA = countNum(nums, i, mid, numA);
    int countB = countNum(nums, mid + 1, j, numB);
  
    if(countA > countB) return numA;
    else return numB;
  }
  public static int countNum(int[] nums, int i, int j, int number) {
    int count = 0;
    for(int i1 = i; i1 <= j; i1++) {
      if(nums[i1] == number) {
        count++;
      }
    }
    return count;
  }

  public static int majorityElementIII(int[] nums) { //Boyer-Moore 投票算法
    int candidate = nums[0], count = 0;
    for(int i = 0; i < nums.length; i++){
      if(count == 0) candidate = nums[i];
      count += (nums[i] == candidate)? 1 : -1;
    }
    return candidate;
  }

  //6.翻转数组
  /* 题目描述:给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
   * 输入: nums = [1,2,3,4,5,6,7], k = 3
   * 输出: [5,6,7,1,2,3,4]
   * 做法: 额外空间（新数组）、翻转（时间On、空间O1）
   */
  public static void rotate(int[] nums, int k){
    int status = k % nums.length;
    reverseRotate(nums, 0, nums.length - 1);
    reverseRotate(nums, 0, status - 1);
    reverseRotate(nums, status, nums.length - 1);
    for(int num : nums){
      System.out.print(num + " ");
    }
  }
  public static void reverseRotate(int[] nums, int left, int right){
    int i = left, j = right;
    while(i < j){
      int temp =  nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }

  //7.买卖股票的最佳时机
  /* 题目描述:给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
   * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
   * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
   * 输入:7,1,5,3,6,4
   * 输出:5
   */
  public static int maxProfit(int[] prices) {
    int min = prices[0] ,profit = 0;
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] < min) {
        min = prices[i];
      }
      if(prices[i] - min > profit) {
        profit = prices[i] - min;
      }
    }
    return profit;
  }

  //8.买卖股票的最佳时机II
  /* 题目描述:给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
   * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。你可以购买，然后在同一天出售。
   * 你也可以先购买，然后在同一天出售。返回 你能获得的最大利润 。
   * 输入:prices = [7,1,5,3,6,4]     1->5=4 + 3->6=3 = 7
   * 输出:7
   */
  public static int maxProfitII(int[] prices) { //找递增序列,贪心
    int left = prices[0], right = prices[0], count = 0;
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] >= right) {
        right = prices[i];
      }else{
        count += right - left;
        right = prices[i];
        left = prices[i];
      }
    }
    count += right - left;
    return count;
  }
}
