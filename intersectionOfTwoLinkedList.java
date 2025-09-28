/**
TC: O(n+m) n: lenght of list1, m: length of list2.
SC: O(1)
Approach: Initially, find length of both lists.now again for the list whos length is larger , start from the head and just move until it match the size of the other list. now keep moving each pointer by one step and at each iteration check if its equal or not.
 */

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
public class intersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = 0;
        int size2 = 0;
        
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;

        while(dummy1 != null){
            size1++;
            dummy1 = dummy1.next;
        }

         while(dummy2 != null){
            size2++;
            dummy2 = dummy2.next;
        }

        while(size1 < size2){
                size2--;
                headB = headB.next;
            }
        while(size1 > size2){
                size1--;
                headA = headA.next;
        }
        

        while(true){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
    //return null;
    }
}