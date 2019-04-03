package modelo;

import java.util.ArrayList;
import java.util.List;

public class DocumentoList {
    
    private List<Documento> documentos;

    public DocumentoList() {
        documentos = new ArrayList<>();
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }  
    
}
