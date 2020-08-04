class BSTIterator:
    def __init__(self, root: TreeNode):
        self.nodes=[]
        self.inorder(root)
    def inorder(self,root):
        while root:
            self.nodes.append(root)
            root=root.left
    def next(self) -> int:
        top_root = self.nodes.pop()
        self.inorder(top_root.right)
        return top_root.val
    def hasNext(self) -> bool:
        return len(self.nodes) > 0
        

#Time-Complexity:
# has_next(): O(1)
#next(): O(1)

#Space-Complexity:O(h)