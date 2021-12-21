package view;

import java.util.Scanner;

import controller.CrudController;

public class Tela {
	
	private static Scanner sc;
	
	public static void menu()
	{
		System.out.println("----------------------------------MENU---------------------------------\n");
		System.out.println("				DIGITE\n");
		System.out.println("	1 	para Cadastrar Pessoa ou Aluno");
		System.out.println("	2 	para Listar todas as pessoas e alunos");
		System.out.println("	3 	para Atualizar Pessoa ou Aluno");
		System.out.println("	4 	para Deletar Pessoa ou Aluno");
		System.out.println("	0 	para sair do programa\n");
		System.out.println("-------------------------------------------------------------------");
		
	}
	
	public static int capturaOpcao()
	{
		int opcao = -1;
		sc = new Scanner(System.in);
		try {
		
			opcao = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Digito Invalido, por favor digite um valor numerico");
		}
		return opcao;
	}

	public static void executaMenu()
	{
		menu();
		int opcao = capturaOpcao();
		while(opcao!=0)
		{
			switch (opcao)
			{
				
				case 1:
					CrudController.cadastrar();
					
				break;
				
				case 2:
					CrudController.listar();
					
				break;
				
				case 3:
					CrudController.alterar();
					
				break;
				
				case 4:
					CrudController.excluir();
					
				break;
				
				default:
					System.out.println("Digito Errado! Digite um valor entre 0 e 4\n");
					
			}
			menu();
			opcao = capturaOpcao();
		}
		
	}
}
