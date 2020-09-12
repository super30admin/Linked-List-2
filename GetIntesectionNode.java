//Time Complexity: O(n2) where n is the distance to reach the intersection
//Space complexity: O(1)
public class GetIntesectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {       
        ListNode bkp = headB;

        //iterate headA until we encounter null
        while(headA != null){
            //iterate headb until null is encountered
            while(headB != null){
                //check if heada and headb are equal 
                if(headA == headB){
                    return headA;
                }
                //else iterate headb
                headB = headB.next;
            }
            //bring headb again to its previous state
            headB = bkp;
            //iterate heada
            headA = headA.next;
        }
        return null;       
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}