package sort_and_search;

import utils.Print;

public class BinarySearch {

    // 普通的二分查找，找到则返回index，否则返回-1
    public int binarySearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] > target) {
                right = mid - 1;
            } else if (input[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 找最左 如果有重复元素返回最小的index，如果没有重复元素返回 -1
    public int binarySearchLeftMax(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;
        int ret = -1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (input[mid] <= target) {
                if (input[mid] == target) {
                    ret = mid;
                }
                left = mid + 1;
            } else if (input[mid] > target) {
                right = mid - 1;
            }
        }
        return ret;
    }

    // 找最右 如果有重复元素返回最大的index，如果没有重复元素返回 -1
    public int binarySearchRightMin(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;
        int ret = -1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (input[mid] < target) {
                left = mid + 1;
            } else if (input[mid] >= target) {
                if (input[mid] == target) {
                    ret = mid;
                }
                right = mid - 1;
            }
        }
        return ret;
    }

    // 找区间 如果有重复元素，返回重复元素的区间 左右 index
    public int[] binarySearchRange(int[] input, int target) {
        return new int[]{binarySearchRightMin(input, target), binarySearchLeftMax(input, target)};
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new BinarySearch().binarySearchLeftMax(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(new BinarySearch().binarySearchRightMin(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        Print.printArr(new BinarySearch().binarySearchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }
}
