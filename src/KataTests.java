import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KataTests {
    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2}, Kata.arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, Kata.arrayDiff(new int [] {}, new int[] {1,2}));
    }

    @Test
    public void publicTests() {
        assertEquals(true, Kata.isTriangle(1,2,2));
        assertEquals(false, Kata.isTriangle(7,2,2));
    }


    @Test
    public void staticTests() {
        assertEquals("no one likes this", Kata.whoLikesIt());
        assertEquals("Peter likes this", Kata.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", Kata.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", Kata.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", Kata.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    @Test
    public void disemvowelTests() {
        assertEquals("Ths wbst s fr lsrs LL!",Kata.disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", Kata.disemvowel(
                "No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals( "Wht r y,  cmmnst?", Kata.disemvowel("What are you, a communist?"));
    }

    @Test
    public void findItTests() {
        assertEquals(5, Kata.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, Kata.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, Kata.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, Kata.findIt(new int[]{10}));
        assertEquals(10, Kata.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, Kata.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

    @Test
    public void digitizeTests() {
//        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, Kata.digitize(35231));
        assertArrayEquals(new int[] {0, 0, 1, 3, 2}, Kata.digitize(23100));
        assertArrayEquals(new int[] {0}, Kata.digitize(0));
    }

    @Test
    public void removeCharTests() {
        assertEquals("loquen", Kata.removeChar("eloquent"));
        assertEquals("ountr", Kata.removeChar("country"));
        assertEquals("erso", Kata.removeChar("person"));
        assertEquals("lac", Kata.removeChar("place"));
    }

    @Test
    public void findShortTests() throws Exception {
        assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
        assertEquals(2, Kata.findShort("Let's travel abroad shall we"));
    }

    @Test
    public void findShortStreamTests() throws Exception {
        assertEquals(3, Kata.findShortStream("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShortStream("turns out random test cases are easier than writing out basic ones"));
        assertEquals(2, Kata.findShortStream("Let's travel abroad shall we"));
    }

    @Test
    public void tenMinWalkTests() {
        //assertEquals("Should return true", true, Kata.tenMinWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        //assertEquals("Should return false", false, Kata.tenMinWalk(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        //assertEquals("Should return false", false, Kata.tenMinWalk(new char[] {'w'}));
        assertEquals("Should return false", false, Kata.tenMinWalk(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }


}

