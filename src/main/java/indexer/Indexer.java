package indexer;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import modelo.Documento;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import teste.LerDocumentos;

public class Indexer {

	public void indexar() throws FileNotFoundException {
		LerDocumentos ler = new LerDocumentos();
		List<Documento> documentos = ler
				.getDocuments("C:\\Users\\Deliane\\Desktop\\documentosGson.json");

		for (Documento documento : documentos) {
			try {
				indexarDocumento(documento);
				System.out.println("Indexando");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Fim da indexacao");
	}

	public void indexarDocumento(Documento documento) throws IOException {
		String indexPath = "index";
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
		Directory directory = (Directory) FSDirectory.open(new File(indexPath));
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36,
				analyzer);
		IndexWriter writer = new IndexWriter(directory, config);
		Document document = new Document();
		document.add(new Field("Autor", documento.getAutor(), Field.Store.YES,
				Field.Index.ANALYZED));
		document.add(new Field("Titulo", documento.getTitulo(),
				Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("Assunto", documento.getAssunto(),
				Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("Ano", "" + documento.getAno(), Field.Store.YES,
				Field.Index.ANALYZED));
		document.add(new Field("Biblioteca", documento.getBiblioteca()
				.getNome(), Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("Instituicao", documento.getBiblioteca()
				.getInstituicao(), Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("Endereco", documento.getBiblioteca()
				.getEndereco(), Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("URL", documento.getBiblioteca().getUrl(),
				Field.Store.YES, Field.Index.ANALYZED));
		document.add(new Field("Categoria", documento.getCategoria().name(),
				Field.Store.YES, Field.Index.ANALYZED));

		writer.addDocument(document);
		writer.commit();
		writer.close();

	}

}
