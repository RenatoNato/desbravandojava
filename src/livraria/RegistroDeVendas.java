package livraria;

public class RegistroDeVendas {
    public static void main(String[] args) {

        Autor autor = new Autor();
        autor.setNome("Renato Cézar");

        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Test-Driven Development");
        fisico.setValor(59.90);

        Ebook ebook = new Ebook(autor);
        ebook.setNome("Test-Driven Development");
        ebook.setValor(29.90);

        CarrinhoDeComprasFinal carrinho = new CarrinhoDeComprasFinal();

        // 1) Usa desconto padrão (16%)
        carrinho.adiciona(fisico);

        // 2) Define um desconto específico por item (ex.: 12% para ebook)
        carrinho.adiciona(ebook, 0.12);

        carrinho.imprimeResumo();
    }
}
