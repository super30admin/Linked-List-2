// Approach 1
// TC: O(m+n) where m is the length of list A and n is the length of list B
// SC: O(1)

// Approach 2
// TC: O(m+n) where m is the length of list A and n is the length of list B
// SC: O(1)

// Approach 1
public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode h1 = headA, h2 = headB;
        while(h1!=null){
            h1=h1.next;
            len1++;
        }
        while(h2!=null){
            h2=h2.next;
            len2++;
        }
        
        h1=headA;
        h2=headB;

        while(len1>len2){
            h1=h1.next;
            len1--;
        }

        while(len2>len1){
            h2=h2.next;
            len2--;
        }

        while(h1!=null && h2!=null && h1!=h2){
            h1=h1.next;
            h2=h2.next;
        }

        return h1;
    }
}

// Approach 2: Floyd's Cycle Algorithm
class LC160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB)
            return headA;
        ListNode hpA = headA, hpB = headB, tp = headA;
        while (tp.next != null) {
            tp = tp.next;
        }
        // Forming a cycle to apply Floyd's Cycle Algorithm
        tp.next = headB;
        ListNode sp = headA, fp = headA;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (fp == sp)
                break;
        }
        if (fp == null || fp.next == null) {
            tp.next = null;
            return null;
        }
        ListNode np = fp;
        sp = headA;
        while (np != sp) {
            sp = sp.next;
            np = np.next;
        }
        tp.next = null;
        return np;
    }
}