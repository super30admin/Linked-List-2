//
//  BSTIterator.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/27/26.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */

class StackUsingLinkedList<T> {
    private class LinkedListNode<T> {
        var value: T?
        var next: LinkedListNode<T>?
        init(value: T?) {
            self.value = value
        }
    }
    
    private var head: LinkedListNode<T>?
    func push(value: T?) {
        let newNode = LinkedListNode(value: value)
        if (head == nil) {
            //empty LinkedList
            head = newNode
            return
        }
        //if not empty, insert the newNode at the front
        newNode.next = head
        head = newNode
    }
    
    func pop() -> T? {
        if (head == nil) {
            //ll is empty. return nil
            return nil
        }
        let val = head?.value
        head = head?.next
        return val
    }
    
    func isEmpty() -> Bool {
        return head == nil
    }
}

class BSTIterator {
    
    var stack = StackUsingLinkedList<TreeNode?>()
    init(_ root: TreeNode?) {
        dfs(root)
    }
    
    func next() -> Int {
        var n = stack.pop()!
        if let rightNode = n!.right {
            dfs(rightNode)
        }
        return n!.val
    }
    
    func hasNext() -> Bool {
        return !stack.isEmpty()
    }
    
    func dfs(_ root: TreeNode?) {
        var curr = root
        while let node = curr {
            stack.push(value: node)
            curr = node.left
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * let obj = BSTIterator(root)
 * let ret_1: Int = obj.next()
 * let ret_2: Bool = obj.hasNext()
 */
