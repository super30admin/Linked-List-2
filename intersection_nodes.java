// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

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
// two pointer soution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        int a = 0;
        int b = 0;
        while(ptr1 != null){
            ptr1 = ptr1.next;
            a++;
        }
        while(ptr2 != null){
            ptr2 = ptr2.next;
            b++;
        }
        ptr1 = headA; ptr2 = headB;
        while(a > b){
            ptr1 = ptr1.next;
            a--;
        }
        while(b > a){
            ptr2 = ptr2.next;
            b--;
        }
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}

/*
// using hash map O(n) time complexity O(n) space complexity
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        if(headA == headB)
            return headA;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(headA != null){
            map.put(headA, headA.val);
            headA = headA.next;
        }
        while(headB != null){
            if(map.containsKey(headB))
                return new ListNode(map.get(headB));
            headB = headB.next;
        }
        return null;
    }
}
*/