package s30.linkedList.linkedList2;

import s30.linkedList.ListNode;


//Time Complexity O(n);
// Space Complexity O(1);
public class IntersectionList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = getSize(headA);
        int lengthB = getSize(headB);

        if(lengthB > lengthA)  return getIntersectionNode(headB, headA);

        int diff = lengthA - lengthB;

        while(diff > 0){
            headA = headA.next;
            diff--;
        }

        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA= headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getSize(ListNode node){
        int count =0;

        while(node != null){
            node = node.next;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {

    }
}
