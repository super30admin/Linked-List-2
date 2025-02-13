// Approach: Initialize two pointers, each pointing to the head of one of the given linked lists. Traverse both lists until the pointers
// are equal, which occurs either when both are null or when they reach the intersection node. When a pointer reaches the end of its
// current list, reassign it to the head of the other list. Continue this process until the pointers meet, then return either of them as
// the intersection point.
// Time Complexity: O(m + n) where m, n - 1st and 2nd list sizes respectively.
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

import java.util.Set;
import java.util.HashSet;

public class IntersectionOf2LLs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int v) {
            val = v;
        }
    }

    ListNode findIntersectionNode1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode p1 = head1, p2 = head2;
        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : head2;
            p2 = (p2 != null) ? p2.next : head1;
        }
        return p1;
    }

    ListNode findIntersectionNode2(ListNode head1, ListNode head2) {
        int n1 = count(head1), n2 = count(head2);
        return (n1 > n2) ? getIntersection(head1, head2, n1, n2) : getIntersection(head2, head1, n2, n1);
    }

    // doubt-1: how is list structure not modified here? We are passing by reference
    int count(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    // doubt-1: how is list structure not modified here? We are passing by reference
    ListNode getIntersection(ListNode head1, ListNode head2, int m, int n) {
        for (int i = 0; i < m - n; i++) {
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) { // doubt-2: checking reference equality works?
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    ListNode findIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionOf2LLs io2lls = new IntersectionOf2LLs();

        ListNode intersection = new ListNode(18);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = intersection;

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next = intersection;

        System.out.println("Intersection node value: " + io2lls.findIntersectionNode1(head1, head2).val);
    }
}