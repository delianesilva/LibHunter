package wrapper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wrapper {
	public static void main(String []args) throws IOException{
	    
	    Document doc = Jsoup.connect("http://www.esauce.com.br/blog/qual-diferenca-entre-site-responsivo-site-mobile-web-app-e-aplicativo-para-celular-app/").get();
	    
	    Elements elements = doc.getAllElements();
	    
	        for (Element element : elements) {
	            element.tagName();
	            System.out.println("tag:  -- "+ element.tagName());
	            
	            for (Attribute atributo : element.attributes()) {
	                System.out.println("atributos:  -- "+ atributo);
	            }
	        }
	    
	    }
}
