// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public void ReorderList(ListNode head) {
        
    if(head == null || head.next == null)
        return;
    
    //find middle of linked list
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast.next != null && fast.next.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    //reverse the fast list
    fast = reverse(slow.next);
    
    //split into two parts
    slow.next = null;
    
    //merge two parts
    slow = head;
    ListNode temp = null;
    //now take one node from slow, point to fast
    //then point fast node to sloe next node and so on
    while(fast != null)
    {
        temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }
}

//reverse the linked list
private ListNode reverse(ListNode node)
{
    if(node == null || node.next == null)
        return node;
    
    ListNode curr = node;
    ListNode prev = null;
    ListNode fast = node.next;
    
    while(fast != null)
    {
        curr.next = prev;
        prev = curr;
        curr = fast;
        fast = fast.next;
    }
    
    curr.next = prev;
    return curr;
}