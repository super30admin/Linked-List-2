// Approach : (1) - identify the length of linked lists
// (2) - move the pointer on the bigger linked list
// (3) - start from a equidistance position(knowing the difference between the length of both LL)
// (4) - finally find the intersection point

// Time: O(m+n) + O(m+n) --> O(m+n)
// one pass to find the length of LL
// second pass to find the intersection point

// Space: O(1), no extra space needed

// Yes the code successfully ran over leetcode


class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int countA = 0;
        int countB = 0;

        ListNode currA = headA, currB = headB;

        while(currA != null){
            countA++;
            currA = currA.next;
        }

        while(currB != null){
            countB++;
            currB = currB.next;
        }

        currA = headA; currB = headB;

        while(countA > countB){
            currA = currA.next;
            countA--;
        }

        while(countB > countA){
            currB = currB.next;
            countB--;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
        
    }
}