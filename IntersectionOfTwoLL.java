// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// First, we calculate the lengths of both linked lists (list A and list B).
// Then, we move the pointer of the longer list forward by the difference in lengths
// so both pointers are equidistant from the end.
// We then move both pointers together one node at a time.
// When they meet, that node is the intersection point.
// If they reach the end (null) without meeting, there is no intersection.




class ListNode {
    int val;
    ListNode next;
    ListNode (int x){
        val=x;
        next = null;
    }
}

public class IntersectionOfTwoLL {
    public ListNode solve(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }

        int lenA = 0;
        ListNode currA = headA;
        while(currA != null){
            lenA++;
            currA = currA.next;
        }
        int lenB = 0;
        ListNode currB = headB;
        while(currB != null){
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        while(lenA > lenB){
            currA = currA.next;
            lenA--;
        }
        currB = headB;
        while(lenB>lenA){
            currB = currB.next;
            lenB--;
        }

        while(currA!=currB){
            currA=currA.next;
            currB=currB.next;
        }
        return currA;


    }
     public static void main(String[] args) {
        
        ListNode intersect = new ListNode(2);
        intersect.next = new ListNode(4);

       
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = intersect;

        ListNode headB = new ListNode(3);
        headB.next = intersect;

        IntersectionOfTwoLL ob = new IntersectionOfTwoLL();
        ListNode result = ob.solve(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }

    }
    
}
