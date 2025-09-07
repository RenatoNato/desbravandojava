package livraria;

public class ContinueBreak {
	public static void main(String[] args) {

		for (int i = 0; i <= 10; i++) {
			if (i == 7) {
				continue;
			}
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 0; i <= 10; i++) {
			if (i == 7) {
				break;
			}

			System.out.print(i + " ");
		}

	}

}
