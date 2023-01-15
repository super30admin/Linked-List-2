// approach: hashset
// time: o(n)
// space: o(n)

// approach: using 2 pointers
// ensure size of both arrays are same such that the intersecting node is same distance away from a and b
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    curr := headA
    lenA := 1
    for curr != nil {curr = curr.Next; lenA++}

    curr = headB
    lenB := 1
    for curr != nil {curr = curr.Next; lenB++}
    
    for lenA > lenB {
        headA = headA.Next
        lenA--
    }
    
    for lenB > lenA {
        headB = headB.Next
        lenB--
    }
    
    for headA != headB {
        headA = headA.Next
        headB = headB.Next
    }
    return headA
}
