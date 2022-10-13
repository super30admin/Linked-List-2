# TC - O(1) avg
# SC - O(h)
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.li = []
        while root:
            self.li.append(root)
            root = root.left
        
    def next(self) -> int:
        res = self.li.pop()
        curr = res.right
        while curr:
            self.li.append(curr)
            curr = curr.left
        return res.val

    def hasNext(self) -> bool:
        return len(self.li) != 0

        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()