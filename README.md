###JAVA DS&A###
==============

This will be a guide and reference to using the data structures and algorithms in Java.


#HashMaps
A hashmap generally run in O(1) time to put and get because it uses a hashcode to store in a unique position
However, Space will be O(n), Duuuuhhh.
Generally, if you use any data structure, space will be O(N);
```
HashMap<String, Integer> stringToIntegerMap = new HashMap<String, Integer>();
stringToIntegerMap.size(); //-> returns the size of the map O(1)
stringToIntegerMap.get(key); //-> gets the value of key, O(1) 
stringToIntegerMap.put(key, value); //-> stores a value for the key 
stringToIntegerMap.getOrDefault(key, 0); //-> this is normally use to check if there is a given
					// value stored. If the key doesn't exist, we return 0;
stringToIntegerMap.containsKey(key); //-> lets you know if the key exist. O(1)?
stringToIntegerMap.keySet(); //-> returns the keys in a set array
stringToIntegerMap.entrySet(); //-> returns a set of Map.Entry<String, Integer>;
```


#Map.Entry
Hashmaps are generally made out of entries. an entry basically has a key and a value. 
and to get them, you just use getValue or getKey
```
for (Map.Entry<String, Integer> entrySet : stringToIntegerMap.entrySet()) {
	entrySet.getValue(); //-> returns the value of that certain entry set
	entrySet.getKey(); //-> returns the key of that certain entry set
}
```


#Comparators
============
Comparators are used for sorting a lot. And sometimes you just want to sort it in a way you want.
Most Collections sorts in ascending order. So from smaller to big. 
It can be really hard to remember how to write a comparator, but here's a few things to help with
the process
```
//In General, you want to create a new Comparator when you initialize something. And some things
//that you have to remember is that the input you take after has to be the same.
//If you take in Integer but use int later, you will get errors like Error(anonymous abstract blah blah)
//So remember to use the same Object
//
//Another important thing is to remember that you need to initialize it!
new Comparator<Map.Entry<String, Integer>>() {
	//In here, you want to OVERRIDE the compare function, by using @Override
	@Override
	public int compare(Map.Entry<String, Integer> keyThatWePutIn, Map.Entry<String,Integer> keyInMap) {
		//Another good thing to remember is that the what will cause what.
		//As a rule of thumb, if a(the first argument)-b(the second argument)
		//then it will result in ascending order. You turn it around to b-a
		//and it becomes descending order
		//
		//Let's change it up here to sort it in DESCENDING order based on 
		//the value of the entryset!
		// I normally use a as keyThatWePutIn, b is keyInMap
		// Think of it as a doesn't exist yet and b (is already 'be' -> exist already)
		return keyInMap.getValue() - keyThatWePutIn.getValue();
	}
}
```
and that's Comparator 101!

Honestly, I drew out a whole picture. But i think we can see it this way.
Assuming a and b are the same value.
a = 2, b = 3 -> b is in the map already

(a-b=-1 -> 2-3=-3), 3, (b-a=1, 3-2=1)


#TreeMap
============
The Treemap are one of the best maps. Not necessarily time complexity wise, because it takes O(lgN) to put.
and basically O(lgN) to do everything since it's not an array with hashcode.
But the greatest thing about this is that everything is sorted. But only based on the keys!
```
//Lets initialize a string that sorts the keys based on the strings lexographical-y length
//in DESCENDING order.
TreeMap<String, Integer> stringToIntTreeMap = new TreeMap<String, Integer>(new Comparator<String>() {
	@Override
	//Remember to use the same Object type!
	public int compare(String a, String b) {
		//compareTo is a function of a String. Just think of it this way.
		//If I compare a to b, then if a is smaller, I put a first.
		//If I compare b to a, then if b is smaller, I put b first.
		return b.compareTo(a);
	}
});

//Remember, we're in descending order!
stringToIntTreeMap.firstKey(); //-> Gets the firstKey, which will be the biggest key  	O(1) cause it's at top
stringToIntTreeMap.firstEntry(); //-> Gets the firstEntry			    	O(1) cause again, top 
stringToIntTreeMap.lastKey(); //-> Gets the lastKey					O(lgN) cause at Bottom
stringToIntTreeMap.lastEntry(); //-Gets the last entry					O(lgN)
stringToIntTreeMap.pollFirstKey(); //->removes the first key				O(lgN) cause gotta sort
stringToIntTreeMap.pollFirstEntry(); //->removes the first entry			O(lgN) cause gotta sort
stringToIntTreeMap.pollLastEntry(); //->removes the last key				O(lgN) cause gotta go down
stringToIntTreeMap.pollLastEntry(); //->removes the last entry				O(lgN) cause gotta go down
stringToIntTreeMap.containsKey(); //->see if it contains the key			O(lgN) cause gotta search

stringToIntTreeMap.get(key); //->get the value					O(lgN) gotta go down the tree
stringToIntTreeMap.get(key, value); //->put value in				O(lgN) gotta add then sort

stringToIntTreeMap.ceilingKey(num); //->get the value AFTER or EQUAL to this key, the key smaller in this context
										//O(lgN) gotta search
stringToIntTreeMap.higherKey(num); //->get the value AFTER (only) to this key, the key smaller in this context
										//O(lgN) gotta search
stringToIntTreeMap.floorKey(num); //->get the value BEFORE or EQUAL to this key, the key bigger in this context
										//O(lgN) gotta search
stringToIntTreeMap.ceilingKey(num); //->get the value BEFORE(only) to this key, the key bigger in this context
										//O(lgN) gotta search
```
Everything else in treeMap is the same as HashMap


