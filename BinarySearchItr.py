'''
    Time Complexity:
        Constructor using O(n) time to save every element in the array.
        next() and hasNext() take O(1) time.

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Save all the values of the BST in an array in InOrder fashion. 
'''
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.storage = []
        self.idx = -1
        self._save_inorder(root)

    def next(self) -> int:
        self.idx += 1
        return self.storage[self.idx]

    def hasNext(self) -> bool:
        return self.idx + 1 < len(self.storage)

    def _save_inorder(self, root):
        if root is None:
            return

        self._save_inorder(root.left)
        self.storage.append(root.val)
        self._save_inorder(root.right)
