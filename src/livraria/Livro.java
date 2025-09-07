package livraria;

public class Livro {

	private String nome;
	private String descricao;
	private double valor;
	private String isbn;
	private Autor autor;
	private static int contador;

	public Livro(Autor autor) {
		this.setAutor(autor);
		this.setIsbn("000-00-00000-00-0");
		contador++;
	}

	boolean temAutor() {
		return this.autor != null;
	}

	public boolean aplicaDescontoDe(double porcentagem) {
		if (porcentagem > 0.3) {
			System.out.println("Desconto NÃO aplicado no Livro (limite 30%)");
			return false;
		}
		this.valor -= this.valor * porcentagem;
		System.out.println("Aplicando desconto no Livro");
		return true;
	}

	// getters/setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Livro.contador = contador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	void mostrarDetalhes() {
		System.out.println("\nMostrando detalhes do livro ");
		System.out.println("Nome: " + nome);
		System.out.println("Descrição: " + descricao);
		System.out.println("Valor: " + getValor());
		System.out.println("ISBN: " + isbn + "\n");

		if (this.temAutor())
			autor.mostrarDetalhes();
		else
			System.out.println("Não foi encontrado o Autor");

		System.out.println("--\n");
		System.out.println("Novo livro criado!\nTotal de livros vendidos: " + contador);
		System.out.println("--\n");
	}
}
