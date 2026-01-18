// In this poblem, we first find the middle by moving the slow pointer by 1 and fast pointer by 2. Then we reverse second half of the list. we then merge the two list in zig zag order
// Time Complexity: O(n) where n is the number of nodes in the linked list
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
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return

        var slow : ListNode? = head
        var fast : ListNode? = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next.next
        }

        val reverseHead = reverseList(slow?.next)
        slow?.next = null

        fast = reverseHead
        slow = head

        //merge
        while(fast != null) {
            var temp = slow?.next
            slow?.next = fast
            fast = fast.next
            slow?.next?.next = temp
            slow = temp
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        var prev : ListNode? = null
        var curr = head

        while(curr != null) {
            var temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    } 
}