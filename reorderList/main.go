/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode)  {
    
    /*
    approach 1: double ended queue
    
    Loop over LL, while saving each node in a double ended queue
    Then make the head nil ( reset )
    
    1. Initialize head with a dummy node and use a current ptr to act as the tail while we are appending
    while we have items in double ended queue:
        1. current.Next = Pop from front
        if we still have items:
            2. current.Next = Pop from back ( double check the dq still has elements remaining because the first operation will run out )
        
    time: o(n)
    space: o(n) because of the extra double ended queue
        
        
        
    approach 2: 
    - split LL into 2 halves
    - reverse second half of the LL ( in place )
    - Then we will have 2 LL's ( start and second-reversed )
    - Merge 2 LL's starting with first and then second
    
    time: o(n)
    space: o(1)
    */if head == nil || head.Next == nil {
		return
	}

	var prevSlow *ListNode
	slow := head
	fast := head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		prevSlow = slow
		slow = slow.Next
	}

	prevSlow.Next = nil
	// head : 1-2
	// slow : 3-4-5

	// now slow is reversed
	// slow: 5-4-3
	slow = reverseLL(slow)

	// 1-5-2-4-3

	// 1-2
	// p1
	var prev *ListNode
	p1 := head
	// 5-4-3
	// p2
	p2 := slow
	for p1 != nil || p2 != nil {
		var p1Next *ListNode
		if p1 != nil {
			p1Next = p1.Next
		}

		var p2Next *ListNode
		if p2 != nil {
			p2Next = p2.Next
		}
        if prev != nil {
            prev.Next = p1
        }
        
        if p1 != nil {
            p1.Next = p2
            p2.Next = nil
        } else if p2 != nil {
            prev.Next = p2
        }
        
        prev = p2
        p1 = p1Next
        p2 = p2Next
	}
}

func reverseLL(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var prev *ListNode
	current := head
	for current != nil {
		next := current.Next
		current.Next = prev
		prev = current
		current = next
	}
	return prev
}
