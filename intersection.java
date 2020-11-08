//Time Complexity: O(n) | n is the length of the bigger linked list
//Space Complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. We find the lengths of both linked lists
               2. Difference is calculated and the starting points of both the lists are made same
               3. Then we iterate through both linked lists and find the common point
*/
public class intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLength(headA);
        int lenB = findLength(headB);
        int diff = 0;
        if(lenA > lenB){
            diff = lenA - lenB;
            return intersection(headA, headB,diff);
        }else{
            diff = lenB - lenA;
            return intersection(headB, headA,diff);
        }
        
    }
    private int findLength(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }
    private ListNode intersection(ListNode bigHead, ListNode smallHead,int diff){
        int count = 0;
        while(count < diff){
            bigHead = bigHead.next;
            count++;
        }
        while(bigHead != null){
            if(bigHead == smallHead) return bigHead;
            bigHead = bigHead.next;
            smallHead = smallHead.next;
        }
        return null;
    }
}
