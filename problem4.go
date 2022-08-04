// Time Complexity : O(m+n)
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
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    if headA == nil || headB == nil{
        return nil
    }
    
    lenA := 0
    lenB := 0
    
    temp := headA
    for temp != nil{
        temp = temp.Next
        lenA++
    }
    
    temp = headB
    for temp != nil{
        temp = temp.Next
        lenB++
    }
    
    for lenA > lenB{
        headA = headA.Next
        lenA-=1
    }
    
    for lenB > lenA{
        headB = headB.Next
        lenB-=1
    }
    
    for headA != headB {
        headA = headA.Next
        headB = headB.Next
    }
    
    return headA
}
