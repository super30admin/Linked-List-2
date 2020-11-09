// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if node.Next == nil set node as nil
else copy next element value to current and set current.Next = next element.next
*/
package main

import "fmt"

func deleteNode(node *ListNode) {
	if node.Next == nil {
		node = nil
	} else {
		node.Val = node.Next.Val
		node.Next = node.Next.Next
	}
}

func MainDelete() {
	head:= &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}}}
	deleteNode(head.Next.Next)
	for head != nil{
		fmt.Println(head.Val)
		head = head.Next
	}// expected 1->2->4->5
}