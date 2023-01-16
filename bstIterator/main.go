package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/*

the previous solution that was done usinf DFS approach was wrong.
even though the answer was correct, it was not behaving the way an iterator should behave.

Iterators are supposed to be dynamic in nature and also control large datasets - ionder to control large datasets they should not
store an exact copy of the entire given dataset in memory for obvious reasons. The dynamic nature demands that if some ref has changed somewhere we have
the correct reference in memory as well.

This introduces something called controlled recursion - in simple words, when iterating DFS over a tree, you would not recurse on right child
unless left child's value has been returned to the user.

*/

// Time : O(n)
// Space : O(h) - max space occupied is height of the tree in the overhead stack that we have
type BSTIterator struct {
	root    *TreeNode
	arr     []int
	index   int
	stack   []*TreeNode // you can just call this an arrary instaed of calling it a stack
	current *TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
	iterator := BSTIterator{}
	iterator.DFS(root)
	return iterator
}

func (this *BSTIterator) DFS(r *TreeNode) {
	if r == nil {
		return
	}
	this.stack = append(this.stack, r)
	this.DFS(r.Left)
}

func (this *BSTIterator) Next() int {
	// return the whatever is on top of the stack
	this.current = this.stack[len(this.stack)-1]
	this.stack = this.stack[:len(this.stack)-1]
	this.DFS(this.current.Right)
	return this.current.Val
}

func (this *BSTIterator) HasNext() bool {
	if len(this.stack) != 0 {
		return true
	}
	return false
}
