package Mine2024.searchSuggestionsSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution1
{


    public static void main(String[] args)
    {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        Solution1 s = new Solution1();
        List<List<String>> result = s.suggestedProducts(products, searchWord);
        System.out.println(result);
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        char[] searchWordArray = searchWord.toCharArray();
        Trie trie = new Trie(new TrieNode(new HashMap<>(), false));

        // insert product data into the trie
        for (String product : products)
        {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();

        String searchPhrase = "";

        // for each char in the searchWordArray, retrieve 3 words from the trie
        for (char letter : searchWordArray)
        {
            searchPhrase = searchPhrase + letter;
            List<String> partialResult = findSuggestedWordsForPhrase(searchPhrase, trie);
            result.add(partialResult);
        }


        return result;

    }

    private List<String> findSuggestedWordsForPhrase(String searchPhrase, Trie trie)
    {
        List<String> result = new ArrayList<>();
        Stack<TrieNode> stack = new Stack<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a)); // so that we can get the top 3 words in alphabetical order
        TrieNode currentNode = trie.root;
        stack.push(currentNode);
        for (char letter : searchPhrase.toCharArray())
        {
            if (currentNode.children.get(letter) != null)
            {
                currentNode = currentNode.children.get(letter);
            }
            else
            {
                return result;
            }

        }

        while (!stack.isEmpty())
        {
            if (currentNode.isWord)
            {
                pq.offer(currentNode.content);
                if (pq.size() > 3)
                {
                    pq.poll();
                }
            }
            for (TrieNode node : currentNode.children.values())
            {
                stack.push(node);

            }

            currentNode = stack.pop();

        }

        while (!pq.isEmpty())
        {
            result.add(0, pq.poll());
        }

        return result;
    }


    public class TrieNode
    {
        Map<Character, TrieNode> children;
        String content;
        boolean isWord;

        public TrieNode(Map<Character, TrieNode> children, boolean isWord)
        {
            this.children = children;
            this.isWord = isWord;
        }
    }

    public class Trie
    {
        TrieNode root;

        public Trie(TrieNode root)
        {
            this.root = root;
        }

        public void insert(String word)
        {
            char[] wordArray = word.toCharArray();
            TrieNode currentNode = this.root;
            String currentContent = "";

            for (char currentLetter : wordArray)
            {
                currentContent += currentLetter;
                currentNode = currentNode.children.computeIfAbsent(currentLetter, k -> new TrieNode(new HashMap<>(), false));
                currentNode.content = currentContent;
//                if(currentNode.children!= null && currentNode.children.get(currentLetter)!=null){
//                    if(currentLetter == wordArray[wordArray.length-1]){
//                        currentNode.children.get(currentLetter).isWord = true;
//                    } else{
//                        currentNode = currentNode.children.get(currentLetter);
//                    }
//
//                } else {
//                    if(currentLetter == wordArray[wordArray.length-1]){
//                        currentNode.children= new HashMap<>();
//                        currentNode.children.put(currentLetter, new TrieNode(null, true));
//                    }else{
//                        if(currentNode.children == null){
//                            currentNode.children = new HashMap<>();
//                        }
//                        currentNode.children.put(currentLetter, new TrieNode(null, false));
//                        currentNode = currentNode.children.get(currentLetter);
//                    }
//                }

            }
            currentNode.isWord = true;


        }

        public boolean find(String word)
        {
            TrieNode current = this.root;
            for (char letter : word.toCharArray())
            {
                if (current.children.containsKey(letter))
                {
                    current = current.children.get(letter);
                }
                else
                {
                    return false;
                }

            }
            return current.isWord;

        }

        public void delete(String word){
            TrieNode current = this.root;
            if(!find(word)){
                return;
            }
            for(char letter: word.toCharArray()){
                if(current.children.size() == 1){
                    current.children.remove(letter);
                    return;
                }
                current = current.children.get(letter);
            }

            current.isWord = false;
        }

    }
}
