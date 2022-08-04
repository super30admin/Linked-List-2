// Time Complexity : O(1)
// Space Complexity : O(H) - Where H is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//TC - O(1)
//SC - O(H)
//var stack []int
type BSTIterator struct {
    stack []*TreeNode
}


func Constructor(root *TreeNode) BSTIterator {
    iterator := BSTIterator{
        stack: []*TreeNode{},
    }
    
    dfs(root,&iterator)
    
    return iterator
    
}


func (this *BSTIterator) Next() int {
    
    next := this.stack[len(this.stack)-1]
    this.stack = this.stack[:len(this.stack)-1]
    if next.Right != nil{
        dfs(next.Right,this)
    }
    
    return next.Val
}


func (this *BSTIterator) HasNext() bool {
    if len(this.stack) > 0{
        return true
    }
    
    return false
}

func dfs(root *TreeNode,iterator *BSTIterator){
    for root != nil{
        iterator.stack = append(iterator.stack,root)
        root = root.Left
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
