// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
find mid point by moving slow and fast by 1 and 2 respectively
separate them using prev at the mid point
reverse the second half
now alternately select elements from first and second list
if second list is not empty append that at the end
*/
package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func reorderList(head *ListNode)  {
	if head == nil {
		return
	}

	var prev *ListNode
	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		if prev != nil {
			prev = prev.Next
		} else {
			prev = head
		}
		slow = slow.Next
		fast = fast.Next.Next
	}
	if slow == fast {
		return
	}
	prev.Next = nil

	// reversal
	temp := slow
	rev := &ListNode{Val: -1}
	for temp != nil {
		x:= temp
		temp = temp.Next
		x.Next = rev.Next
		rev.Next = x
	}

	x := head
	p := rev.Next
	for x!=nil {
		t := x.Next
		x.Next = p
		t1 := p.Next
		p.Next = t
		x = t
		p = t1
	}
	if p != nil {
		y:=head
		for y.Next!=nil{
			y=y.Next
		}
		y.Next=p
	}
}

func MainReorder() {
	head := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}}}
	reorderList(head)
	for head != nil{
		fmt.Println(head.Val)
		head = head.Next
	}// expected 1->5->2->4->3.
}
