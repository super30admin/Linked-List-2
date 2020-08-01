//Time Complexity:O(lenA + lenB)
//space complexity:O(1)
/*Approach
-finding the length of both the lists
-placing pointers in both the list according to the difference in their length
-moving both the pointers one by one and they will meet at the intersection point,because they started
from same point considering difference in length
 */
public class IntersectionInList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
   }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;

        ListNode curr = headA;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }
        while(lenA > lenB){
            a = a.next;
            lenA--;
        }
        while(lenB > lenA){
            b = b.next;
            lenB--;
        }
        while(a !=b){
            a=a.next;
            b=b.next;
        }

        return a;
    }
    public static void main(String args[]){
        ListNode newNode = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        newNode.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        
        n5.next = n6;
        n6.next = n3;

        IntersectionInList obj = new IntersectionInList();
        ListNode intersection = obj.getIntersectionNode(newNode, n5);
        System.out.println(intersection.val);

    }
}