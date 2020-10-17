//Time complexity: O(n)
//Space complexity: O(1)
//Tried on Leetcode and was accepted 
//Number of attempts: 3
class Solution {
    public void reorderList(ListNode head) {
        if(head ==null) return;
        ListNode slow = head;
        ListNode fast = head;
        //1-2-3-4-5-6-null middle value at 4
        while(fast!=null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
       //1-2-3-4-5-6-null becomes 1-2-3-4-Null 5-6-null
        ListNode temp = slow.next;
        slow.next = null;
        ListNode cur = temp;
        ListNode prev = null;
        ListNode next;
        
        //1-2-3-4-Null 5-6-null becomes 1-2-3-4-Null 6-5-null
        while(cur!=null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //1-2-3-4-Null 6-5-null becomes 1-6-2-5-3-4
        temp = prev;
        while(temp!=null)
        {
            ListNode temp1 = head.next;
            head.next = temp;
            head = temp1;
            ListNode temp2 = temp.next;
            temp.next = temp1;
            temp = temp2;
        }
    }
}