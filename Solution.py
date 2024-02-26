class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        time: O(n)
        space: O(1)
        """

        def middle(l):
            slow = fast = l
            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next
            tmp = slow.next
            slow.next = None
            return tmp
        
        def reverse(l):
            prev = None
            while l:
                tmp = l.next
                l.next = prev
                prev = l
                l = tmp
            return prev
        
        def merge(l1, l2):
            dummy = l1
            while l1 and l2:
                tmp1 = l1.next
                tmp2 = l2.next
                l1.next = l2
                l2.next = tmp1
                l1, l2 = tmp1, tmp2
            return dummy
        
        mid = middle(head)
        l2 = reverse(mid)
        return merge(head, l2)
def deleteNode(self, node):
    '''
    time: O(1)
    space: O(1)
    '''
    next_node = node.next
    node.val = next_node.val
    node.next = next_node.next
    next_node.next = None

def getIntersectionNode(self, headA, headB):
    """
    :type head1, head1: ListNode
    :rtype: ListNode
    time: O(m+n)
    space: O(1)
    """
    def get_length(head):
        ans = 0
        dummy = head
        while head:
            ans += 1
            head = head.next
        head = dummy
        return ans
    length_a = get_length(headA)
    length_b = get_length(headB)

    i = 0
    while headB and i < length_b - length_a:
        headB = headB.next
        i += 1
    i = 0
    while headA and i < length_a - length_b:
        headA = headA.next
        i += 1
    while headA and headB:
        if headA == headB:
            return headA
        headA = headA.next
        headB = headB.next
    return None

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        time: O(height)
        space: O(height)
        """
        self.values = []           
        self.push(root)
    
    def push(self, t):
        if not t:
            return
        self.values.append(t)
        self.push(t.left)       

    def next(self):
        """
        :rtype: int
        time: O(1) amortized as most nodes do not have right child.
        """
        ret = self.values.pop()
        self.push(ret.right)
        return ret.val
        

    def hasNext(self):
        """
        :rtype: bool
        time: O(1)
        """
        return len(self.values) != 0
