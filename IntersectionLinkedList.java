// Time Complexity : O(MN)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : can reduce the time complexity but not sure about the algo


// Your code here along with comments explaining your approach



//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }



}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    //Taking 2 temp temp1 temp2 for 2 lists
//        ListNode temp1 = headA;
//        ListNode temp2 = headB;
//    //corner cases
//        if (temp1 == null || temp2 == null) return null;
//
//        //if the elements are not same iterate over the lists
//        while (temp1 != null && temp2 != null && temp1 != temp2) {
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//            //if intersection is found, return either temp1 or temp2
//            if (temp1 == temp2) return temp1;
//
//            //if either end is reached then we can start again from the other list
//            if (temp1 == null) temp1 = headB;
//            if (temp2 == null) temp2 = headA;
//        }
//        return temp1;



        int lenA = 0;
        int lenB =0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1.next != null){
            lenA++;
        }

        while(temp2.next != null){
            lenB++;
        }

        while(lenA != lenB){
            if(lenA > lenB){
                lenB++;
            }else {
                lenA++;
            }

            if (temp1 == temp2) return temp1;
        }



    }
}


