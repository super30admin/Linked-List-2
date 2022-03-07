// space complexity - o(1)
//time - o(n) where n is length of linked list
//Ran on Leetcode successfully : Yes
// Problem faced  : No
// Iterative approach : Two pointer, find differnce in length of two lists, move pointer in big list by diff, then move both pointers

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1  = getListLength(headA) ;
        int l2  = getListLength(headB) ;

        ListNode big = null;
        ListNode small = null;

        if(l1 >= l2){
            big = headA;
            small = headB;
        }
        else{
            big = headB;
            small = headA;
        }

        int diff = Math.abs(l1-l2);

        while(diff > 0){
            big = big.next;
            diff--;
        }

        while(big != null && small != null && big != small){
            big = big.next;
            small = small.next;
        }
        return big;

    }

    public int getListLength(ListNode head){
        int res = 0;
        while(head != null){
            head = head.next;
            res++;
        }
        return res;
    }


}