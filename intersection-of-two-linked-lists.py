# tc O(n+m), sc O(1).
p1, p2 = headA, headB

while p1 != p2:
    p1 = headB if not p1 else p1.next
    p2 = headA if not p2 else p2.next

return p1