###ABOUT REMOVE###
Always think the remove function as removing something, not just pulling something out.
Pulling something out, is always POLL!


#PriorityQueue(Heap)
===================
A heap basically is a linked list or queue that is sorted.
Initialization is ascending
```
PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
	new Comparator<Map.Entry<Integer, Integer>>() {
		@Override
		public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
			return a.getKey() - b.getKey();
		}
	}
);

minHeap.add(element); //->adds an element into the queue and sort it		O(lgN) to sort
minHeap.offer(element); //->adds an element into the queue and sort it		O(lgN) to sort
minHeap.contains(element); //->check if it contains the specified object	O(lgN) I think? cause its a tree
minHeap.peek(); //->look at the top most object					O(1) cause its at the top
minHeap.poll(); //->pull out the first object. You can pull the last		O(lgN) cause need to find and sort
```


#Queues
Queues are queues, heaps are just fancier and queues that do certain things. (sorting)
Queues follow the first in first out rule. What comes in first goes out first
The thing about java is that there isn't a queue collection. But, its basically a linked list
```
Queue<Integer> integerQueue = new LinkedList<>();
integerQueue.add(element); //->Adds the element to the end of the list	O(1) we have access to first and last
integerQueue.addFirst(element); //->Adds to the start of the list 	O(1)
integerQueue.peek(); //->Look at the first (NOT LAST) element in list	O(1)
integerQueue.getFirst(); //->get first element				O(1)
integerQueue.getLast(); //->get last element				O(1)
integerQueue.get(element); //->get specific element			O(N) gotta find it
integerQueue.poll(); //->removes first element in the list		O(1)
integerQueue.pollFirst(); //-> removes first element			O(1)
integerQueue.pollLast(); //-> removes last element 			O(1)
```


###SIZE###
All collections you can get size in O(1) by using size()

###IS EMPTY###
All Collections can be check whether its empty by using isEmpty()!


#Stack
======
Stacks uses a Last in First Out rule. So imagine a stack of cards, you can only take the top out first.
```
Stack<Integer> integerStack = new Stack<>();
integerStack.peek(); //-> Look at the top Deck					O(1)
integerStack.push(); //-> push an integer onto the top of the stack		O(1)
integerStack.pop(); //-> pop an integer from the top of the stack		O(1)
```
Honestly, if you use anything other than those few plus size and is empty, then you should use something else.


#Set
Sets allows you to check if something exists. It's basically a map, but theres no values.
There are HashSet and TreeSet
HashSets are not sorted, TreeSets are
```
HashSet<Integer> integerSet = new HashSet<Integer>();
TreeSet<Integer> integerTreeSet = new TreeSet<Integer>(new Comparator<Integer>() {
	//remember that you have to use Integer if its Integer,
	//and also collections can't take primitive types like int
	@Override
	public int compare(Integer a, Integer b) {
		return a-b;
	}
});

integerSet.add(element); //->Add a new element			O(1)
integerTreeSet.add(element); //->Add a new element		O(lgN)
integerSet.contains(element); //->Checks if element exist 	O(1)
integerTreeSet.contains(element); //->Same thing as above	O(lgN) it's a tree 
```


