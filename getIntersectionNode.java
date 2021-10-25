// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func getIntersectionNode(_ headA: ListNode?, _ headB: ListNode?) -> ListNode? {
        var nodeA = headA
        var nodeB = headB
        var lengthA = 0
        var lengthB = 0
        while nodeA != nil {
            nodeA = nodeA?.next
            lengthA += 1
        }
        while nodeB != nil {
            nodeB = nodeB?.next
            lengthB += 1
        }
        nodeA = headA
        nodeB = headB
        var offset = 0
        if lengthA > lengthB {
            offset = lengthA - lengthB
            while offset > 0 {
                nodeA = nodeA?.next
                offset -= 1
            }
        } else {
            offset = lengthB - lengthA
            while offset > 0 {
                nodeB = nodeB?.next
                offset -= 1
            }
        }
        while nodeA != nil && nodeA !== nodeB {
            nodeA = nodeA?.next
            nodeB = nodeB?.next
        }
        return nodeA
    }