// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RemoveNthElementFromEndInLL {
    // Brute Force, 2 Pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        System.out.println("size "+size);

        ListNode curr = head;
        int destIndex = size - n;
        System.out.println("destIndex "+destIndex);
        if(size == n){
            return head.next;
        }
        if(destIndex > 0){
            int count = 1;
            while(curr.next != null){
                if(count == destIndex){
                    curr.next = curr.next.next;
                    return head;
                } else{
                    count++;
                    System.out.println("count "+count);
                    curr = curr.next;
                }
            }
        }
        return null;
    }


}
