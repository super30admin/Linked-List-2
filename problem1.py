'''
## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

h: height of the tree

1. BSTIterator constructor:
  Time Complexity : O(h) to fill the stack for the first time

2. next():
  Time Complexity : O(h) in worst case

3. hasNext():
  Time Complexity : O(1)

Overall Space complexity: O(h)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: No

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
  def __init__(self, root):
    self.root = root
    self.stack = []
    self.fillStack(self.root) # fill the stack with the root node and the left node traversal of the left sub tree 

  def next(self):
    node = self.stack.pop() # pop from the top of the stack
    self.fillStack(node.right) # fill the stack with left node traversal of the right sub tree of poped node
    return node.val # return the poped node value

  def hasNext(self):
    return len(self.stack) > 0 # if stack is not empty, a value exists in the inorder traversal

  def fillStack(self, node):
    while node:
      self.stack.append(node)
      node = node.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
