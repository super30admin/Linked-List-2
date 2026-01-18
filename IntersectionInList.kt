//In this problem, we first calculate length of both linked lists. We then move the pointer of longer list by the difference in lengths.
// Then we move both pointers one step at a time until they meet.
// Time Complexity: O(m+n) where m and n are the lengths of the two linked lists
// Space Complexity: O(1) we are not using any extra space

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if(headA == null && headB == null) return null
        var countA = 0
        var countB = 0

        var currA = headA
        var currB = headB

        while(currA != null) {
            countA++
            currA = currA.next
        }

        while(currB != null){
            countB++
            currB = currB.next
        } 

        currA = headA
        currB = headB

        while(countA > countB && currA != null) {
            currA = currA.next
            countA--
        }

        while(countB > countA && currB != null) {
            currB = currB.next
            countB--
        }

        while(currA != null && currB != null && currA != currB) {
            currA = currA.next
            currB = currB.next
        }

        return currA
    }
}