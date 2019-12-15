package 复习.排序;

import java.util.HashMap;

public class QuickSortTest {

    public static void quickSort(int[] nums, int L, int R){
        if(L < R){
            swap(nums, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(nums, L, R);
            quickSort(nums, L, p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }
    private static int[] partition(int[] nums, int L, int R){
        int cur = L;
        int less = L - 1;
        int more = R;
        while (cur < more){
            if(nums[cur] > nums[R]){
                swap(nums, cur, --more);
            }else if(nums[cur] < nums[R]){
                swap(nums, cur++, ++less);
            }else{
                cur++;
            }
        }
        swap(nums, more, R);
        return new int[]{less + 1, more};
    }


    public static void swap(int[] nums, int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 7, 8, 5, 5, 9, 10, 4, 3};
        QuickSortTest.quickSort(a, 0, a.length - 1);
        for (int i:a) {
            System.out.print(" " +i+" ");
        }
    }
}
