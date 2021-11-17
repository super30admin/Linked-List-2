// 160 Intersection of Two Linked Lists 
// solved on Leetcode
// Time complexity -- O(n)
// Space complexity -- O(1)


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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two= headB;
        int countOne=0;
        int countTwo=0;
        while(one!=null){
            countOne++;
            one=one.next;
        }
        while(two!=null){
            countTwo++;
            two=two.next;
        }
        System.out.println(countOne);
        System.out.println(countTwo);
        int diff=0;
        if(countOne > countTwo){
            diff=countOne-countTwo;
            one=headA;
            two=headB;
            while(diff!=0){
                one=one.next;
                diff--;
            }
        }else{
            diff=countTwo - countOne;
            two=headB;
            one=headA;
            while(diff!=0){
                two=two.next;
                diff--;
            }
        }
        
        while(one!=null && two!=null){
            if(one==two){
                return one;
            }
            one=one.next;
            two=two.next;
        }
        return null;
    }
}
