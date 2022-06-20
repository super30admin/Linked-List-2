# Time Complexity : O(1)
# Space Complexity : worst - O(h); avg - O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self.helper(root)

    def helper(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        temp = self.stack.pop()
        self.helper(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0


check = TreeNode(7)
check.left = TreeNode(3)
check.right = TreeNode(15)
check.right.left = TreeNode(9)
check.right.right = TreeNode(20)
check1 = BSTIterator(check)
print(check1.next())
print(check1.next())
print(check1.hasNext())
print(check1.next())
print(check1.hasNext())
print(check1.next())
print(check1.hasNext())
print(check1.next())
print(check1.hasNext())
