package av;

public class Program {

	public static void main(String[] args) {
		String [] words= {"BONES", "KHAN", "KIRK", "SCOTTY", "SPOCK", "SULU", "UHURA"};
		WordSearch wordSearch= new WordSearch();

		for(int i=0; i< words.length; i++)
			try {
				System.out.println(wordSearch.searchWord(words[i]));
			} catch (Exception e) {

				e.printStackTrace();
			}

	}

}
