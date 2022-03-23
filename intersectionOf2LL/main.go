/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    
    /*
        approach 1 : using hashmap
        - loop over headA and headB
        - attempt to add both node refs in hashmap
        - if map already contains a nodeRef, that means that node is the intersection point
        
        time: o(len(headA)+len(headB)) -- at worse we go thru all the nodes.
        space: o(n) -- we allocated a map to store nodeRefs
    if headA == nil || headB == nil {
        return nil
    }
    
    nodeRefs := map[*ListNode]struct{}{}
    for headA != nil || headB != nil {
        if headA != nil {
            _, ok := nodeRefs[headA]
            if ok {
                return headA
            }
            nodeRefs[headA] = struct{}{}
            headA = headA.Next
        }
        
        if headB != nil {
            _, ok := nodeRefs[headB]
            if ok {
                return headB
            }
            nodeRefs[headB] = struct{}{}
            headB = headB.Next
        }
    }
    */
    
    
    /*
        approach 2: using 2 pointers
        - ptrA at headA
        - ptrB at headB
        
        if ptrA meets ptrB , that means we found the intersecting node.
        This will only work if the starting len of both LL's are the same.
        But we can do that, if its not.
        
        We wont remove the nodes, but we will change the start positions of either of the ptrs
        so that they both start from the same starting positions.
        
        How?
        - Get the length of both LL
        - Do a diff
        - whoever returns diff > 0, that ptr moves that diff times
        
        Then finally until ptrA and ptrB are not nil, loop
        if they meet, break out and return the meeting nodeRef.
        
        time: o(len(headA)+len(headB)) -- at worse we go thru all the nodes.
        space: o(1)
    
    */
    ptrA := headA
    ptrB := headB
    
    headASize := 1
    tmpA := headA
    for tmpA != nil {
        headASize++
        tmpA = tmpA.Next
    }
    headBSize := 1
    tmpB := headB
    for tmpB != nil {
        headBSize++
        tmpB = tmpB.Next
    }
    aMinusB := headASize-headBSize
    bMinusA := headBSize-headASize
    
    if aMinusB > 0 {
        for aMinusB != 0 {
            ptrA = ptrA.Next
            aMinusB--
        }
    } else if bMinusA > 0 {
        for bMinusA != 0 {
            ptrB = ptrB.Next
            bMinusA--
        }
    }
    
    // now that ptrA and ptrB are at the same position
    for ptrA != nil && ptrB != nil {
        if ptrA == ptrB {
            return ptrA
        }
        ptrA = ptrA.Next
        ptrB = ptrB.Next
    }
    
    
    
    return nil
}
