//Intersection of Two LinkedList
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/*
find the length of both the linkedlist. traverse the difference with either of the nodes and that
will be the node of intersection
*/


// Your code here along with comments explaining your approach
public class Problem4 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode b = new ListNode(6);
        b.next = new ListNode(8);
        b.next.next = new ListNode(9);
        b.next.next.next = head.next.next.next;
        b.next.next.next.next =  head.next.next.next.next;
        Problem4 p = new Problem4();
        ListNode res = p.getIntersectionNode(head, b);
        
        while(res != null){
            System.out.print(" " +res.val);
            res = res.next;

        }

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        
        while(currA != null){
            lenA++;
            currA = currA.next;
        }
        // System.out.println(lenA);
        
        while(currB != null){
            lenB++;
            currB = currB.next;
        }
        // System.out.println(lenB);
        //now change the currA to head of node A
        currA = headA;
        currB = headB;
        if(lenA > lenB){
            int diff = lenA - lenB;
            while(diff>0){
                currA = currA.next;
                diff--;
                
            }
        }
        ///if listnode b was greater
        else{
            int diff = lenB - lenA;
            while(diff>0){
                currB = currB.next;
                diff--;
                
            }
            
        }
        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
        
        
    }


    
}
