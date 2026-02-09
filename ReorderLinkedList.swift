//
//  ReorderingTheLinkedList.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/24/26.
//

/*
Find middle element -  O(n/2). Asymtotiacally - O(n)
 reverse the second half linked list. O(n/2), asymptotically - O(n)
 Merge this reversed linked list with the first half linked list, O(n/2), asymptotically - O(n)
 no space complexity
 
 If we need to remove a pointer to a node which needs to be deleted then copy the value of the next node to the current node and bypass the next node. deleted by value
 */
class ReorderingTheLinkedList {
    
    init() {
        
    }
    
    func reorderList(_ head: ListNode?) {
        if (head?.next == nil || head?.next?.next == nil) {
            return
        }
        var slow = head
        var fast = head
        //find middle point of the linked list.
        while(fast?.next != nil || fast?.next?.next != nil) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        //get the position of slow. That's the middle point
        //reverse the linked list
        var prev: ListNode?
        var current = slow?.next
        while(current != nil) {
            let temp = current?.next
            current?.next = prev
            prev = current
            current = temp
        }
        fast = prev
        slow?.next = nil
        slow = head
        
        //now merge both linked lists
        while (fast != nil) {
            let temp = slow?.next
            slow?.next = fast
            fast = fast?.next
            slow?.next?.next = temp
            slow = temp
        }
    }

}
