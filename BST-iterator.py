"""
Runtime Complexity:
O(n) - we do a inorder traversal on all the nodes. 'n' is the number of nodes.
Space Cpmplexity:
O(n) - we use a list to store all the nodes. 
Yes, the code worked on leetcode.
Issues while coding- NO
"""
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.sorted_nodes = []
        self.index = -1
        self.inorder(root)
    
    def inorder(self,root):
        if not root:
            return
        self.inorder(root.left)
        self.sorted_nodes.append(root.val)
        self.inorder(root.right)

    def next(self) -> int:
        self.index+=1
        return self.sorted_nodes[self.index]

    def hasNext(self) -> bool:
        return self.index+1 < len(self.sorted_nodes)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()