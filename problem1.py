# Time Complexity : O(1) on average for both next() and hasNext() 
#                   (since each node is pushed and popped only once)
# Space Complexity : O(h) where h is the height of the tree 
#                    (stack stores at most h nodes at a time)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially understanding 
# how to simulate in-order traversal iteratively using a stack


# Your code here along with comments explaining your approach
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # stack to store nodes while traversing the tree
        self.st = []
        # call dfs helper to push all left nodes (smallest elements) to stack
        self.dfs(root)
        

    def dfs(self, root):
        # keep going left while node exists and push nodes into stack
        while root:
            self.st.append(root)
            root = root.left
        

    def next(self) -> int:
        # pop the top node from stack (this is the next smallest element)
        temp = self.st.pop()
        # if this node has a right subtree, push all its left children
        # (since after visiting a node, its right child is next in in-order traversal)
        self.dfs(temp.right)
        # return the value of the popped node
        return temp.val
        

    def hasNext(self) -> bool:
        # if stack is not empty, there are still nodes left to visit
        return len(self.st) > 0