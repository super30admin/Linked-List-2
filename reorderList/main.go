/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// time: o(n)
// space: o(1)
func reorderList(head *ListNode)  {
    if head == nil || head.Next == nil {return }
    slow := head
    fast := head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    p2 := reverse(slow.Next)
    slow.Next = nil
    
    p1 := head
    
    // why isnt this p1 != nil && p2 != nil ?
    // because the mid split always makes the second half of the list smaller
    // therefore p2 ( second half of the list since its smaller ) will always run out of nodes first
    // therefore no need to use p1 != nil
    for p2 != nil {
        next := p1.Next
        p1.Next = p2
        p2 = p2.Next
        p1.Next.Next = next
        p1 = next
    }

}

func reverse(head *ListNode) *ListNode {
    var prev *ListNode
    curr := head
    for curr != nil {
        n := curr.Next
        curr.Next = prev
        prev = curr
        curr = n
    }
    return prev
}
