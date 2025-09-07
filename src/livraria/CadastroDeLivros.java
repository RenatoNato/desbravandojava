package livraria;

public class CadastroDeLivros {

	public static void main(String[] args) {

		Autor autor = new Autor();
		autor.setNome("Renato Cézar");
		autor.setEmail("renatocezarsilva@hotmail.com");
		autor.setCpf("019.892.675-80");
		
		Livro livro = new Livro(autor);
		livro.setNome("Java 8 prático");
		livro.setDescricao("Novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");
		
		//autor.mostrarDetalhes();
		
		livro.mostrarDetalhes();
		
		
		Ebook ebook = new Ebook(autor);
		ebook.setNome("Teste porra");
		ebook.mostrarDetalhes();		
		
		
		Livro outoLivro = new Livro(autor);
		outoLivro.setNome("Fuafa de férias");
		outoLivro.setDescricao("Fuleiragem");
		outoLivro.setValor(59.90);
		outoLivro.setIsbn("978-85-66250-46-6");
		outoLivro.mostrarDetalhes();
		
	}
}
