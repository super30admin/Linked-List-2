// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public void reorderList(ListNode head) {
    if(head == null || head.next == null) return;
    
    ListNode slow = head;
    ListNode fast = head;
    //using slow and fast to find the mid of the linkedlist
    while(fast.next != null && fast.next.next != null){
        slow=slow.next;
        fast=fast.next.next;
    }
    //reversing the second half of the linkedList
    fast = reverse(slow);
    //reinitializing the slow to head
    slow=head;
    //using temp node to reorder the list
    ListNode temp=slow.next;
    
    while(temp != null ){
        slow.next = fast; 
        fast = fast.next;
        slow.next.next=temp;
        slow=temp;
        temp=slow.next;
    }
    slow.next=fast;
}

private ListNode reverse(ListNode mid){
    if(mid.next==null) return mid;
    ListNode prev=null;
    ListNode curr = mid.next;
    ListNode next = curr.next;
    mid.next = null;
    
    while(next != null){
        curr.next = prev;
        prev=curr;
        curr=next;
        next=next.next;
    }
    curr.next=prev;
    
    return curr;
}