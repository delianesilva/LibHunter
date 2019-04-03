package teste;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopDocs;

import common.LuceneConstants;
import common.LuceneFileFilter;
import indexer.Indexer;
import indexer.LuceneSearcher;

public class Main {


	   public static void main(String[] args) throws FileNotFoundException {	   
		   Indexer indexer = new Indexer();
		   indexer.indexar();
		   
	   }   
}
