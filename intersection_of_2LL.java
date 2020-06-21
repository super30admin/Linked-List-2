// Time Complexity :O(m+n) m-number of nodes in headA n-number of nodes in headB
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :-
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode temp=headA;
        ListNode temp2=headB;
        int length=0,length2=0;
      while(temp!=null)
      {
        temp=temp.next;
        length++;
    
      }
      while(temp2!=null)
      {
        temp2=temp2.next;
        length2++;
    
      }
      while(length<length2)
      {
          headB=headB.next;
          length2--;
      }
     while(length2<length)
      {
          headA=headA.next;
          length--;
      }
     while(headA!=headB)
     {
      headA=headA.next;   
      headB=headB.next;
        
     }
     return headA;

    }
}
//BruteForce
/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       HashSet<ListNode> map=new  HashSet<ListNode>();
        while(headA!=null)
        {
            map.add(headA);
            headA=headA.next;
            
        }
        while(headB!=null)
        {
            if(map.contains(headB))
                return headB;
            headB=headB.next;
        }
        
       
        return null;
    }
}
*/