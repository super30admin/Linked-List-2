// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode)  {
    if head == nil || head.Next == nil{
        return
    }
    
    slow := head
    fast := head
    
    // Find Middle of the linked list
    for fast.Next!=nil && fast.Next.Next != nil{
        slow = slow.Next
        fast = fast.Next.Next
    }
    
    // Reverse the later part of linked list
    fast = reverse(slow.Next)
    
    slow.Next = nil
    
    slow = head
    
    //Merge the two list
    var temp *ListNode
    for fast != nil{
        temp = slow.Next
        slow.Next = fast
        fast = fast.Next
        slow.Next.Next = temp
        slow = temp
    }
    
}


func reverse(curr *ListNode) *ListNode{
    if curr == nil || curr.Next == nil{
        return curr
    }
    var prev *ListNode
    var next *ListNode
    for curr != nil{
        next = curr.Next
        curr.Next = prev
        prev = curr
        curr = next
    }
    return prev
}

