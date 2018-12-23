package sort_and_search;

import utils.Print;

/**
 *  技巧性还是很强的。这道题有点儿快排的思想在里面。
 */
public class SortColors {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length -1;
        for(int i=0; i < blue + 1; ) {
            if(nums[i] == 0) {
                swap(nums, i ++, red ++);
            } else if(nums[i] == 2) {
                swap(nums, i, blue --);
            } else {
                i ++ ;
            }
        }
    }

    public static void main(String[] args) {
        int[] ret = new int [] {0,1,2,2,1,0};
        sortColors(ret);
        Print.printArr(ret);
    }

}