package av.test;

import av.WordSearch;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {
	WordSearch wordSearch=null;

	@BeforeEach
	public void setUp()
	{
		if(wordSearch == null) wordSearch = new WordSearch();
	}

//	@Test
//	void testWordSearchReturnsString() {
//		try {
//			assertEquals("aa", wordSearch.searchWord("aa"));
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		
//	}

//	@Test
//	public void testAllWordsFound() {
//
//		try {
//			String [] words= {"BONES", "KHAN", "KIRK", "SCOTTY", "SPOCK", "SULU", "UHURA"};
//			for(int i=0; i< words.length; i++)
//			{
//				assertEquals(words[i], wordSearch.searchWord(words[i]));
//			}
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}

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
