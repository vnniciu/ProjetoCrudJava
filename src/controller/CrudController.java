package controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.Pessoa;

public class CrudController {
	private static List<Pessoa> pessoaList = new ArrayList<Pessoa>();
	private static Scanner sc;
	
	public static String capturaString(String mensagem)
	{
		System.out.println(mensagem);
		sc = new Scanner(System.in);
		String resposta = sc.next();
		return resposta;
	}
	
	public static Date formataData(String data)
	{
		Date dataFormatada = null;
		try {
			dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	
	public static void cadastrar()
	{
		String nome = capturaString("Digite o nome da pessoa/aluno: ");
		String telefone = capturaString("Digite o telefone da pessoa/aluno: ");
		String dataNascimento = capturaString("Digite a data de nascimento da pessoa/aluno: ");
		Date dataNascimentoFormatada = formataData(dataNascimento);
		LocalDate dataCadastro = java.time.LocalDate.now();
		LocalDate dataUltimaAtualizacao = java.time.LocalDate.now();
		String notaFinalSc= null;
		String respostaNota = capturaString("Deseja adicionar a nota do final do curso? Digite 's' para sim e 'n' para nao");
		if(respostaNota.equals("s"))
		{
			notaFinalSc = capturaString("Digite a nota final do aluno no curso:");
			float notaFinal = Float.parseFloat(notaFinalSc);
			Aluno aluno = new Aluno(nome, telefone, dataNascimentoFormatada, dataCadastro, dataUltimaAtualizacao, notaFinal);
			pessoaList.add((Aluno)aluno);
		}
		else {
			Pessoa pessoa = new Pessoa(nome, telefone, dataNascimentoFormatada, dataCadastro, dataUltimaAtualizacao);
			pessoaList.add(pessoa);
		}
	}
	
	public static void listar() {
		if(pessoaList.isEmpty())
		{
			System.out.println("Lista Vazia!");
		}
		else {
			for	(Pessoa p : pessoaList)
			{
				System.out.println(p);
			}
		}
	}

	public static void alterar()
	{
		String nome = capturaString("Digite o nome da pessoa/aluno que deseja fazer alteracoes no cadastro:");
		boolean encontrado = false;
		if(encontrado == false)
		{
			for(Pessoa p : pessoaList)
			{
				if(p.getNome().equals(nome))
				{
					encontrado = true;
					p.setNome(capturaString("Digite o novo nome da pessoa"));
					p.setTelefone(capturaString("Digite o telefone atualizado da pessoa"));
					String dataNascimento = capturaString("Digite a data de nascimento correta da pessoa");
					Date dataNascimentoFormatada = formataData(dataNascimento);
					p.setDataNascimento(dataNascimentoFormatada);
					LocalDate dataUltimaAtualizacao = java.time.LocalDate.now();
					p.setDataUltimaAtualizacao(dataUltimaAtualizacao);
					if(p instanceof Aluno)
					{
						((Aluno) p).setNotaFinalCurso(Float.parseFloat(capturaString("Digite corretamente a nota final do curso:"))); 
					}
				}
			}
		}
		else {
			System.out.println("Pessoa/Aluno(a) não encontrado(a)");
		}
	}
	
	public static void excluir()
	{
		String nome = capturaString("Digite o nome da pessoa/aluno que deseja excluir");
		boolean encontrado = false;
		Iterator<Pessoa> p = pessoaList.iterator();
		while(p.hasNext())
		{
			Pessoa pessoa = p.next();
			if(pessoa.getNome().equals(nome))
			{
				encontrado = true;		
				p.remove();
			}
		}
		if(encontrado!=true){
			System.out.println("Aluno não encontrado");
		}
	}
}