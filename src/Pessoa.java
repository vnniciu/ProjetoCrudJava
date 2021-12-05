import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
	
	private String nome;
	private String telefone;
	private Date dataNascimento;
	private LocalDate dataCadastro;
	private LocalDate dataUltimaAtualizacao;
	
	public Pessoa(String nome, String telefone, Date dataNascimento, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
	public String toString()
	{
		return "Nome: "+ getNome() + " Telefone: " +  getTelefone() + " Data de nascimento: "+ getDataNascimento() + " DataCadastro: " +  getDataCadastro() +  " Data da ultima atualizacao: " + getDataUltimaAtualizacao(); 
	}
	
}
