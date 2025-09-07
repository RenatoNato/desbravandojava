package livraria;

public class CarrinhoDeCompras {

    private double total;

    public void adiciona(Livro livro) {
        System.out.println("Adicionando: " + livro.getClass().getSimpleName());
        System.out.println();

        boolean aplicado = livro.aplicaDescontoDe(0.16); // 16%

        if (aplicado) {
            System.out.println(">>> Desconto aplicado para " + livro.getClass().getSimpleName());
        } else {
            System.out.println(">>> Desconto NÃO aplicado para " + livro.getClass().getSimpleName());
        }

        total += livro.getValor();
    }

    public double getTotal() {
        return total;
    }
}
