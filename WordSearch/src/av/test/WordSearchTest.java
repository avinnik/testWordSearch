package av.test;

import av.WordSearch;
import org.junit.Before;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordSearchTest {
	WordSearch wordSearch=null;

	@Before
	public void setUp()
	{
		if(wordSearch == null) wordSearch = new WordSearch();
	}


	@Test
	public void testReverseSearch() {

		try {
			String [] words= {"KHAN", "KIRK", "SULU"};
			String [] results= {
					"KHAN (5,9),(5,8),(5,7),(5,6)",
					"KIRK (4,7),(3,7),(2,7),(1,7)",
					"SULU (3,3),(2,2),(1,1),(0,0)"
			};
			
			for(int i=0; i< words.length; i++)
			{
				String res=wordSearch.searchWord(words[i]);
				assertEquals(results[i], res);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testHorisontalSearch() {

		try {
			String [] words= {"SCOTTY"};
			String [] results= {
					"SCOTTY (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)",
			};
			
			for(int i=0; i< words.length; i++)
			{
				assertEquals(results[i], wordSearch.searchWord(words[i]));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testVerticalSearch() {

		try {
			String [] words= {"BONES"};
			String [] results= {
					"BONES (0,6),(0,7),(0,8),(0,9),(0,10)",
			};
			
			for(int i=0; i< words.length; i++)
			{
				assertEquals(results[i], wordSearch.searchWord(words[i]));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testLeftToRightDiagonalSearch() {

		try {
			String [] words= {"SPOCK"};
			String [] results= {
					"SPOCK (2,1),(3,2),(4,3),(5,4),(6,5)",
			};
			
			for(int i=0; i< words.length; i++)
			{
				String res=wordSearch.searchWord(words[i]);
				assertEquals(results[i], res);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testRightToLeftDiagonalSearch() {

		try {
			String [] words= {"UHURA"};
			String [] results= {
					"UHURA (4,0),(3,1),(2,2),(1,3),(0,4)",
			};
			
			for(int i=0; i< words.length; i++)
			{
				String res=wordSearch.searchWord(words[i]);
				assertEquals(results[i], res);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	
	@Test
	public void testNullInput() {
		Throwable e = null;
		try {
			wordSearch.searchWord(null);
		} catch (Exception e1) {
			e=e1;
		}
		assertTrue(e instanceof IllegalArgumentException);
	}

	@Test
	public void testWordTooLong() {
		Throwable e = null;
		try {
			wordSearch.searchWord("qwertyuiopop[]asdfghjkl;");
		} catch (Exception e1) {
			e=e1;
		}
		assertTrue(e instanceof IllegalArgumentException);
	}

	@Test
	public void testWordTooShort() {
		Throwable e = null;
		try {
			wordSearch.searchWord("A");
		} catch (Exception e1) {
			e=e1;
		}
		assertTrue(e instanceof IllegalArgumentException);
	}
	
}
