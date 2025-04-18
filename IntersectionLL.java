import java.lang.classfile.components.ClassPrinter.ListNode;
//TC: O(n+m)
 //SC: O(1)
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // int countA = 0, countB = 0;

        ListNode currA = headA, currB = headB;
        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null) return null;
            if(currA == null){
                currA = headB;
            }
            if(currB == null){
                currB = headA;
            }
        }

        return currA;
        
    }
}