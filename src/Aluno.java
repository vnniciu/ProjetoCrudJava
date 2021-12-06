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
	@Override
	public String toString()
	{
		return " Nome: "+ getNome() + "\n Telefone: " +  getTelefone() 
		+ "\n Data de nascimento: "+ getDataNascimento() 
		+ "\n DataCadastro: " +  getDataCadastro() +  "\n Data da ultima atualizacao: " + getDataUltimaAtualizacao()
		+ "\n Nota final do curso: " + getNotaFinalCurso()+ "\n\n" ;  
	}

}
