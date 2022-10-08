//B-F approach -
// 1. traverse first list and push node to the Set. 
// 2/ traverse second list and check if that node exist into the set and then return if exist , if not null
// TC- O(n) + O(n)
// sc - O(n) -set

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
        if(headA== null || headB == null) return headA;
        
        Set<ListNode> set = new HashSet<>();
        
        //traverse through a
        ListNode curr = headA;
        while(curr != null )
        {
            set.add(curr);
            curr = curr.next;
        }
        curr= headB;
        
        while(curr != null)
        {
            if(set.contains(curr))
            {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}



//approach - 2 ,optimize with O(1) space
//calculate length of 1st linked list lenA and 2nd lenB.
//take the difference  whoever's len is bigger, taverse into that list for the 'difference'
//once travelled till difeerence, now start tavelling through both the list together and check for the node.next are equal.
//TC - O(n) +O(n)
//sc -O(1)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA== null || headB == null) return null;

        int lenA =0, lenB =0;
        ListNode curr = headA;
        while(curr!=null)
        {
            lenA++;
            curr = curr.next;
        }

        curr = headB;
        while(curr!=null)
        {
            lenB++;
            curr = curr.next;
        }
        int diff =diff =  lenA - lenB;;
        
            while(diff >0)
            {
                headA = headA.next;
                diff--;
            }
            while(diff < 0)
            {
                headB = headB.next;
                diff++;
            }
        
            //so here headA and headB will be pointing to equal difference
            while(headA != headB)
            {
                headA = headA.next;
                headB =headB.next;
            }
            return headA;
    
    }
}