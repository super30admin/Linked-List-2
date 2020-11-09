// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
in constructor create a stack and add elements to it by traversing left child repeatedly

for next pop stack into curr, if element has a right child add all left child of that right child to stack
return curr value

if len(stack) > 0 it has Next
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

/*type BSTIterator struct {
	Top *TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
	return BSTIterator{Top: root}
}

func (this *BSTIterator) Next() int {
	if this.Top.Left == nil {
		v := this.Top.Val
		this.Top = this.Top.Right
		return v
	}
	prev := this.Top
	x := this.Top
	flag := 0
	for x.Left != nil {
		if flag > 0 {
			prev = prev.Left
		}
		x = x.Left
		flag++
	}
	if x.Right != nil {
		prev.Left = x.Right
	} else {
		prev.Left = nil
	}
	return x.Val
}

func (this *BSTIterator) HasNext() bool {
	if this.Top != nil {
		return true
	}
	return false
}*/

type BSTIterator struct {
	Stack []*TreeNode
}


func Constructor(root *TreeNode) BSTIterator {
	x := BSTIterator{ Stack: []*TreeNode{}}
	for root != nil {
		x.Stack = append(x.Stack, root)
		root = root.Left
	}
	return x
}


/** @return the next smallest number */
func (this *BSTIterator) Next() int {
	curr := this.Stack[len(this.Stack)-1]
	v := curr.Val
	this.Stack = this.Stack[:len(this.Stack)-1]
	if curr.Right != nil {
		curr = curr.Right
		for curr != nil {
			this.Stack = append(this.Stack, curr)
			curr = curr.Left
		}
	}
	return v
}


/** @return whether we have a next smallest number */
func (this *BSTIterator) HasNext() bool {
	if len(this.Stack) > 0 {
		return true
	}
	return false
}


func MainBSTIterator() {
	root := &TreeNode{Val: 7, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 15, Left: &TreeNode{Val: 9}, Right: &TreeNode{Val: 20}}}
	iterator := Constructor(root)
	fmt.Println(iterator.Next())    // return 3
	fmt.Println(iterator.Next())    // return 7
	fmt.Println(iterator.HasNext()) // return true
	fmt.Println(iterator.Next())    // return 9
	fmt.Println(iterator.HasNext()) // return true
	fmt.Println(iterator.Next())    // return 15
	fmt.Println(iterator.HasNext()) // return true
	fmt.Println(iterator.Next())    // return 20
	fmt.Println(iterator.HasNext()) // return false
}