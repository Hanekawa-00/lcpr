import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Collectors;

public class Sort {
    /**
     * 插入排序
     * 根本就是使得有序区间扩大（一个一个元素添加）
     * 
     * @param nums
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // base 用来暂时存储第i个值（temp），j是i的前一个索引即已经排序区间的右端
            int base = nums[i], j = i - 1;
            // 当已经排序好的区间中的最右边的值（最大值）大于base时一直寻找插入点，直到找到小于等于或者到区间最左边停止
            while (nums[j] > base && j >= 0) {
                // 在寻找插入点时顺便让区间中的数向右移动
                nums[j + 1] = nums[j];
                j--;
            }
            // 在插入点将base插入
            nums[j + 1] = base;
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 选择一个大区间最右边的作为最大值，
     * 再对这个区间作遍历，相邻的两个数大的左边的大则交换右移。
     * 与选择排序不同的是，选择排序是直接依次满足条件就交换。
     * 冒泡就相当于区间内部动态交换数据
     * </p>
     * 
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j + 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * <p>
     * 根据排序规则可知最左端为最小，最右端是最大。
     * 所以”选择“一个大区间的最左或最右边的来当作区间的最大最小值。
     * 遍历最小值右边的子区间或者最大值左边的子区间与当前的最大最小值（bushi）比较交换
     * </p>
     * 
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            // k是区间内最小元素索引
            int k = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;// 更新索引
                }
            }
            swap(nums, i, k);// 将最小元素和区间最左元素交换
        }
    }

    /**
     * 交换
     * 
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 10001, 5, 6, 2, 9, 96, 1000, 5 };
        insertionSort(arr);
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(list);
    }
}
