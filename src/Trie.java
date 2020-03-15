import java.util.*;

// reference https://medium.com/@amogh.avadhani/how-to-build-a-trie-tree-in-java-9d144aaa0d01
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){

        TrieNode current = root;
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i<word.length(); i++){
            char c = word.toLowerCase().charAt(i);

            if (children.containsKey(c)){
                current = children.get(c);
            }
            else{
                current = new TrieNode(c);
                children.put(c, current);
            }
            children = current.children;
        }
        current.isLast = true;
    }

    public boolean doesExist(String word){
        TrieNode current = root;
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);

            if (children.containsKey(c)){
                current = children.get(c);
            }
            else{
                current = null;
                break;
            }
            children = current.children;
        }
        if (current!=null && current.isLast)
            return true;
        else
            return false;
    }

    public List<String> search(String word){
        TrieNode current = root;
        HashMap<Character, TrieNode> children = root.children;
        StringBuilder searchPhrase = new StringBuilder();
        List<String> result = new ArrayList<>();

        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);

            if (children.containsKey(c)){
                current = children.get(c);
                searchPhrase.append(c);
            }
            else{
                return result; // not found
            }
            children = current.children;
        }

        String strComplete="";
        traverseTrie(current, searchPhrase, result, strComplete);

        return result;
    }

    //recursion to find all possible word combinations
    private void traverseTrie(TrieNode node, StringBuilder searchPhrase, List<String> list, String strComplete){
        HashMap<Character, TrieNode> children = node.children;

        if (node.isLast){
            list.add(searchPhrase.toString()+strComplete);
        }

        for (int i = 0; i<26; i++)
        {
            char c = toChar(i);
            if (children.containsKey(c)){
                strComplete += c;
                traverseTrie(children.get(c), searchPhrase, list, strComplete);
                strComplete = strComplete.substring(0, strComplete.length()-1);
            }
        }
    }

    // helper function
    private char toChar(int i){
        switch(i){
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'q';
            case 17:
                return 'r';
            case 18:
                return 's';
            case 19:
                return 't';
            case 20:
                return 'u';
            case 21:
                return 'v';
            case 22:
                return 'w';
            case 23:
                return 'x';
            case 24:
                return 'y';
            default:
                return 'z';
        }
    }
}
