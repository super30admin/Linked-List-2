// Time Complexity : O(m+n) where m and n are lengths of the lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fir = headA;
        ListNode sec = headB;
        int lenA = len(headA);
        int lenB = len(headB);
        if(lenB > lenA){
            fir = headB;
            sec = headA;
        }
        int dif = Math.abs(lenA - lenB);
        while(dif != 0){
            dif--;
            fir = fir.next;
        }
        while(fir != sec){
            fir = fir.next;
            sec = sec.next;
        }
        return fir;
    }
    private int len(ListNode x){
        int size = 0;
        while(x != null){
            size++;
            x = x.next;
        }
        return size;
    }
}