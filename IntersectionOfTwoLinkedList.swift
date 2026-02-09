//
//  IntersectionOfTwoLinkedList.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/16/26.
//

/*
 
 Intersection point of 2 linked lists :-
 1. Keep 1 list in set. Traverse over the 2nd list and check the elements in the set. We will find the intersection point.
 Time complexity - O(m + n), maximum between m and n
 space complexity - O(m + n), maximum between m and n
 
 2. Take the length of both linked lists. Take the difference between both lengths. Which ever is greater, increase the counter by that difference start. It will meet at the intersection point.
 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

class IntersectionOFTwoLinkedLists {
    func getIntersectionNode(_ headA: LLNode<Int>?, _ headB: LLNode<Int>?) -> LLNode<Int>? {
        //get the length of headA linked List
        // var headA = headA
        // var headB = headB
        if (headA == nil && headB == nil) {
            return nil
        }
        if (headA == nil || headB == nil) {
            return nil
        }
        var current = headA
        var countA = 0
        while(current != nil) {
            countA += 1
            current = current?.next
        }
        var countB = 0
        current = headB
        while (current != nil) {
            countB += 1
            current = current?.next
        }
        var skipCountsForA = 0
        var skipCountsForB = 0
        if (countA > countB) {
            skipCountsForA = countA - countB
        } else if (countB > countA) {
            skipCountsForB = countB - countA
        }

        var pointerA = headA
        var pointerB = headB
        while (countA > countB) {
            pointerA = pointerA?.next
            countA -= 1
        }

        while countB > countA {
            pointerB = pointerB?.next
            countB -= 1
        }

        while(pointerA != nil || pointerB != nil) {
            if (pointerA === pointerB) {
                return pointerA
            }
            pointerA = pointerA?.next
            pointerB = pointerB?.next
        }
        return nil
    }
}
