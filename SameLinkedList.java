//Time complexity: O(n)
//Space complexity: O(1)
//Executed on leetcode.

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
        ListNode a = headA;
        ListNode b = headB;
        int aLen =0, bLen =0;
        while(a!=null)
        {
            a=a.next;
            aLen++;
        }
        
        while(b!=null)      //Finds the length of both lists.
        {
            b=b.next;       //As lengths diff lists cannot be same. So, longest list will be traversed till the remaining length is same as the other.
            bLen++;			
        }
        a = headA;
        b = headB;          //Now compare the rest of list and return if equal
        
        if(aLen>bLen)
        {
            while(aLen!=bLen)
            {
                a = a.next;
                aLen--;
            }                
            
        }
        else
        {
            while(aLen!=bLen)
            {
                b = b.next;
                bLen--;   
            }           
        }
        while(a!=null)
        {
            if(a==b)
                return a;
            a = a.next;
            b = b.next;
        }
        
        /*while(a!=null)
        {
            for(b=headB;b!=null;b=b.next)
            {
                if(a==b)
                {
                    return a;
                }
                
            }
            a=a.next;
        }
       return a;*/
        
    return null;
    }
}