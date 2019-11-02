/*
Author: Akhilesh Borgaonkar
Problem: LC 143. Reorder List (Linked List-2)
Approach: Using 2-pointers approach here. Find the middle node in the Linked List then, reverse the list of nodes beyond the middle node.
    Then, we have two separate lists. Now, we append both the lists one after another with the help of two-pointers.
Time Complexity: O(n) where n is number of total nodes in the LinkedList.
Space complexity: O(1) constant.
LC verified.
*/

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){ //determining mid node
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);      //get the reverse list beyond middle element    
        slow.next = null;                   //break two separate lists
        slow = head;                        //reset the slow pointer to original head of the list
        ListNode temp;
        while(slow != null && fast != null){    //Now traverse both the lists and append nodes alternatively
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
        
    }
    
    private ListNode reverseList(ListNode rHead){
        
        //reverse the list beyond mid
        
        if(rHead == null)
            return null;
        
        ListNode prev = null;
        ListNode curr = rHead;
        ListNode next = rHead.next;
        
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }
}