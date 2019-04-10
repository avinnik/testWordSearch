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

}
