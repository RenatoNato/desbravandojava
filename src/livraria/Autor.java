package livraria;

public class Autor {

	private String nome;
	private String email;
	private String cpf;
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	void mostrarDetalhes() {

		System.out.println("Mostrando dados do Autor: ");
		System.out.println("Nome Autor: " + nome);
		System.out.println("CPF do Autor: " + cpf);
		System.out.println("E-mail do Autor: " + email);
	}
}
