package exceptions;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		int opcao = 1;
		
		while (opcao != 3) {
			opcao = obterOpcaoMenu(input);
			
			if (opcao == 1) {
				
				adicionarContato(input, agenda);
			} else if (opcao == 2) {
				String nomeContato = leInformacaoString(input, "Entre com o contato a ser consultado: ");
				try {
					if (agenda.consultarContato(nomeContato) >= 0) {
						System.out.println("O Contato existe!");
					}
				} catch (ContatoNaoExisteException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		if(opcao == 3) {
			System.out.println("Saindo..");
			System.exit(0);
		}
		
		input.close();
	}
	
	public static void adicionarContato(Scanner input, Agenda agenda) {
		System.out.println("Criando um contato, entre com as informações: ");
		String nomeContato = leInformacaoString(input, "Entre com o nome do contato a ser cadastrado: ");
		String telefone = leInformacaoString(input, "Entre com o telefone do contato a ser cadastrado: ");
		String email = leInformacaoString(input, "Entre com o email do contato a ser cadastrado: ");
		
		Contato contato = new Contato();
		contato.setNome(nomeContato);
		contato.setTelefone(telefone);
		contato.setEmail(email);
		
		System.out.println("O contato a ser criado é: ");
		System.out.println(contato);
	
		try {
			agenda.adicionarContato(contato);
		} catch (AgendaCheiaException e) {
			System.out.println(e.getMessage());
			
			System.out.println("Contatos da Agenda");
			System.out.println(agenda);
		}
		
	}
	
	public static String leInformacaoString(Scanner scan, String msg) {
		System.out.println(msg);
		String entrada = scan.nextLine();
		return entrada;
	}
	
	public static int obterOpcaoMenu(Scanner input) {
		
		boolean entradaValida = false;
		int opcao = 3;
		
		while(!entradaValida) {
			System.out.println("--------MENU--------");
			System.out.println("1: Adicionar contato");
			System.out.println("2: Consultar contato");
			System.out.println("3: Sair");
			System.out.println("Digite a opção desejada: ");
		
			try {
				String entrada = input.nextLine();
				opcao = Integer.parseInt(entrada);
				if(opcao == 1 || opcao == 2 || opcao == 3) {
					entradaValida = true;
				} else {
					throw new Exception("Entrada Inválida");
				}
			} catch (Exception e) {
				System.out.println("Entrada Inválida, digite novamente!\n");
			}
		
		}
		
		return opcao;
	}

}
