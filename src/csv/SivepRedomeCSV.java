package csv;

public class SivepRedomeCSV {
	
	private String identificacao;
	private String nomeCompleto;
	private String dataNascimento;
	private String municipio;
	private String campo1;
	private String sexo;
	private String racaCor;
	private String dataInternacao;
	private String dataEncerramento;
	private String evolucaoCaso;
	
	public SivepRedomeCSV() {
		
	}

	public SivepRedomeCSV(String identificacao, String nomeCompleto, String dataNascimento, String municipio,
			String campo1, String sexo, String racaCor, String dataInternacao, String dataEncerramento,
			String evolucaoCaso) {
		super();
		this.identificacao = identificacao;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.municipio = municipio;
		this.campo1 = campo1;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.dataInternacao = dataInternacao;
		this.dataEncerramento = dataEncerramento;
		this.evolucaoCaso = evolucaoCaso;
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

	public String getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getEvolucaoCaso() {
		return evolucaoCaso;
	}

	public void setEvolucaoCaso(String evolucaoCaso) {
		this.evolucaoCaso = evolucaoCaso;
	}

	@Override
	public String toString() {
		return "SivepRedomeCSV [identificacao=" + identificacao + ", nomeCompleto=" + nomeCompleto + ", dataNascimento="
				+ dataNascimento + ", municipio=" + municipio + ", campo1=" + campo1 + ", sexo=" + sexo + ", racaCor="
				+ racaCor + ", dataInternacao=" + dataInternacao + ", dataEncerramento=" + dataEncerramento
				+ ", evolucaoCaso=" + evolucaoCaso + "]";
	}

}
