package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// Boiler Plate code for question : courtesy  https://github.com/super30admin/Linked-List-2/blob/9376fa9588751e324bebbf8960bc8241a2e172ab/deleteNodeWithoutHead/main.go
// Time : O(n) - n are the number of nodes in the LL that we have to traverse to replace the val
//Space : O(1)
func deleteNode(n *ListNode) {
	// when deleting something in the middle of the list, since we cannot go back. what we can do is replace the values instead
	for n.Next != nil {
		// not making n nil as I need to remove the last node
		n.Val = n.Next.Val
		if n.Next.Next == nil {
			n.Next = nil
			break
		}
		n = n.Next

	}
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
