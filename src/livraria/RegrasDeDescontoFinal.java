package livraria;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

public class RegrasDeDescontoFinal {

	private static final int WIDTH = 32; // largura das linhas do cupom
	private static final String SEP = "=".repeat(WIDTH);
	private static final String SUB = "-".repeat(WIDTH);

	public static void main(String[] args) {
		Autor autor = new Autor();
		autor.setNome("Renato Cézar");

		// Moeda no padrão BR
		DecimalFormatSymbols br = new DecimalFormatSymbols(new Locale("pt", "BR"));
		DecimalFormat df = new DecimalFormat("#,##0.00", br);

		// Data/hora e código de autenticação
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataHora = LocalDateTime.now().format(dtf);
		String codigoAutenticacao = UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase();

		// Cabeçalho
		System.out.println(SEP);
		System.out.println(center("LIVRARIA JAVA LTDA", WIDTH));
		System.out.println(center("CNPJ: 12.345.678/0001-99", WIDTH));
		System.out.println(center("CUPOM FISCAL ELETRÔNICO", WIDTH));
		System.out.println("Data: " + dataHora);
		System.out.println(SEP);

		double totalCompra = 0.0;
		double totalEconomia = 0.0;

		// LIVRO
		Livro livro = new Livro(autor);
		livro.setValor(59.90);
		double descLivro = 0.30;
		double valorOrigLivro = livro.getValor();

		if (livro.aplicaDescontoDe(descLivro)) {
			double econ = valorOrigLivro - livro.getValor();
			totalCompra += livro.getValor();
			totalEconomia += econ;

			printItem("LIVRO", valorOrigLivro, livro.getValor(), (int) (descLivro * 100), econ, df);
		}

		// EBOOK
		Ebook ebook = new Ebook(autor);
		ebook.setValor(29.90);
		double descEbook = 0.15;
		double valorOrigEbook = ebook.getValor();

		if (ebook.aplicaDescontoDe(descEbook)) {
			double econ = valorOrigEbook - ebook.getValor();
			totalCompra += ebook.getValor();
			totalEconomia += econ;

			printItem("EBOOK", valorOrigEbook, ebook.getValor(), (int) (descEbook * 100), econ, df);
		}

		// Totais com destaque centralizado
		System.out.println(SEP);
		System.out.println(center("** TOTAL DA COMPRA **", WIDTH));
		System.out.println(center("R$ " + df.format(totalCompra), WIDTH));
		System.out.println(center("(Você economizou: R$ " + df.format(totalEconomia) + ")", WIDTH));
		System.out.println(SEP);
		System.out.println(center("Obrigado pela preferência!", WIDTH));
		System.out.println(center("Volte sempre :)", WIDTH));
		System.out.println(SEP);

		// Autenticação + QR ASCII
		System.out.println("Autenticação: " + codigoAutenticacao);
		System.out.println(SEP);
		System.out.println("      █▀▀▀▀▀▀▀█ █▀▀▀▀▀▀▀█      ");
		System.out.println("      █ ███ █ █ █ ███ █ █      ");
		System.out.println("      █ ▀▀▀ █▀█ █ ▀▀▀ █▀█      ");
		System.out.println("      █ ▄▄▄ █▀█ █ ▄▄▄ █▀█      ");
		System.out.println("      █▄▄▄▄▄▄▄█ █▄▄▄▄▄▄▄█      ");
		System.out.println(center("(QR Code)", WIDTH));
		System.out.println(SEP);
	}

	private static void printItem(String titulo, double valorOriginal, double valorComDesconto, int percentual,
			double economia, DecimalFormat df) {
		System.out.println(center("== " + titulo + " ==", WIDTH));
		System.out.printf("%-15s R$ %8s%n", "Preço", df.format(valorOriginal));
		System.out.printf("%-15s R$ %8s (%d%%)%n", "Com desconto", df.format(valorComDesconto), percentual);
		System.out.printf("%-15s R$ %8s%n", "Você economizou", df.format(economia));
		System.out.println(SUB);
	}

	private static String center(String text, int width) {
		if (text.length() >= width)
			return text;
		int pad = (width - text.length()) / 2;
		return " ".repeat(pad) + text;

	}

}
