/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Add all elements of linked list into an ArrayList and build the linked list by reordering it
// TC - O(n)
// SC - O(n)
class ReorderLinkedList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode pointer = head;
        while(pointer!= null) {
            list.add(pointer);
            pointer = pointer.next;
        }
        int n = list.size();
        head = list.get(0);
        ListNode current = head;
        for(int i=0;i<n/2;i++) {
            if(i!= 0) {
                ListNode temp1 = list.get(i);
                ListNode temp2 = list.get(n-i-1);
                current.next = temp1;
                temp1.next = temp2; 
                current = temp2; 
            } else{
                ListNode temp2 = list.get(n-i-1);
                head.next = temp2;
                current = temp2; 
            }
        }
        if(n%2 !=0) {
            ListNode mid = list.get(n/2);
            current.next = mid;
            current = mid;
        }
        current.next = null;
    }
}


// Find middle element
// Reverse the second half of the list and merge both of them
// TC - O(n)
// SC - O(1)
class Solution {
public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    // Find middle element
    while(fast.next!= null && fast.next.next!= null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse the second half of the list
    fast = reverse(slow.next);
    slow.next = null;



    // merge 2 halves
    slow = head;
    ListNode temp = new ListNode();
    while(fast!= null && slow!=null) {
        temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }
}
private ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while(curr!= null) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    return prev;
}
}