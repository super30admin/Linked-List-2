// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func reorderList(_ head: ListNode?) {
        var slow = head
        var fast = head?.next?.next
        while fast != nil {
            fast = fast?.next?.next
            slow = slow?.next
        }
       
        var nodeb1 = reverse(slow?.next)
        
        slow?.next = nil
        //print(slow?.val)
        var nodea1 = head
        
        while  nodea1 != nil && nodeb1 != nil {
            var nodea2 = nodea1?.next
            var nodeb2 = nodeb1?.next
            nodea1?.next = nodeb1
            nodeb1?.next = nodea2
            nodea1 = nodea2
            nodeb1 = nodeb2
            
        }  
    }
    func reverse(_ head: ListNode?) -> ListNode? {
        var node1 : ListNode?
        var node2 = head
        var node3 = head?.next
        while node2 != nil {
            node2?.next = node1
            node1 = node2
            node2 = node3
            node3 = node3?.next
        }
        return node1
    }