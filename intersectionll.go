// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if head A or B is nil return nil or if they are equal return it
find length of both lists
for list of greater length move to next node till length is same
once both list of same length move both to next till they are sae element, return that element
*/
package main

import "fmt"

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}
	if headA == headB {
		return headA
	}
	la, lb := 0,0
	for x:=headA;x!=nil;x=x.Next{
		la++
	}
	for x:=headB;x!=nil;x=x.Next{
		lb++
	}
	for la > lb {
		headA = headA.Next
		la--
	}
	for lb > la {
		headB = headB.Next
		lb--
	}
	for headA != headB {
		headA = headA.Next
		headB = headB.Next
	}
	return headA
}

func MainIntersection() {
	x := &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}
	headA:= &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: x}}
	headB:= &ListNode{Val: 6, Next: x}
	fmt.Println(getIntersectionNode(headA, headB)) //expected 3
}
