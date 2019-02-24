/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (27.67%)
 * Total Accepted:    33.3K
 * Total Submissions: 120.4K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least
 * frequently used item before inserting a new item. For the purpose of this
 * problem, when there is a tie (i.e., two or more keys that have the same
 * frequency), the least recently used key would be evicted.
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
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */
class FreqNode {
	int key;
	int value;
	int freq;
	public FreqNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.freq = 0;
	}

	public void incrementFrequency() {
		freq++;
	}
}

class LFUCache {
    PriorityQueue<FreqNode> freqNodeQueue;
    HashMap<Integer, FreqNode> freqNodeMap;
    int capacity;
    public LFUCache(int capacity) {
	this.capacity = capacity;
	freqNodeMap = new HashMap<>();
	freqNodeQueue = new PriorityQueue<FreqNode>(new Comparator<FreqNode>() {
				public int compare(FreqNode a, FreqNode b) {
					System.out.println(a.key + " " + a.freq + " "  + b.key + " " + b.freq);
					return b.freq - a.freq;
				}
			});        
    }
    
    public int get(int key) {
       	FreqNode getResNode = freqNodeMap.get(key);
	if (getResNode == null) return -1;
	freqNodeQueue.remove(getResNode);
	getResNode.incrementFrequency();
	System.out.println(getResNode.key + " " + getResNode.freq);
	freqNodeQueue.add(getResNode);
	return getResNode.value; 
    }
    
    public void put(int key, int value) {
       	FreqNode existingNode = freqNodeMap.get(key);
	if (existingNode != null) {
		freqNodeMap.remove(existingNode.key);
		freqNodeQueue.remove(existingNode);
	} 
	FreqNode newNode = new FreqNode(key, value);
	freqNodeMap.put(key, newNode);
	System.out.println(newNode.key + " " + newNode.freq);
	if (freqNodeMap.size() > capacity) {
		FreqNode toRemoveNode = freqNodeQueue.poll();
		freqNodeQueue.add(newNode);
		freqNodeMap.remove(toRemoveNode.key);
	}
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
