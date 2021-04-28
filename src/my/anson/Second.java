package my.anson;

public class Second {

    public static void main(String[] args) {
		Second second = new Second();
		ListNode n11 = new ListNode(6);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(3);
		n11.next = n12;
		n12.next = n13;
		ListNode n21 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(4);
		n21.next = n22;
		n22.next = n23;
		ListNode node = second.addTwoNumbers(n11, n21);
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nodeZero = null;
		ListNode dyNode = null;
		int carryFlag = 0;
		while (l1 != null || l2 != null || carryFlag > 0) {
			int i1 = l1 == null ? 0 : l1.val;
			int i2 = l2 == null ? 0 : l2.val;
			int valSum = i1 + i2 + carryFlag;
			ListNode node;
			if (valSum > 9) {
				node = new ListNode(valSum % 10);
				carryFlag = valSum / 10;
			} else {
				node = new ListNode(valSum);
				carryFlag = 0;
			}
			if (nodeZero == null) {
				nodeZero = node;
				dyNode = nodeZero;
			} else {
				dyNode.next = node;
				dyNode = dyNode.next;
			}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return nodeZero;
	}
}
