package av.test;

import av.WordSearch;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {
	WordSearch wordSearch=null;

	@Before
	public void setUp()
	{
		if(wordSearch == null) wordSearch = new WordSearch();
	}

	@Test
	void testWordSearchReturnsString() {
		assertEquals("aa", wordSearch.searchWord("aa"));
		
	}

	@Test
	public void testAllWordsFound() {

		try {
			String [] words= {"BONES", "KHAN", "KIRK", "SCOTTY", "SPOCK", "SULU", "UHURA"};
			for(int i=0; i< words.length; i++)
			{
				assertEquals(words[i], wordSearch.searchWord(words[i]));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
