//Time Complexity : O(max(m, n))
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
//}

class Intersection_of_Two_LinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        
        while(currA != null)
        {
            lengthA++;
            currA = currA.next;
        }
        
        while(currB != null)
        {
            lengthB++;
            currB = currB.next;
        }
        
        while(lengthA > lengthB)
        {
           headA = headA.next;
           lengthA--;
        }
        while(lengthB > lengthA)
        {
           headB = headB.next;
           lengthB--;
        }
        
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
