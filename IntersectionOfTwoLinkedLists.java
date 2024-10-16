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

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0, lengthB=0;
        ListNode cur = headA;
        ListNode interesectionNode = new ListNode();
        while(cur!=null){
            lengthA++;
            cur=cur.next;
        }
        cur = headB;
        while(cur!=null){
            lengthB++;
            cur=cur.next;
        }

        if(lengthA>lengthB){
            ListNode curA = headA;
            ListNode curB = headB;
            int count = lengthA-lengthB;
            while(count>0){
                count--;
                curA=curA.next;
            }
            while(curA!=null && curB!=null){
                if(curA==curB){
                    return curA;
                }
                curA=curA.next;
                curB=curB.next;
            }
            return null;
        }else{
                ListNode curA = headA;
                ListNode curB = headB;
                int count = lengthB-lengthA;
                while(count>0){
                    count--;
                    curB=curB.next;
                }
                while(curA!=null && curB!=null){
                    if(curA==curB){
                        return curA;
                    }
                    curA=curA.next;
                    curB=curB.next;
                }
                return null;
        }
    }
}

//Time Complexity : O(2n);
//Space Complexity : O(1);