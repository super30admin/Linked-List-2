//
//  DeleteWithoutHeadPointer.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/9/26.
//

class DeleteWithoutHeadPointer {
    
    class LinkedListNode<T> {
        var value: T
        var next: LinkedListNode<T>?
        
        init(value: T, next: LinkedListNode<T>?) {
            self.value = value
            self.next = next
        }
    }
    
    init() {
        let node3 = LinkedListNode<Int>(value: 3, next: nil)
        let node2 = LinkedListNode<Int>(value: 2, next: node3)
        let node1 = LinkedListNode<Int>(value: 1, next: node2)
        let node0 = LinkedListNode<Int>(value: 0, next: node1)
        
        deleteNodeWithoutHeadPointer(node: node1)
        
        print("updates list below ***")
        var head: LinkedListNode<Int>? = node0
        while (head != nil) {
            print(head!.value)
            head = head!.next ?? nil
        }
    }
    
    func deleteNodeWithoutHeadPointer(node: LinkedListNode<Int>) {
        //when a particular node needs to be deleted. Just copy the next node's value in the current node and delete the next node.
        let nextNodeValue = node.next?.value
        node.value = nextNodeValue!
        node.next = node.next?.next
    }
}
