import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa {

	private float notaFinalCurso;
	
	public Aluno(String nome, String telefone, Date dataNascimento, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, float notaFinalCurso) 
	{
		
		super(nome, telefone, dataNascimento, dataCadastro, dataUltimaAtualizacao);
		this.notaFinalCurso = notaFinalCurso;
		
	}
	
	public Aluno(String nome)
	{
		super(nome);
	}

	public float getNotaFinalCurso() {
		return notaFinalCurso;
	}

	public void setNotaFinalCurso(float notaFinalCurso) {
		this.notaFinalCurso = notaFinalCurso;
	}
	public String toString()
	{
		return "Nome: "+ getNome() + " Telefone: " +  getTelefone() 
		+ " Data de nascimento: "+ getDataNascimento() 
		+ " DataCadastro: " +  getDataCadastro() +  " Data da ultima atualizacao: " + getDataUltimaAtualizacao()
		+ " Nota final do curso: " + getNotaFinalCurso() ;  
	}

}
