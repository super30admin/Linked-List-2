// Time Complexity : O(N+M)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//find the length of each list and find difference
//place the longest length list pointer after n difference node
//iteate both the pointers when equal retrun
class ListNode1 {
    int val;
    ListNode1 next;

    public ListNode1() {
        // Default constructor
    }

    public ListNode1(int val) {
        this.val = val;
    }

    // Constructor with int and ListNode parameters
    public ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}

public class IntersectionNode {
  
    public ListNode1 getIntersectionNode(ListNode1 headA, ListNode1 headB) {
        ListNode1 point1 = headA;
        ListNode1 point2 = headB;
        int lenA = 0;
        int lenB = 0;

        if (headA == null || headB == null) return null;

        while (point1 != null) {
            lenA++;
            point1 = point1.next;
        }

        while (point2 != null) {
            lenB++;
            point2 = point2.next;
        }

        point1 = headA;
        point2 = headB;

        if (lenA > lenB) {
            int n = lenA - lenB;
            for (int i = 0; i < n; i++) {
                point1 = point1.next;
            }
        }

        if (lenB > lenA) {
            int n = lenB - lenA;
            for (int i = 0; i < n; i++) {
                point2 = point2.next;
            }
        }

        while (point1 != point2) {
            point1 = point1.next;
            point2 = point2.next;
        }

        return point1;
    }

    public static void main(String[] args) {
        // Creating sample linked lists
        ListNode1 commonNode = new ListNode1(8);
        ListNode1 headA = new ListNode1(4, new ListNode1(1, commonNode));
        ListNode1 headB = new ListNode1(5, new ListNode1(6, new ListNode1(1, commonNode)));

        // Creating an instance of IntersectionNode
        IntersectionNode solution = new IntersectionNode();

        // Finding the intersection node
        ListNode1 intersectionNode = solution.getIntersectionNode(headA, headB);

        // Printing the result
        if (intersectionNode != null) {
            System.out.println("Intersection Node Value: " + intersectionNode.val);
        } else {
            System.out.println("No Intersection Node");
        }
    }
}
