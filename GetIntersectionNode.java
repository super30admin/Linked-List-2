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
// Time Complexity: O(n)
// Space Complexity: O(1)
//160. Intersection of Two Linked Lists
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Now the idea is to find the length of the common part of ListA and ListB. Say that length be 'len'.
        // Now take 2 pointers, we put then at heads of each list. Then , for the list with longer length, we move its pointer by 'len' places.
        //Then move both pointers simultaneously, 1 step at a time. Check if the pointers are equal. if yes , return that node.
        
        if(headA==null || headB==null)
            return null;
        int m=0,n=0;
        ListNode a=headA;
        ListNode b=headB;
        
        while(a!=null)
        {
            m++;
            a=a.next;
        }
         while(b!=null)
        {
            n++;
            b=b.next;
        }
        
       
        while(m>n)
        {
            headA=headA.next;
            m--;
        }
         while(n>m)
        {
            headB=headB.next;
             n--;
        }
        // At this point both the pointers of listA and listB are at the same distance from the end;
        while(headA!=null && headB!=null && headA!=headB)
        {
            
            headA=headA.next;
            headB=headB.next;
             
        }
        return headA;
        
    }
}

/*

// Using HashSet
// Time Complexity: O(m+n), where m and n are lengths of ListA and ListB respectively
// Space Complexity: O(m) 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> set=new HashSet<>();
        ListNode a=headA;
        ListNode b=headB;
        
        while(a!=null )
        {
            set.add(a);
            a=a.next;
        }
        
        
        while(b!=null)
         {
              if(set.contains(b))
                  return b;
              b=b.next;
          }
        
       
        return null;
        
    }
}
*/