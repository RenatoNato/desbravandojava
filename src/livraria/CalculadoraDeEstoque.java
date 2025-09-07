package livraria;

public class CalculadoraDeEstoque {
	public static void main(String[] args) {

		double soma = 0.0;
		int contador = 0;

		while (contador < 35) {
			double valorDoLivro = 59.90;
			soma += valorDoLivro;
			contador++;
		}

		// 1) imprime sempre o total
		System.out.printf("Total em estoque é %.13f%n", soma); // usa 13 casas para mostrar a imprecisão do double

		// 2) depois imprime a situação do estoque
		if (soma >= 2000) {
			System.out.println("Seu estoque está muito alto!");
		} else if (soma < 150) {
			System.out.println("Seu estoque está muito baixo!");
		} else {
			System.out.println("Seu estoque está bom");
		}

		// Ou podemos usar a expressão booleana
		// boolean resultado = soma < 150;

		// Exemplo de uso operador ternário:
		// double valor = v1 > v2 ? 100 : 0

		soma = 0;
		for (int i = 0; i < 35; i++) {
			soma += 59.90;
		}

		// 1) imprime sempre o total
		System.out.printf("Total em estoque é %.13f%n", soma); // usa 13 casas para mostrar a imprecisão do double

		// 2) depois imprime a situação do estoque
		if (soma >= 2000) {
			System.out.println("Seu estoque está muito alto!");
		} else if (soma < 150) {
			System.out.println("Seu estoque está muito baixo!");
		} else {
			System.out.println("Seu estoque está bom");
		}

	}
}
