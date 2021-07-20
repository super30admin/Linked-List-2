// Time Complexity : O(N) N-> No of Nodes both in List (M+N)
// Space Complexity : O(N)  N-> No of Nodes in List
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using Hashset
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        Set x = new HashSet<>();

        while(a != null) {
            x.add(a);
            a = a.next;
        }

        while(b != null) {
            if(x.contains(b))
                return b;
            else
                b = b.next;
        }

        return null;

}

// Time Complexity : O(N) N-> No of Nodes both in List (M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// without extra space
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int m = 0;
        ListNode a = headA;

        // count the no of nodes in list 1
        while(ha != null) {
            m++;
            ha = ha.next;
        }

        int n = 0;
        ListNode b = headB;

        // count the no of nodes in list 2
        while(hb != null) {
            n++;
            hb = hb.next;
        }

        a = headA;
        b = headB;

        // move pointers a or b as per the larger list until the count of nodes is equal
        if(m>n) {
            while(m!=n) {
                 m--;
                 a = a.next;
           }
        } else {
             while(m!=n) {
                 n--;
                 b = b.next;
           }
        }

        while(a != b) {
          a = a.next;
          b = b.next;
        }

        return a;

        }
}