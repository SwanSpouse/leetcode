package array;

public class FindTheDuplicateNumber {

    /*
    The main idea is the same with problem Linked List Cycle II,
    https://leetcode.com/problems/linked-list-cycle-ii/.
    Use two pointers the fast and the slow.
    The fast one goes forward two steps each time, while the slow one goes only step each time.
    They must meet the same item when slow==fast.
    In fact, they meet in a circle, the duplicate number must be the entry point of the circle
    when visiting the array from nums[0]. Next we just need to find the entry point.
    We use a point(we can use the fast one before) to visit form begining with one step each time,
    do the same job to slow. When fast==slow, they meet at the entry point of the circle.
    The easy understood code is as follows.
     */
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int fast = 0;
        int slow = 0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
