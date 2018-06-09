

import java.util.LinkedList;
import java.util.List;

/**
 * An trie data structure that implements the Dictionary and the AutoComplete
 * ADT
 *
 */
public class AutoCompleteDictionaryTrie implements Dictionary, AutoComplete {

	private TrieNode root;
	private int size;

	public AutoCompleteDictionaryTrie() {
		root = new TrieNode();
	}

	/**
	 * Insert a word into the trie.
	 */
	public boolean addWord(String word) {
		// TODO
		String key = word.toLowerCase();
		TrieNode node = root;
		for (int i = 0; i < key.length(); i++) {
			if (node.getValidNextCharacters().contains(key.charAt(i)))
				node = node.getChild(key.charAt(i));
	    	else
				node = node.insert(key.charAt(i));
		}
		if (!node.endsWord()) {
			node.setEndsWord(true);
			size++;
			return true;
		}
		return false;
	}

	/**
	 * Return the number of words in the dictionary. This is NOT necessarily the
	 * same as the number of TrieNodes in the trie.
	 */
	public int size() {
		return size;
	}

	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) {
		// TODO: Implement this method
		String key = s.toLowerCase();
		TrieNode node = root;
		for (int i = 0; i < key.length(); i++) {
			if (node.getValidNextCharacters().contains(key.charAt(i)))
				node = node.getChild(key.charAt(i));
			else
				return false;
		}
		if (node.endsWord())
			return true;
		return false;
	}

	/**
	 * * Returns up to the n "best" predictions, including the word itself, in terms
	 * of length If this string is not in the trie, it returns null.
	 * 
	 * @param prefix
	 *            The text to use at the word stem
	 * @param numCompletions
	 *            The maximum number of predictions desired.
	 * @return A list containing the up to n best predictions
	 */
	@Override
	public List<String> predictCompletions(String prefix, int numCompletions) {
		// TODO: Implement this method
		// This method should implement the following algorithm:
		// 1. Find the stem in the trie. If the stem does not appear in the trie, return
		// an empty list
		// 2. Once the stem is found, perform a breadth first search to generate
		// completions
		// using the following algorithm:
		// Create a queue (LinkedList) and add the node that completes the stem to the
		// back
		// of the list.
		// Create a list of completions to return (initially empty)
		// While the queue is not empty and you don't have enough completions:
		// remove the first Node from the queue
		// If it is a word, add it to the completions list
		// Add all of its child nodes to the back of the queue
		// Return the list of completions
		List<String> completionsList = new LinkedList<>();
		if(prefix == null || numCompletions <= 0){
			return completionsList;
		}
		String checkPrefix = prefix.toLowerCase();
		TrieNode node = root;
		int count = 0;
		for (int i = 0; i < checkPrefix.length(); i++) {
			if (node.getValidNextCharacters().contains(checkPrefix.charAt(i)))
				node = node.getChild(checkPrefix.charAt(i));
			else
				return completionsList;
		}
		if (node.endsWord()) {
			completionsList.add(node.getText());
			count++;
		}
		List<TrieNode> queue = new LinkedList<>();
		List<Character> completions = new LinkedList<>(node.getValidNextCharacters());
		for(int i = 0; i < completions.size(); i++){
			char c = completions.get(i);
			queue.add(node.getChild(c));
		}
		while(!queue.isEmpty() && count < numCompletions){
			TrieNode checkWord = queue.remove(0);
			if(checkWord.endsWord()){
				completionsList.add(checkWord.getText());
				count++;
			}
			List<Character> compList = new LinkedList<Character>(checkWord.getValidNextCharacters());
			for (int i = 0; i < compList.size(); i++) {
				char c = compList.get(i);
				queue.add(checkWord.getChild(c));
			}
		}
		return completionsList;

	}

	// For debugging
	public void printTree() {
		printNode(root);
	}

	/** Do a pre-order traversal from this node down */
	public void printNode(TrieNode curr) {
		if (curr == null)
			return;

		System.out.println(curr.getText());

		TrieNode next = null;
		for (Character c : curr.getValidNextCharacters()) {
			next = curr.getChild(c);
			printNode(next);
		}
	}

}