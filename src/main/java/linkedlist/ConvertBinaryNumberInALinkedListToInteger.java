package linkedlist;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int ret = 0;
        while(head != null) {
            ret = ret*2 + head.val;    
            head = head.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode list = LinkedList.constructLinkedList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0});
        System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue(list));
    }
}
