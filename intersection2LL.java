// tc : O max(m,n)
// sc : O max(m,n)
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
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        // boolean flag = true;
        HashSet<ListNode> seta = new HashSet<>();
        HashSet<ListNode> setb = new HashSet<>();

        while(true){
            seta.add(a);
            if(setb.contains(a)) return a;
            setb.add(b);
            if(seta.contains(b)) return b;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        // return null;
    }
}
