package teste;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Biblioteca;
import modelo.CategoriaEnum;
import modelo.Documento;
import modelo.DocumentoList;

public class TesteJson {

	public static void main(String[] args) {
		
		Biblioteca bib = new Biblioteca();
        bib.setNome("BIBLIOTECA PAULO SARMENTO - CMC");
        bib.setInstituicao("IFAM");
        bib.setEndereco("Av. Sete de Setembro - Centro, Manaus - AM, 69020-125");
        bib.setUrl("http://qacademico.ifam.edu.br/qacademico/index.asp?t=6000");
        
        Documento doc = new Documento();
        doc.setAutor("autorteste");
        doc.setTitulo("tituloteste");
        doc.setAssunto("banco de dados");
        doc.setAno(1980);
        doc.setBiblioteca(bib);
        doc.setCategoria(CategoriaEnum.LIVRO);
    
        DocumentoList dl = new DocumentoList();
        dl.getDocumentos().add(doc);
        
        bib = new Biblioteca();
        bib.setNome("teste1");
        bib.setInstituicao("IFAM");
        bib.setEndereco("Av. Sete de Setembro - Centro, Manaus - AM, 69020-125");
        bib.setUrl("urlteste1");
        
        doc = new Documento();
        doc.setAutor("autorteste1");
        doc.setTitulo("tituloteste1");
        doc.setAssunto("banco de dados");
        doc.setAno(1982);
        doc.setBiblioteca(bib);
        doc.setCategoria(CategoriaEnum.LIVRO);
    
        dl.getDocumentos().add(doc);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String meuGson = gson.toJson(dl);
        
        try {
            try(FileWriter writer = new FileWriter("documentosGson.json")){
            writer.write(meuGson);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

}