#List
======
List is basically an array with functions.
There are two types of list. LinkedList and ArrayList, its the time complexity that is different
```
ArrayList<Integer> integerArrayList = new ArrayList<>();
LinkedList<Integer> integerLinkedList = new LinkedList<>();

integerArrayList.add(element); //->Appends to end of list 		O(1)
integerLinkedList.add(element); //->Appends to end of list		O(1)

//To add to a position, we both have reference to that position, it's just that Linked list dont need to
//move stuff befind.
integerArrayList.add(index, element); //->Appends at position index	O(N) cause we have to move everything after
integerArrayList.add(index, element); //->Appends at position index	O(1) we have reference to position

//Remove in array list, we have to move the stuff front too
integerArrayList.remove(index); //->Remove the value at an index	O(N)
integerLinkedList.remove(index); //->Remove the value at an index	O(1)

integerArrayList.remove(element); //->Remove the element if exist (returns true if there is)	O(N);
integerLinkedList.remove(element); //->Remove element if present				O(N);

integerArrayList.contains(element); //->Check if the element exist 	O(N) we have to go through the list
integerLinkedList.contains(element); //->Check if element exist 	O(N) still have to go through

integerArrayList.set(index, element); //->Change the element val at position index	O(1)
integerLinkedList.set(index, element); //->Change the element val at position index	O(1)

//The problem with arraylist is that you can only put the type into type[] with toArray
integerArrayList.toArray(new Integer[integerArrayList.size());

//but if you want to put it into a primitive int, then you have to loop through it
int[] intArray = new int[integerArrayList.size()];
for (int i = 0; i < integerArrayList.size(); i++) {
	intArray[i] = integerArrayList.get(i);
}
```


#Trees
======
Trees basically follow three rules. Preorder, Inorder and Postorder. And it's really hard to remember how
each works. So I think the best way to remember how it works is literally the code.
```
//PREorder -> before traversing
public void traverse(TreeNode root) {
	//Always do edge cases!
	if (root == null) return;
	System.out.println(root.val); //-> Visit current node first
	traverse(root.left);
	traverse(root.right);
}

//INorder -> in between traversing
public void traverse(TreeNode root) {
	if (root==null) return;
	traverse(root.left);
	System.out.println(root.val); //-> Visit current node in between
	traverse(root.right);
}

//POSTorder -> after traversing
public void traverse(TreeNode root) {
	if (root==null) return;
	traverse(root.left);
	traverse(root.right);
	System.out.println(root.val); //-> Visit current node in between
}
```
as Easy as that!


#Depth First Search (DFS)
========================
Depth first search is basically going deep first, and all the previous traversal are depth first search.
You can not use recursion by using a STACK! to do it iteratively.
Using recursion, you might run out of stack space, stack overflow

To remember whether we use Stack or Queue for DFS or BFS, think this.
BFS = BBQ -> Use Queue since it ends with Q
DFS -> use Stack, because BFS uses Queue already

```
//We'll do preorder just for the sake of it, plus its a lot easier
public void depthFirstIterative(TreeNode root) {
	if (root == null) return;
	Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
	//Always remember to push the first root.
	//think of it as entering the first recursion
	treeNodeStack.push(root);

	while(!treeNodeStack.isEmpty()) {
		TreeNode currentNode = treeNodeStack.pop();
		//Visit the node first
		System.out.println(currentNode.val);
		
		if (currentNode.left != null) treeNodeStack.push(currentNode.left);
		if (currentNode.right != null) treeNodeStack.push(currentNode.right);
	}
}

//InOrder
public void dfsIterativeInOrder(TreeNode root) {
	if (root == null) return;
	Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
	//Always remember to push the first root.
	//think of it as entering the first recursion
	treeNodeStack.push(root);
	
	while(!treeNodeStack.isEmpty()) {
	}
}
```


#Breadth First Search (BFS)
=========================
Breadth first search is where we visit everything around us first before we go on.
We normally associate it with level order traversal.
Remember! BBQ -> Use a queue!
```
public void breadthFirstSearch(TreeNode root) {
	if (root == null) return;
	
	Queue<TreeNode> treeNodeQueue = new TreeNodeQueue<>();
	treeNodeQueue.offer(root);
	
	//I like to take the treeNodeSize, but we technically only need to depending on the situation
	//It's more towards using it if you want to keep track of the level you're on.
	int treeNodeQueueSize = treeNodeQueue.size();
	while(!treeNodeQueue.isEmpty()) {
		for (int i = 0; i < treeNodeQueueSize; i++) {
			TreeNode currentNode = treeNodeQueue.poll();
			System.out.println(currentNode.val);
			if (currentNode.left != null) treeNodeQueue.offer(currentNode.left);
			if (currentNode.right != null) treeNodeQueue.offer(currentNode.right);
		}
		treeNodeQueueSize = treeNodeQueue.size();
	}
}
```

Man this is one long java DSA note already, but lets push on!



