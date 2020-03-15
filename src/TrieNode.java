import java.util.HashMap;

public class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLast;

    public TrieNode(){
    }

    public TrieNode(char c){
        ch = c;
    }

    public HashMap<Character, TrieNode> getChildren(){
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> child){
        children = child;
    }

    public boolean getIsLast(){
        return isLast;
    }
    public void setIsLast(boolean isL){
        isLast = isL;
    }
}
