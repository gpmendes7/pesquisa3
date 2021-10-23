package csv;

public class SivepRedomeModificadoCSV {
	
	private String identificacao;
	private String nomeCompleto;
	private String dataNascimento;
	private String idade;
	private String municipio;
	private String campo1;
	private String sexo;
	private String racaCor;
	private String dataInternacao;
	private String dataInternacaoRedome;
	private String dataEncerramento;
	private String dataEncerramentoRedome;
	private String evolucaoCaso;
	private String evolucaoCasoRedome;
	private String dataNotificacao;
	private String resultadoTeste;
	
	public SivepRedomeModificadoCSV() {
		
	}

	public SivepRedomeModificadoCSV(String identificacao, String nomeCompleto, String dataNascimento, String idade, String municipio,
			String campo1, String sexo, String racaCor, String dataInternacao, String dataInternacaoRedome,
			String dataEncerramento, String dataEncerramentoRedome, String evolucaoCaso, String evolucaoCasoRedome,
			String dataNotificacao, String resultadoTeste) {
		this.identificacao = identificacao;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.municipio = municipio;
		this.campo1 = campo1;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.dataInternacao = dataInternacao;
		this.dataInternacaoRedome = dataInternacaoRedome;
		this.dataEncerramento = dataEncerramento;
		this.dataEncerramentoRedome = dataEncerramentoRedome;
		this.evolucaoCaso = evolucaoCaso;
		this.evolucaoCasoRedome = evolucaoCasoRedome;
		this.dataNotificacao = dataNotificacao;
		this.resultadoTeste = resultadoTeste;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getIdade() {
		return idade;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}

	public String getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(String dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

	public String getDataInternacaoRedome() {
		return dataInternacaoRedome;
	}

	public void setDataInternacaoRedome(String dataInternacaoRedome) {
		this.dataInternacaoRedome = dataInternacaoRedome;
	}

	public String getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getDataEncerramentoRedome() {
		return dataEncerramentoRedome;
	}

	public void setDataEncerramentoRedome(String dataEncerramentoRedome) {
		this.dataEncerramentoRedome = dataEncerramentoRedome;
	}

	public String getEvolucaoCaso() {
		return evolucaoCaso;
	}

	public void setEvolucaoCaso(String evolucaoCaso) {
		this.evolucaoCaso = evolucaoCaso;
	}

	public String getEvolucaoCasoRedome() {
		return evolucaoCasoRedome;
	}

	public void setEvolucaoCasoRedome(String evolucaoCasoRedome) {
		this.evolucaoCasoRedome = evolucaoCasoRedome;
	}

	public String getDataNotificacao() {
		return dataNotificacao;
	}

	public void setDataNotificacao(String dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}

	public String getResultadoTeste() {
		return resultadoTeste;
	}

	public void setResultadoTeste(String resultadoTeste) {
		this.resultadoTeste = resultadoTeste;
	}
	
}
