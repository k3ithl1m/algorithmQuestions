/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (22.96%)
 * Total Accepted:    240K
 * Total Submissions: 1M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */

class Node {
	Node next;
	Node prev;
	int key;
	int val;
	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
	public Node() {
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;
	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.prev = tail;
		tail.next = head;
		tail.prev = head;	
	}

	public void addToHead(Node n) {
		head.next.prev = n;
		n.next = head.next;
		n.prev = head;
		head.next = n;
	} 

	public void moveToHead(Node n) {
		Node temp = n.next;
		n.next.prev = n.prev;
		n.prev.next = temp;
		addToHead(n);
	} 

	public int removeFromTail() {
		Node temp = tail.prev.prev;
		Node nodeToReturn = tail.prev;
		temp.next = tail;
		tail.prev = tail.prev.prev;
		return nodeToReturn.key;
	}
}
class LRUCache {

    private HashMap<Integer, Node> nodeMap;
    private DoublyLinkedList nodeList;
    private int capacity;
    private int currentCapacity;
    public LRUCache(int capacity) {
	nodeMap = new HashMap<Integer, Node>();
	nodeList = new DoublyLinkedList();
	this.capacity = capacity;
	this.currentCapacity = 0;
    }
    
    public int get(int key) {
	if (!nodeMap.containsKey(key)) return -1;
	else {
		Node nodeToReturn = nodeMap.get(key);
		nodeList.moveToHead(nodeToReturn);
		return nodeToReturn.val;
	}
    }
    
    public void put(int key, int value) {
	if (nodeMap.containsKey(key)) {
		Node nodeToChange = nodeMap.get(key);
		nodeToChange.val = value;	
		nodeList.moveToHead(nodeToChange);
		System.out.println(nodeToChange.val);
	} else {
		Node tempNode = new Node(key, value);
		nodeMap.put(key, tempNode);
		nodeList.addToHead(tempNode);
		currentCapacity++;
	} 
	if (currentCapacity > capacity) {
		int keyToDelete = nodeList.removeFromTail();
		nodeMap.remove(keyToDelete);
		currentCapacity = currentCapacity - 1;
		System.out.println(keyToDelete);
	}	
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
