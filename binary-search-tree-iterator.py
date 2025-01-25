class BSTIterator:
    # tc O(n), sc O(n)
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        curr = root
        while curr:
            self.stack.append(curr)
            curr = curr.left

    def next(self) -> int:
        nxt_node = self.stack.pop()
        curr = nxt_node.right
        while curr:
            self.stack.append(curr)
            curr = curr.left
        return nxt_node.val        

    def hasNext(self) -> bool:
        return self.stack != []