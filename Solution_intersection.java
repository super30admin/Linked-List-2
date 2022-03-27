/*
// Time Complexity :  O(m) + O(n)  where m is the size of the headA and n is the size of the headB.
// Space Complexity : O(1) we are not using any auxillary data structure.
// Did this code successfully run on Leetcode : Yes



// Your code here along with comments explaining your approach
  */  
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution_intersection {
    

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // created dummy for only one node
        ListNode dummy = new ListNode(-1);
        
         ListNode first = headA;
        ListNode sec = headB;
        
        int asize = 0;
        int bsize = 0;
        
        while(headA != null) {
            // counting the length of the headA list
            asize++;
            headA = headA.next;
        }
        
        while (headB != null) {
                // counting the length of the headB list
            bsize++;
            headB = headB.next;
        }
        
       
        //  checking which length is bigger so increment till the length is same.
        if(asize > bsize) {
            
            while(asize != bsize) {
             
                first = first.next;
                asize--;
            }
        }
        else if(asize < bsize){
               
            while(asize != bsize) {
             
                sec = sec.next;
                bsize--;
                
        }
            
        }
        // checking for the intersection
        
        while(first!= null ) {
            
            if(first == sec) {
                // returing the intersection node.
                return first;
            }
            first = first.next;
            sec = sec.next;
          }
        
        return dummy.next;
    }
}

