# TC: O(h) -> for next()
# SC: O(h)
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.pushLeft(root)
    
    def pushLeft(self, node):
        while node:
            self.stack.append(node)
            node=node.left

    def next(self) -> int:
        r=self.stack.pop()
        val=r.val

        if r.right:
            self.pushLeft(r.right)
        return val

    def hasNext(self) -> bool:
        return len(self.stack)>0