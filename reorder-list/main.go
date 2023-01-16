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

With Extra Space :
- you can reverse the linkedlist
- then merge them using two pointers to bet the new list

O(1) :
- find middle
- reverse everything on the right of the middle element
- merge the lists
*/

// time : O(n)
// space : O(1)
func reorderList(head *ListNode) {
	if head == nil {
		return
	}
	fmt.Println(head)
	slow := head
	fast := head
	//find middle and break list
	for fast != nil || fast.Next != nil {
		// odd list - slow is at middle
		if fast.Next == nil {
			fast = slow.Next
			slow.Next = nil
			break

		}
		// for even elements
		if fast.Next.Next == nil {
			fast = slow.Next
			slow.Next = nil
			break
		}

		fast = fast.Next.Next
		slow = slow.Next
	}
	// take slow to head
	p2 := reverse(fast)
	p1 := head
	for p2 != nil {
		temp := p1.Next
		p1.Next = p2
		p2 = p2.Next
		p1.Next.Next = temp
		p1 = temp
	}

}

func reverse(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	for curr != nil {
		n := curr.Next
		curr.Next = prev
		prev = curr
		curr = n
	}
	return prev
}
