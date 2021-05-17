// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class LinkedListInterSection {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        // Getting the count of first Linked List
        int count1 = 1;
        while(ptr1 != null){
            ptr1=ptr1.next;
            count1++;
        }
        // Reset the head of the first Linked List.
        ptr1 = headA;
        
        // Getting the count of second Linked List.
        int count2 = 1;
        while(ptr2 != null){
            ptr2=ptr2.next;
            count2++;
        }
        // Reset the head of the second Linked List.
        ptr2 = headB;
        
        // Get the diff of the two counts.
        int diff = Math.abs(count1 - count2);
        
        // Move the head pointer of the longest linked list by diff count.
        if(count1 > count2){
            while(diff-- > 0) ptr1 = ptr1.next;
        }else{
            while(diff-- > 0) ptr2 = ptr2.next;
        }
        
        // Iterate the two pointers at same speed.
        // If the pointers meet then the two linked list meet at a specific node.
        // If they don't meet then the value of the pointer will be null.
        while(ptr1 != null && ptr2 != null && ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        // We can return either pointer 1 or 2.
        return ptr1;
    }
}
