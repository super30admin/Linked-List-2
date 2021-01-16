//Problem 53: Reorder List
// Time Complexity : O(N), number of nodes in linkedlist
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Steps : Brute Force: Traverse throught the linkedlist, insert all elements in the array list and then create new linkedlist using first and last element of the array. TC:O(N), SC:O(N)
        
        Optimal:TC: O(N), SC: O(1)
                  1) Find Mid
                  2) Reverse from mid next (slow.next)
                  3) Merger both the list
        
*/

class ReorderList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if(head==null) return ;
        
        //Brute Force: Traverse throught the linkedlist, insert all elements in the array list and then create new linkedlist using first and last elemnet of the array. TC:O(N), SC:O(N)
        
        /*Optimal:1) Find Mid
                  2) Reverse from mid next (slow.next)
                  3) Merger both the list
        
        */
        
        //1) Find Mid
        ListNode slow = head;
        ListNode fast = head;
        
        //while(fast.next!=null && fast.next.next!=null){
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        //2) Reverse Linked List after the mid
        head2 = getReversedList(head2);
        
        //3) Merge two list
        
        ListNode currA = head;
        ListNode currB = head2;
        
        while(currB!=null){
            ListNode temp = currA.next;
            currA.next    = currB;
            currB         = currB.next;
            currA.next.next = temp;
            
            currA = temp;
        }
        
    }
    
    private ListNode getReversedList(ListNode head){
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            
            curr = next;
        }
        
        return prev;
    }
    
}