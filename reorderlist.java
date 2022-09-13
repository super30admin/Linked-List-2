/* 
Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution
{
    public void reorderList(ListNode head) 
    {
       
        if (head == null || head.next == null)
            return;
      
        ListNode middle = getMiddle(head);
        ListNode second = reverseLinkedList(middle);
        ListNode first = head;
        ListNode nextNode;
        
        while(second.next != null)
        {
            nextNode = first.next;
            first.next = second;
            first = second;
            second = nextNode;
        }
    }
    
    public ListNode getMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseLinkedList(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next_node;
        
        while(cur != null)
        {
            next_node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_node;
        }       
        return prev;
    }
}