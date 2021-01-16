//Problem 55: Intersection of Two Linked Lists
// Time Complexity : O(n+m), n & m number of nodes in linkedlist 1 & 2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Steps : Bruteforce: TC:O(n+m), SC: O(n+m) : Use Concept of Hashing which is HashSet. Add all nodes of linkelist 1 in set. Then while adding nodes of linkedlist 2, just check whether that node exists in the set or not, if it exists(both the nodes will point to the same reference) then just return that node.

        Optimized : 1) Calculate length of both the list
                    2) Now which ever linkedlist length is greater just move start pointer on that list until both the linked list length become equal.
                    3) Then, just traverse over both the linked list until nodes on bothe the list are not equal. Once they are equal just return that node.  

*/
  class IntersectionOfLinkedList {
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null){
            return null;
        }
        
        //TC: O(N), SC:O(1)
        int lenA=0;int lenB=0;
        
        ListNode currA = headA;
        while(currA!=null){
            lenA++;
            currA = currA.next;
        }
        
        ListNode currB = headB;
        while(currB!=null){
            lenB++;
            currB = currB.next;
        }
        
        currA = headA;
        currB = headB;
        
        while(lenA>lenB){
          currA = currA.next;
          lenA--;
        }
        
        while(lenB>lenA){
          currB = currB.next;
          lenB--;
        }

        
        while(currA!=currB){
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA;
    }
    
    
    /* Brute Force - Using HashSet
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null){
            return null;
        }
        
        Set<ListNode> visited = new HashSet<>();
        
        ListNode currA = headA;
        
        while(currA!=null){
            visited.add(currA);
            currA = currA.next;
        }
        
        ListNode currB = headB;
        
        while(currB!=null){
            
            if(visited.contains(currB)) return currB;
            
            visited.add(currB);
            currB = currB.next;
        }
        
        return null;
    }*/
}

