/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 *
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (38.85%)
 * Total Accepted:    27.6K
 * Total Submissions: 71K
 * Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts.  Two accounts definitely belong
 * to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to
 * different people as people could have the same name.  A person can have any
 * number of accounts initially, but all of their accounts definitely have the
 * same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order.  The accounts themselves can be returned in any
 * order.
 * 
 * Example 1:
 * 
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email
 * "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email
 * addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 * 
 * 
 * 
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
	ArrayList<List<String>> resultList = new ArrayList<>();
        if (accounts.size() == 0) return resultList;
	HashMap<String, Person> emailToPersonMap = new HashMap<>();
	ArrayList<Person> realPeople = new ArrayList<Person>();
	for (int i = 0; i < accounts.size(); i++) {
		List<String> currentList = accounts.get(i);
		boolean found = false;
		String currentEmail = "";
		Person currentPerson;
		for (int j = 1; j < currentList.size(); j++) {
			if (emailToPersonMap.containsKey(currentList.get(j))) {
				found = true;
				currentEmail = currentList.get(j);
				break;
			}
		}

		if (!found) {
			currentPerson = new Person(currentList.get(0));
			realPeople.add(currentPerson);
		} else {
			currentPerson = emailToPersonMap.get(currentEmail);
		}

		for (int j = 1; j < currentList.size(); j++) {
			if (!emailToPersonMap.containsKey(currentList.get(j))) {
				currentPerson.emails.add(currentList.get(j));
				emailToPersonMap.put(currentList.get(j), currentPerson);
			}
		}
	}
	for (int i = 0; i < realPeople.size(); i++) {
		ArrayList<String> resultListList = new ArrayList<String>();
		Person currentPerson = realPeople.get(i);
		resultListList.add(currentPerson.name);
		for (int j = 0; j < currentPerson.emails.size(); i++) {
			resultListList.add(currentPerson.emails.get(j));
		}
		resultList.add(resultListList);
	}
	return resultList;
    }
}

class Person {
	String name;
	List<String> emails;
	public Person(String name) {
		this.name = name;
		emails = new ArrayList<String>();
	}
}
