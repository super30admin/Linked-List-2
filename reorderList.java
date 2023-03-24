/**
 * Time Complexity - O(n) where n is the size of the list.
 * Space Complexity - O(1)
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;

        //find length of list.
        int len = 0;
        ListNode itr = head;
        while(itr != null) {
            len++;
            itr = itr.next;
        }

        //find mid element.
        int mid = len / 2;
        
        //split linkedlist. set tail of list1 to null.
        itr = head;
        while(mid -- > 0)
            itr = itr.next;
        ListNode list1 = head, list2 = itr.next;
        itr.next = null;

        //reverse list2.
        ListNode temp = null, prev = null;
        while(list2 != null){
            temp = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = temp;
        }
        list2 = prev;

        //merge list 1 and 2.
        while(list1 != null && list1.next != null && list2 != null){
            temp = list1.next;
            list1.next = list2;
            list2 = list2.next;
            list1.next.next = temp;
            list1 = list1.next.next;
        }
        
    }
}
