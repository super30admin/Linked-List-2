// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1 . Calculate midpoint and reverse list after midpoint .
// 2. Now add elements in first list(before  including midpoint) and secondlist(list after midpoint) alternatively.
public class reorderList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null || head.next.next == null)
            return ;
        //finding midpoint
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        // reversing the second list.
        ListNode prev = null;
        while(fast!=null){
            ListNode next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        fast = prev;
        slow = head;
        while(slow!=null && fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    // Your code here along with comments explaining your approach
    // 1. Calculate length of list and create a new LinkedList which is the reversed version of given Linkedlist
    // 2. Now create a list Node with the first node being the given node. From next node add current node and then reverse list nodes alternatively.
    // 3 . Move current and reverse node's position to next nodes respectively.Do this n times(length of given list).
    public void reorderList2(ListNode head) {
        ListNode copy = head;
        if(head == null || head.next == null || head.next.next == null)
            return ;
        int length = 0;
        while(copy != null){
            length++;
            copy = copy.next;
        }
        ListNode reverse = reverse(head);
        ListNode prev = head.next;;
        copy = head;
        ListNode temp = copy;
        int i = 1;
        while(i<=length){
            if(i%2==0 ){
                copy.next = prev;
                prev = prev.next;
            }
            else{
                copy.next = reverse;
                reverse = reverse.next;
            }
            temp = copy;
            copy = copy.next;

            i++;
        }
        temp.next = null;
        return;
    }
    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        else {
            ListNode node = new ListNode(head.val);
            head = head.next;
            while(head!= null){
                ListNode temp = new ListNode(head.val);
                temp.next = node;
                node = temp;
                head = head.next;
            }
            return node;
        }
    }
}
