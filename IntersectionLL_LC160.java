/**
T: O(n) find size for listA  + O(n) find size for listb  + O(n) - find intersection==> O(n)
S: O(1) no extra space;

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
        if(headA == null || headB == null)
            return null;
        
        int sizeA = 0;
        int sizeB = 0;
        
        ListNode listA = headA;
        ListNode listB = headB;
        
        while(listA != null){
            sizeA++;
            listA = listA.next;
        }
         
        while(listB != null){
            sizeB++;
            listB = listB.next;
        }
            
        listA = headA;
        listB = headB;
        //advance the pointer for the list which is larger
        if(sizeA >= sizeB){
            while(sizeA != sizeB){
                listA = listA.next;
                sizeA--;
            }
        }
        else if(sizeA <= sizeB){
            while(sizeA != sizeB){
                listB = listB.next;
                sizeB--;
            }
        }
        
        //now check for each node if it is equal 
        while(listA != null || listB != null){
            if(listA == listB){
                break;
            }
            listA = listA.next;
            listB = listB.next;
        }
        
        return listA;
    }
}