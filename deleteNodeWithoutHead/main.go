package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// time: o(n)
// space: o(1)
func deleteNode(n *ListNode) {
	if n == nil {
		return
	}
	var prev *ListNode
	curr := n
	for curr != nil && curr.Next != nil {
		next := curr.Next
		curr.Val = next.Val
		prev = curr
		curr = next
	}
	prev.Next = nil
}

func main() {

	t1 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}}
	// delete 1
	deleteNode(t1)
	printLL(t1) // 2->3->4

	t2 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}}
	// delete 2
	deleteNode(t2.Next)
	printLL(t2) // 	1->3->4

	t3 := &ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}}
	// delete 3
	deleteNode(t3.Next.Next)
	printLL(t3) // 	1->2->4
}

func printLL(head *ListNode) {
	msg := ""
	curr := head
	for curr != nil {
		msg += fmt.Sprintf("%v", curr.Val)
		if curr.Next != nil {
			msg += "->"
		}
		curr = curr.Next
	}
	fmt.Println(msg)
}
