// Time complexity - O(n+m) where n is the number of nodes in HeadA list and m is the number of nodes in HeadB
// Space Complexity - O(1) since we are not creating any new list. 
// This solution worked on LeetCode

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        while(temp != null){    // find the length of ListA
            lenA += 1;          
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){    // find the length of ListB
            lenB += 1;
            temp = temp.next;
        }
        while(lenA > lenB){       // If listA length is greater than listB then move those many nodes ahead and decrementing the lenA
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){       // If listB length is greater than listA then move those many nodes ahead and decrementing the lenB
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){     // move the headA and headB now until the node becomes equal and return that node in the end
            headA = headA.next;
            headB = headB.next;
        }
        return headA;       // return headA or headB
    }
}
