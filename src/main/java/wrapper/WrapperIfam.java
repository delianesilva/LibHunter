package wrapper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WrapperIfam {
	Document document;// todo conteúdo da web fica armazenado neste

	public WrapperIfam(Document document) {
		this.document = document;
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			Document document = Jsoup
					.connect(
					// "http://academico.ifam.edu.br/qacademico/index.asp?t=6000&ACAO=EXIBIR&ABA=0&TITULO=norma&AUTOR=&ASSUNTO=&rbLISTAGEM=LISTAGEM&x=0&y=0")
							"http://academico.ifam.edu.br/qacademico/index.asp?t=6000&ACAO=EXIBIR&ABA=0&TITULO=*&AUTOR=&ASSUNTO=&rbLISTAGEM=LISTAGEM&x=44&y=14")
					.get();// metodo que recebe a pagina
			Thread.sleep(5000);
			WrapperIfam parserFooter = new WrapperIfam(document);
			parserFooter.getWords();

		} catch (IOException e) {
		}

	}

	private void getWords() {
		// Elements elements = document.getElementsByClass("conteudoTexto");
		//Elements elements = document.select("tr");
		// Elements elements = document.
		//getFooterPaginas(elements);
	}

	private void getFooterPaginas(Elements elements) throws IOException {

		for (Element element : elements) {
			if (element.attr("bgcolor").equals("#FFFFFF")
					|| element.attr("bgcolor").equals("#E6E7E8")) {
				System.out.println("\n--: Novo Registro: ");
				Elements td = element.getElementsByTag("td");
				for (Element contentTD : td) {
					if (!contentTD.text().equals("")){
						System.out.println("-------:" + contentTD.text());
						String atributoHref = contentTD.select("div>a").attr("href");
						String codigo = "";
						if(atributoHref.contains("javascript") )
							codigo = atributoHref.substring(21, 25);
						Document document1 = Jsoup
								.connect(
								"http://academico.ifam.edu.br/qacademico/biblioteca/detalhes_obra.asp?CODIGO="+codigo+"&SIT=DISP&T=0").get();
						//System.out.println("diferenca: " +atributoHref.substring(21, 25));
						//System.out.println(contentTD.select("div>a").attr("href"));
						
					}
				}
			}
		}
	}
}




