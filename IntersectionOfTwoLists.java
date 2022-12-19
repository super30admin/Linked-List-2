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
        int aCount = 0;
        int bCount = 0;
        ListNode curr = headA;

        while( curr != null){
            curr = curr.next;
            aCount++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            bCount++;
        }
       
            while(aCount > bCount){
                headA = headA.next;
                aCount--;
            }
              
                while(bCount > aCount){
                    headB = headB.next;
                    bCount--;
                }
            

            
                while(headA != headB){
                    headA=headA.next;
                headB=headB.next;
                }
                
            
      return headA;

/**
//Using HashSet
HashSet<ListNode> list = new LinkedList<>();
    ListNode curr = headA;

    while(curr != null){
        if(!list.contains(curr)){
            list.add(curr);
            curr = curr.next;
        }
    }

    while(headB != null){
        if(list.contains(headB)){
            return headB;
        }
    }
return null;
 */
    
    }
}


/**
TC - O(n),
SC - O(1)
 Approach : 
 First finding the length of Linked List 1 and Linked List 2. First starting the head of larger linked list and equalling the length of both Linked Lists 1 & 2. From here by comparing headA with headB we can find the Intersection.

 */


