// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes   
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach: we first find
// the middle node and then reverse from the middle node. Then make the connections 

public class Reorder {
    public void reorderList(ListNode head) {
        ListNode start = head, end = head;
        while(end != null && end.next != null){
            start = start.next;
            end = end.next.next;
        }
        ListNode prev = null;
        ListNode curr = start;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        //merge both lists 
        ListNode first = head, second = prev;
        while(second.next != null){
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;
            tmp = second.next;
            second.next = first;
            second = tmp;
        }

    }

}
