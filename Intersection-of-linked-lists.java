// Solution -1

// TimeComplexity: O(m+n)
// SpaceComplexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        int m =0;
        int n =0;
        while(first !=null) {
            m++;
            first = first.next;
        }
        while(second !=null) {
            n++;
            second = second.next;
        }
        if(m>n) {
            for(int i=0; i<m-n; i++) {
                headA=headA.next;
            }
        } else {
            for(int i=0; i<n-m; i++) {
                headB=headB.next;
            }
        }

        while(headA!=null) {
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}


// Solution -2 


// TimeComplexity: O(m+n)
// SpaceComplexity: O(m+n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null) {
            set.add(headA);
            headA= headA.next;
        }

        while(headB!=null) {
            if(set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB= headB.next;
        }
        return null;
        
    }
}
