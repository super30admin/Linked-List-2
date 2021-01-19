# Time Complexity : next - O(n) / O(1) amortized ; hasNext- O(1) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Using controlled inorder traversal the leftmost path of the subtree is put in stack
# Whenever next is called we get top and push the left path of right subtree
# For has next we check if stack has any elements

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        top = self.stack.pop()
        root = top.right
        while root:
            self.stack.append(root)
            root = root.left
        return top.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0