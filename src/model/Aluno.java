package model;
import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa {

	private Float notaFinalCurso;
	
	public Aluno(String nome, String telefone, Date dataNascimento, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, Float notaFinalCurso) 
	{
		
		super(nome, telefone, dataNascimento, dataCadastro, dataUltimaAtualizacao);
		this.notaFinalCurso = notaFinalCurso;
		
	}
	
	public Aluno(String nome)
	{
		super(nome);
	}

	public Float getNotaFinalCurso() {
		return notaFinalCurso;
	}

	public void setNotaFinalCurso(Float notaFinalCurso) {
		this.notaFinalCurso = notaFinalCurso;
	}

	
	public String toString()
	{
		return "Aluno:\n Nome: "+ getNome() + "\n Telefone: " +  getTelefone() 
		+ "\n Data de nascimento: "+ getDataNascimento() 
		+ "\n DataCadastro: " +  getDataCadastro() +  "\n Data da ultima atualizacao: " + getDataUltimaAtualizacao()
		+ "\n Nota final do curso: " + getNotaFinalCurso()+ "\n\n" ;  
	}

}
