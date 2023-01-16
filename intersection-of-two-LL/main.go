package main

import "fmt"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

/*
basically the solution says that get both the heads at the same node and then
iterate until they are same and return any head at the end of solution
*/
// Time : O(n)
// Space : O(1)
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	fmt.Println(headA)
	fmt.Println(headB)

	//len first LL
	lenA := 0
	pa := headA
	for pa != nil {
		lenA++
		pa = pa.Next
	}

	lenB := 0
	pb := headB
	for pb != nil {
		lenB++
		pb = pb.Next
	}

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
