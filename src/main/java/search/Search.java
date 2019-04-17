package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.print.Doc;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.index.DirectoryReader;

public class Search {

	
	public void textInfoSearch(String indexPath)throws IOException, ParseException {        
        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = (Directory) FSDirectory.open(Paths.get(indexPath));
        DirectoryReader ireader = DirectoryReader.open(directory);//
        IndexSearcher isearcher = new IndexSearcher(ireader);//
        
        QueryParser parser = new QueryParser("Titulo", analyzer);//
        Query query = parser.parse("Java");//
        
        ScoreDoc[] hits = isearcher.search(query, 100, Sort.INDEXORDER).scoreDocs;//
        
        for (int i = 0; i < hits.length; i++) {
        	Document doc = isearcher.doc(hits[i].doc);
        	
        	for (String info : doc.getValues("Titulo")) {
        		System.out.println("titulo: " + info);			
				
			}
        	for (String info : doc.getValues("Autor")) {
        		System.out.println("autor: " + info);			
        		
        	}
        	for (String info : doc.getValues("Assunto")) {
        		System.out.println("assunto: " + info);			
        		
        	}
        	for (String info : doc.getValues("Biblioteca")) {
        		System.out.println("biblioteca: " + info);			
				
			}
        	for (String info : doc.getValues("Ano")) {
        		System.out.println("ano: " + info);			
				
			}
        	for (String info : doc.getValues("Instituicao")) {
        		System.out.println("instituicao: " + info);			
				
			}
        	for (String info : doc.getValues("Endereco")) {
        		System.out.println("endereco: " + info);			
				
			}
        	for (String info : doc.getValues("URL")) {
        		System.out.println("url: " + info);			
				
			}
        	for (String info : doc.getValues("Categoria")) {
        		System.out.println("categoria: " + info);			
				
			}
        	
        	System.out.println("_______________________________________________");
		}
        
        
        
        
        ireader.close();
        directory.close();
	}   
	
}
