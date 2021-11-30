package com.company.algomonster.twopointer.samedirection;

public class FindMiddleOfLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        String input = "0 1 2 3 4";
        for(String val : input.split(" ")) {
            ListNode node = new ListNode(Integer.parseInt(val));
            cur.next = node;
            cur = node;
        }
//        System.out.println(middleOfLinkedList(dummy.next)); // 재귀적으로 처리되어 있다...

    }

    private static ListNode middleOfLinkedList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        /**
         * fast가 null인 경우 종착지이다.
         * fast.next가 null인 경우는 홀수개인 경우이다 [ 전진 불가 ]
         */
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
