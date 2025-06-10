'''
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
'''

# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        curr = self.st.pop()
        self.dfs(curr.right)
        return curr.val

    def hasNext(self) -> bool:
        return len(self.st) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

'''
Iterators are needed because of LAZY LOADING -- Thats their big strength
This allows us to handle dynamicity. For example, if we are in production, the data is often dynamic and changing continually. 
Iterators allow us to go through this data one at a time, without having to worry about the dynamicity. 
(if we were using somthing like building an inorder array for this tree and returning each element one after the other, we need to rebuild this array everytime the data changes)

'''