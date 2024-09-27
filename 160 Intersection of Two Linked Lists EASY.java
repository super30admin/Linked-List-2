//160 Intersection of Two Linked Lists EASY.java
// Time Complexity: O(n)
// Space Complexity: O(1)
//Time take to code: 10 min
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
        
        
        //check which list is larger
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int count1 = 0;
        int count2 = 0;
        
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }
        
        ListNode largerHead;
        ListNode smallerHead; 
        if(count1 > count2){
            largerHead = headA;
            smallerHead = headB;
        } else {
            largerHead = headB;
            smallerHead = headA;
        }
        int diff = Math.abs(count1 - count2);
        //skip number of elements eqauls to length diff of both lists
        
        while(diff > 0){
            diff--;
            largerHead = largerHead.next;
        }
        
        //now compare parallelly
        while(largerHead != smallerHead){
            largerHead = largerHead.next;
            smallerHead = smallerHead.next;
        }
        
        return largerHead;
    }
}
    