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
}

class LRUCache {

    int currentCapacity;
    int maxCapacity;
    HashMap<Integer, Node> nodeMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
	this.currentCapacity = 0;
	this.maxCapacity = capacity;        
	nodeMap = new HashMap<Integer, Node>();
	head = null;
	tail = null;
    }
    
    public int get(int key) {
       	if (nodeMap.containsKey(key)) {
		Node tempNode = nodeMap.get(key);
		Node prevNode = tempNode.prev;
		Node nextNode = tempNode.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		tempNode.next = head;
		if (tail == tempNode) {
			tail = tail.prev;
		}
		tempNode.prev = tail;
		head.prev = tempNode;
		tail.next = tempNode;
		head = tempNode;
		tail = tempNode.prev;
		return nodeMap.get(key).val;
	} else return -1; 
    }
    
    public void put(int key, int value) {
       	Node newNode = new Node(key, value);
	if (currentCapacity == 0) {
		head = newNode;
		tail = newNode;
		head.prev = tail;
		tail.next = head;
		nodeMap.put(key, newNode);
		currentCapacity++;
		return;
	} else {
		currentCapacity++;
		newNode.next = head;
		newNode.prev = tail;
		head.prev = newNode;
		tail.next = newNode;
		head = newNode;
		nodeMap.put(key, head);
		if (currentCapacity > maxCapacity) {
			nodeMap.remove(tail.key);
			tail = tail.prev;
			tail.next = tail.next.next;
			head.prev = tail;
			currentCapacity--;
		}
	}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
