# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class BSTIterator:

    def __init__(self, root):
        
        # to store all nodes
        self.nodes_list = []
        
        # pointer to the next smallest element
        self.index = -1
        
        # to flatten the tree
        self.inorder(root)
        
    def inorder(self,root):
        if not root:
            return
        self.inorder(root.left)
        self.nodes_list.append(root.val)
        self.inorder(root.right)

    # returns next smallest element
    def next(self) -> int:
        
        self.index += 1
        return self.nodes_list[self.index]
        
    # returns whether we have next smallest element
    def hasNext(self) -> bool:
        
        return self.index + 1 < len(self.nodes_list)
        