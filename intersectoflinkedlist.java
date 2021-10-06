time complexity: O(m+n)
space complexity: O(n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set set = new HashSet();

    ListNode n1Current = headA;
    while(n1Current != null){
    set.add(n1Current);
    n1Current = n1Current.next;
    }

    ListNode n2Current = headB;

    while(n2Current != null){

    if(set.contains(n2Current)){
    return n2Current;
    }
    n2Current = n2Current.next;
    }

    return null;
    } 
    }