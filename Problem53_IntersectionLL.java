//USING 2 POINTER
/***************** Time Complexity: O(m+n) ********************/
/***************** Space Complexity: O(1) ********************/

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
        //base case
        if(headA == null && headB==null)
            return null;
        //pointers pointing to the head of 2 lists
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        // continue till ptrA = ptrB 
        while (ptrA != ptrB) {
            
            if(ptrA == null){
                //if is null -> pointer moves to headB
                ptrA = headB;
            }else{
                // if not null -> moves to the next element
                ptrA = ptrA.next;
            }
            
            if(ptrB == null){
                //if is null -> pointer moves to headB
                ptrB = headA;
            }else{
                // if not null -> moves to the next element
                ptrB = ptrB.next;
            }
        }
        //or ptrB since they pointing to the same element
        return ptrA;
    }
}

/******************************************************************************* */
/******************************************************************************* */
/******************************************************************************* */


//USING HASHSET
/******************** Time Complexity: O(m+n) ~ O(n) **********************/
/******************** Space Complexity: O(n) **********************/

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
        
        //creating set to store the list and compare with existing pointers
        HashSet<ListNode> set = new HashSet<ListNode>();
        // base case
        if(headA == null && headB == null)
            return null;
        
        while(headA != null || headB != null)
        {
            if(headA != null)
            {
                //if exists in set
                if(set.contains(headA))
                {
                    // return since is the intersection
                    return headA;
                }
                else
                {
                    //add to the set as it doesnot exists
                    set.add(headA);
                }
                // consider the next element of the list
                headA = headA.next;
            }
            
            if( headB != null)
            {
                //if exists in set
                if(set.contains(headB))
                {
                    // return since is the intersection
                    return headB;
                }
                else
                {
                    //add to the set as it doesnot exists
                    set.add(headB);
                }
                // consider the next element of the list
                headB = headB.next;
            }
        }
        return null;
    }
}