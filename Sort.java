public class Sort {
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];// 目标
            int j = i - 1;
            while (j >= 0 && nums[j] >= base) {
                nums[j + 1] = nums[j];// 记录需要插入的位置的数
                j--;
            }
            nums[j + 1] = base;
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 交换
     * 
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 10001, 5, 6, 2, 9, 96, 1000, 5 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
