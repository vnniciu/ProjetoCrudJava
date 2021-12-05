import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Crud {
	private static List<Pessoa> pessoaList = new ArrayList<Pessoa>();
	private static List<Aluno> alunoList = new ArrayList<Aluno>();
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
					cadastrar();
					
				break;
				
				case 2:
					listar();
					
				break;
				
				case 3:
					System.out.println("Atualizando");
					
				break;
				
				case 4:
					System.out.println("Deletando");
					
				break;
				
				default:
					System.out.println("Digito Errado! Digite um valor entre 0 e 4\n");
					
			}
			menu();
			opcao = capturaOpcao();
		}
		
	}
	
	public static void cadastrar()
	{
		System.out.println("Digite o nome da pessoa/aluno: ");
		String nome = sc.next();
		System.out.println("Digite o telefone da pessoa/aluno: ");
		String telefone = sc.next();
		System.out.println("Digite a data de nascimento da pessoa/aluno: ");
		String dataNascimento = sc.next();
		Date dataNascimentoFormatada = null;
		try {
			dataNascimentoFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate dataCadastro = java.time.LocalDate.now();
		LocalDate dataUltimaAtualizacao = java.time.LocalDate.now();
		System.out.println("Digite a nota final do aluno no curso:");
		String notaFinalSc = sc.next();
		
		if(notaFinalSc== null)
		{
			Pessoa pessoa = new Pessoa(nome, telefone, dataNascimentoFormatada, dataCadastro, dataUltimaAtualizacao);
			pessoaList.add(pessoa);
			
		}
		else {
			float notaFinal = Float.parseFloat(notaFinalSc);
			Aluno aluno = new Aluno(nome, telefone, dataNascimentoFormatada, dataCadastro, dataUltimaAtualizacao, notaFinal);
			alunoList.add(aluno);
		}
		
	}
	public static void listar() {
		for	(Aluno a : alunoList)
		{
			System.out.println(a);
		}
	}
}
