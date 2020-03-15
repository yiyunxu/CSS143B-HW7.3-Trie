import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {

    private List<String> documents() {
        return new ArrayList<>(
                Arrays.asList(
                        "hello",
                        "high",
                        "seattle",
                        "seatac",
                        "see",
                        "hollow",
                        "how"));
    }

    @Test
    public void testInsert() {
        Trie trie = new Trie();
        for (int i=0; i<documents().size(); i++) {
            trie.insert(documents().get(i));
        }
        for (int i=0; i<documents().size(); i++) {
            assertTrue (trie.doesExist(documents().get(i)));
        }
        assertFalse (trie.doesExist("ho"));
    }

    @Test
    public void testNoMatch() {
        Trie trie = new Trie();
        for (int i=0; i<documents().size(); i++) {
            trie.insert(documents().get(i));
        }
        List<String> result = trie.search("xyz");
        assertEquals(result.size(), 0);
    }

    @Test
    public void testOneMatch() {
        Trie trie = new Trie();
        for (int i=0; i<documents().size(); i++) {
            trie.insert(documents().get(i));
        }

        List<String> result = trie.search("how");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "how");
    }

    @Test
    public void testTwoMatch() {
        Trie trie = new Trie();
        for (int i=0; i<documents().size(); i++) {
            trie.insert(documents().get(i));
        }

        List<String> result = trie.search("sea");
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), "seatac");
        assertEquals(result.get(1), "seattle");

        result = trie.search("se");
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), "seatac");
        assertEquals(result.get(1), "seattle");
        assertEquals(result.get(2), "see");
    }

    @Test
    public void testFourMatch() {
        Trie trie = new Trie();
        for (int i=0; i<documents().size(); i++) {
            trie.insert(documents().get(i));
        }

        List<String> result = trie.search("h");
        assertEquals(result.size(), 4);
        assertEquals(result.get(0), "hello");
        assertEquals(result.get(1), "high");
        assertEquals(result.get(2), "hollow");
        assertEquals(result.get(3), "how");
    }
}
