//https://leetcode.com/problems/intersection-of-two-linked-lists/
// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//iterated to the node such that length of both lists will be same then check
//each node and see if they are same
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> visitedA = new HashSet<>();
//        ListNode temp =headA;
//        while(temp!=null){
//         visitedA.add(temp);
//         temp=temp.next;
//        }
//        temp=headB;
//        while(temp!=null){
//         if(visitedA.contains(temp)) return temp;
//         temp=temp.next;
//        }
//        return null;
//     }
// }

public class Solution {
    private ListNode matchLists(ListNode head, int diff){
        int i=0;
        while(i<diff){
            head=head.next;
            i++;
        }
        return head;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode temp =headA;
       int lenA=0;
       while(temp!=null){
        temp=temp.next;
        lenA++;
       }
       temp=headB;
       int lenB=0;
       while(temp!=null){
        lenB++;
        temp=temp.next;
       }
       ListNode tempA =headA;
       ListNode tempB=headB;
       if(lenA>lenB) tempA=matchLists(headA, lenA-lenB);
       else if(lenA<lenB) tempB=matchLists(headB, lenB-lenA);
       while(tempA!=null&&tempB!=null){
        if(tempA==tempB) return tempA;
        tempA=tempA.next;
        tempB=tempB.next;
       }
       return null;
    }
}