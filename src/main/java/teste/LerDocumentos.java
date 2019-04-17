package teste;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import modelo.Documento;
import modelo.DocumentoList;

public class LerDocumentos {
	
	
	public List<Documento> getDocuments(String filePath)throws FileNotFoundException {
		Gson gson = new Gson();
		JsonReader reader = gson.newJsonReader(new FileReader(filePath));
		DocumentoList list = gson.fromJson(reader, DocumentoList.class);
		List<Documento> documentos = list.getDocumentos();
		
		return documentos;
	}
}
