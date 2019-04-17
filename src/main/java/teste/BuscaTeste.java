package teste;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import search.Search;

public class BuscaTeste {

	public static void main(String[] args) throws IOException, ParseException {
		
		Search search = new Search();
		search.textInfoSearch("index");		
	}

}
