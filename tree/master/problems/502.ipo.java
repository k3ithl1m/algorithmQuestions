/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 *
 * https://leetcode.com/problems/ipo/description/
 *
 * algorithms
 * Hard (37.32%)
 * Total Accepted:    10.7K
 * Total Submissions: 28.7K
 * Testcase Example:  '2\n0\n[1,2,3]\n[0,1,1]'
 *
 * 
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of
 * its shares to Venture Capital, LeetCode would like to work on some projects
 * to increase its capital before the IPO. Since it has limited resources, it
 * can only finish at most k distinct projects before the IPO. Help LeetCode
 * design the best way to maximize its total capital after finishing at most k
 * distinct projects. 
 * 
 * 
 * 
 * You are given several projects. For each project i, it has a pure profit Pi
 * and a minimum capital of Ci is needed to start the corresponding project.
 * Initially, you have W capital. When you finish a project, you will obtain
 * its pure profit and the profit will be added to your total capital.
 * 
 * 
 * 
 * To sum up, pick a list of at most k distinct projects from given projects to
 * maximize your final capital, and output your final maximized capital.
 * 
 * 
 * Example 1:
 * 
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * 
 * Output: 4
 * 
 * Explanation: Since your initial capital is 0, you can only start the project
 * indexed 0.
 * ⁠            After finishing it you will obtain profit 1 and your capital
 * becomes 1.
 * ⁠            With capital 1, you can either start the project indexed 1 or
 * the project indexed 2.
 * ⁠            Since you can choose at most 2 projects, you need to finish the
 * project indexed 2 to get the maximum capital.
 * ⁠            Therefore, output the final maximized capital, which is 0 + 1 +
 * 3 = 4.
 * 
 * 
 * 
 * Note:
 * 
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 * 
 * 
 */
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    	ArrayList<Project> projectList = getProjectList(Profits, Capital);
	PriorityQueue<Project> sortedProjectQueue = new PriorityQueue<Project>(new Comparator<Project>() {
		@Override
		public int compare(Project a, Project b) {
			if (a.capital == b.capital) return b.profit - a.profit;
			return a.capital - b.capital;
		}
	});
	for (int i = 0; i < projectList.size(); i++) {
		sortedProjectQueue.add(projectList.get(i));
	}

	PriorityQueue<Project> affordableQueue = new PriorityQueue<Project>(new Comparator<Project>() {
		@Override
		public int compare(Project a, Project b) {
			return b.profit - a.profit;
		}
	});

	int totalCapital = W;
	for (int i = 0; i < k; i++) {
		while (!sortedProjectQueue.isEmpty() && sortedProjectQueue.peek().capital <= totalCapital) {
			affordableQueue.add(sortedProjectQueue.poll());
		}
		if (!affordableQueue.isEmpty()) {
			totalCapital += affordableQueue.poll().profit;
		}
	}

	return totalCapital;
    }


    private ArrayList<Project> getProjectList(int[] Profits, int[] Capital) {
	ArrayList<Project> projectList = new ArrayList<Project>();
	for (int i = 0; i < Profits.length; i++) {
		projectList.add(new Project(Profits[i], Capital[i]));
	}
	return projectList;
    }
}

class Project {
	int capital;
	int profit;
	public Project(int profit, int capital) {
		this.capital = capital;
		this.profit = profit;
	}
}
