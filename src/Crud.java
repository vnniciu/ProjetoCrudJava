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
					alterar();
					
				break;
				
				case 4:
					excluir();
					
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
		String notaFinalSc= null;
		System.out.println("Deseja adicionar a nota do final do curso? Digite 's' para sim e 'n' para nao");
		String respostaNota = sc.next();
		if(respostaNota.equals("s"))
		{
			System.out.println("Digite a nota final do aluno no curso:");
			notaFinalSc = sc.next();
		}
		
		
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
		System.out.println("Alunos:");
		for	(Aluno a : alunoList)
		{
			System.out.println(a);
		}
		System.out.println("\nPessoas");
		for	(Pessoa p : pessoaList)
		{
			System.out.println(p);
		}
	}


	public static void alterar()
	{
		System.out.println("Digite o nome da pessoa/aluno que deseja fazer alteracoes no cadastro:");
		String nome = sc.next();
		boolean encontrado = false;
		if(encontrado == false)
		{
			for(Pessoa p : pessoaList)
			{
				if(p.getNome().equals(nome))
				{
					encontrado = true;
					System.out.println("Digite o novo nome da pessoa");
					p.setNome(sc.next());
					System.out.println("Digite o telefone atualizado da pessoa");
					p.setTelefone(sc.next());
					System.out.println("Digite a data de nascimento correta da pessoa");
					String dataNascimento = sc.next();
					Date dataNascimentoFormatada = null;
					try {
						dataNascimentoFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					p.setDataNascimento(dataNascimentoFormatada);
					LocalDate dataUltimaAtualizacao = java.time.LocalDate.now();
					p.setDataUltimaAtualizacao(dataUltimaAtualizacao);
				}
			
			
			}
		}
		else {
			for(Aluno a : alunoList)
			{
				if(a.getNome().equals(nome))
				{
					encontrado = true;
					System.out.println("Digite o novo nome do aluno");
					a.setNome(sc.next());
					System.out.println("Digite o telefone atualizado do aluno");
					a.setTelefone(sc.next());
					System.out.println("Digite a data de nascimento correta do aluno");
					String dataNascimento = sc.next();
					Date dataNascimentoFormatada = null;
					try {
						dataNascimentoFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					a.setDataNascimento(dataNascimentoFormatada);
					LocalDate dataUltimaAtualizacao = java.time.LocalDate.now();
					a.setDataUltimaAtualizacao(dataUltimaAtualizacao);
				}
				else {
					System.out.println("Aluno não encontrado");
				}
			
			
			}
		}
		
	}
	
	
	public static void excluir()
	{
		System.out.println("Digite o nome da pessoa/aluno que deseja excluir");
		String nome = sc.next();
		boolean encontrado = false;
		int x = -1;
		if(encontrado == false)
		{
			for(Pessoa p : pessoaList)
			{
				if(p.getNome().equals(nome))
				{
					encontrado = true;
					x = pessoaList.indexOf(p);
					pessoaList.remove(x);
				}
			
			
			}
		}
		else {
			for(Aluno a : alunoList)
			{
				if(a.getNome().equals(nome))
				{
					encontrado = true;
					x = pessoaList.indexOf(a);
					pessoaList.remove(a);
					
				}
				else {
					System.out.println("Aluno não encontrado");
				}
			
			
			}
		}
		
	}
	
}
