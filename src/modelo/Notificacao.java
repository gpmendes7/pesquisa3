package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroNotificacao;
	private String nomeCompleto;
	private String cpf;
	private Date dataNotificacao;
	private Date dataInicioSintomas;
	private Date dataNascimento;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String estado;
	private String estrangeiro;
	private String passaporte;
	private String paisOrigem;
	private String profissionalSeguranca;
	private String profissionalSaude;
	private String cbo;
	private String cns;
	private String nomeMae;
	private String sexo;
	private String racaCor;
	private String telefoneCelular;
	private String telefoneContato;
	private String febre;
	private String tosse;
	private String dorGarganta;
	private String dispneia;
	private String outrosSintomas;
	private String descricaoOutros;
	private String doencasRespiratorias;
	private String doencasRenais;
	private String fragilidadeImunologica;
	private String diabetes;
	private String imunosupressao;
	private String doencasCardiacas;
	private String gestanteAltoRisco;
	private String origem;
	private String latitude;
	private String longitude;
	private String cnes;
	private String idade;
	private String estadoTeste;
	private Date dataTeste;
	private String tipoTeste;
	private String resultadoTeste;
	private Date dataInternacao;
	private Date dataEncerramento;
	private String evolucaoCaso;
	private String classificacaoFinal;
	private boolean descartada;
	@ManyToOne
	private Paciente paciente;

	public Notificacao() {
	}

	public Notificacao(String numeroNotificacao, String nomeCompleto, String cpf, Date dataNotificacao,
			Date dataInicioSintomas, Date dataNascimento, String cep, String logradouro, String numero,
			String complemento, String bairro, String municipio, String estado, String estrangeiro, String passaporte,
			String paisOrigem, String profissionalSeguranca, String profissionalSaude, String cbo, String cns,
			String nomeMae, String sexo, String racaCor, String telefoneCelular, String telefoneContato, String febre,
			String tosse, String dorGarganta, String dispneia, String outrosSintomas, String descricaoOutros,
			String doencasRespiratorias, String doencasRenais, String fragilidadeImunologica, String diabetes,
			String imunosupressao, String doencasCardiacas, String gestanteAltoRisco, String origem, String latitude,
			String longitude, String cnes, String idade, String estadoTeste, Date dataTeste, String tipoTeste,
			String resultadoTeste, Date dataInternacao, Date dataEncerramento, String evolucaoCaso,
			String classificacaoFinal, boolean descartada) {
		super();
		this.numeroNotificacao = numeroNotificacao;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataNotificacao = dataNotificacao;
		this.dataInicioSintomas = dataInicioSintomas;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.estrangeiro = estrangeiro;
		this.passaporte = passaporte;
		this.paisOrigem = paisOrigem;
		this.profissionalSeguranca = profissionalSeguranca;
		this.profissionalSaude = profissionalSaude;
		this.cbo = cbo;
		this.cns = cns;
		this.nomeMae = nomeMae;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.telefoneCelular = telefoneCelular;
		this.telefoneContato = telefoneContato;
		this.febre = febre;
		this.tosse = tosse;
		this.dorGarganta = dorGarganta;
		this.dispneia = dispneia;
		this.outrosSintomas = outrosSintomas;
		this.descricaoOutros = descricaoOutros;
		this.doencasRespiratorias = doencasRespiratorias;
		this.doencasRenais = doencasRenais;
		this.fragilidadeImunologica = fragilidadeImunologica;
		this.diabetes = diabetes;
		this.imunosupressao = imunosupressao;
		this.doencasCardiacas = doencasCardiacas;
		this.gestanteAltoRisco = gestanteAltoRisco;
		this.origem = origem;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cnes = cnes;
		this.idade = idade;
		this.estadoTeste = estadoTeste;
		this.dataTeste = dataTeste;
		this.tipoTeste = tipoTeste;
		this.resultadoTeste = resultadoTeste;
		this.dataInternacao = dataInternacao;
		this.dataEncerramento = dataEncerramento;
		this.evolucaoCaso = evolucaoCaso;
		this.classificacaoFinal = classificacaoFinal;
		this.descartada = descartada;
	}



	public String getNumeroNotificacao() {
		return numeroNotificacao;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNotificacao() {
		return dataNotificacao;
	}

	public Date getDataInicioSintomas() {
		return dataInicioSintomas;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getEstado() {
		return estado;
	}

	public String getEstrangeiro() {
		return estrangeiro;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public String getProfissionalSeguranca() {
		return profissionalSeguranca;
	}

	public String getProfissionalSaude() {
		return profissionalSaude;
	}

	public String getCbo() {
		return cbo;
	}

	public String getCns() {
		return cns;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getSexo() {
		return sexo;
	}

	public String getRacaCor() {
		return racaCor;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public String getFebre() {
		return febre;
	}

	public String getTosse() {
		return tosse;
	}

	public String getDorGarganta() {
		return dorGarganta;
	}

	public String getDispneia() {
		return dispneia;
	}

	public String getOutrosSintomas() {
		return outrosSintomas;
	}

	public String getDescricaoOutros() {
		return descricaoOutros;
	}

	public String getDoencasRespiratorias() {
		return doencasRespiratorias;
	}

	public String getDoencasRenais() {
		return doencasRenais;
	}

	public String getFragilidadeImunologica() {
		return fragilidadeImunologica;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public String getImunosupressao() {
		return imunosupressao;
	}

	public String getDoencasCardiacas() {
		return doencasCardiacas;
	}

	public String getGestanteAltoRisco() {
		return gestanteAltoRisco;
	}

	public String getOrigem() {
		return origem;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getCnes() {
		return cnes;
	}

	public String getIdade() {
		return idade;
	}

	public String getEstadoTeste() {
		return estadoTeste;
	}

	public Date getDataTeste() {
		return dataTeste;
	}

	public String getTipoTeste() {
		return tipoTeste;
	}

	public String getResultadoTeste() {
		return resultadoTeste;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public String getEvolucaoCaso() {
		return evolucaoCaso;
	}

	public String getClassificacaoFinal() {
		return classificacaoFinal;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public boolean ehDescartada() {
		return descartada;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDescartada(boolean descartada) {
		this.descartada = descartada;
	}

	@Override
	public String toString() {
		return "Notificacao [numeroNotificacao=" + numeroNotificacao + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf
				+ ", dataNotificacao=" + dataNotificacao + ", dataInicioSintomas=" + dataInicioSintomas
				+ ", dataNascimento=" + dataNascimento + ", cep=" + cep + ", logradouro=" + logradouro + ", numero="
				+ numero + ", complemento=" + complemento + ", bairro=" + bairro + ", municipio=" + municipio
				+ ", estado=" + estado + ", estrangeiro=" + estrangeiro + ", passaporte=" + passaporte + ", paisOrigem="
				+ paisOrigem + ", profissionalSeguranca=" + profissionalSeguranca + ", profissionalSaude="
				+ profissionalSaude + ", cbo=" + cbo + ", cns=" + cns + ", nomeMae=" + nomeMae + ", sexo=" + sexo
				+ ", racaCor=" + racaCor + ", telefoneCelular=" + telefoneCelular + ", telefoneContato="
				+ telefoneContato + ", febre=" + febre + ", tosse=" + tosse + ", dorGarganta=" + dorGarganta
				+ ", dispneia=" + dispneia + ", outrosSintomas=" + outrosSintomas + ", descricaoOutros="
				+ descricaoOutros + ", doencasRespiratorias=" + doencasRespiratorias + ", doencasRenais="
				+ doencasRenais + ", fragilidadeImunologica=" + fragilidadeImunologica + ", diabetes=" + diabetes
				+ ", imunosupressao=" + imunosupressao + ", doencasCardiacas=" + doencasCardiacas
				+ ", gestanteAltoRisco=" + gestanteAltoRisco + ", origem=" + origem + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", cnes=" + cnes + ", idade=" + idade + ", estadoTeste=" + estadoTeste
				+ ", dataTeste=" + dataTeste + ", tipoTeste=" + tipoTeste + ", resultadoTeste=" + resultadoTeste
				+ ", dataInternacao=" + dataInternacao + ", dataEncerramento=" + dataEncerramento + ", evolucaoCaso="
				+ evolucaoCaso + ", classificacaoFinal=" + classificacaoFinal + "]";
	}

	public boolean pertenceAoPaciente(Paciente paciente) {
		boolean temMesmoNomeCompleto = this.nomeCompleto != null && !this.nomeCompleto.equals("")
				&& this.nomeCompleto.equals(paciente.getNomeCompleto());
		boolean temMesmaDataNascimento = this.dataNascimento != null
				&& this.dataNascimento.equals(paciente.getDataNascimento());

		return temMesmoNomeCompleto && temMesmaDataNascimento;
	}

	public boolean temNomeECPF() {
		return this.nomeCompleto != null && !this.nomeCompleto.equals("") && this.cpf != null && !this.cpf.equals("");
	}
	
	public boolean temNome() {
		return this.nomeCompleto != null && !this.nomeCompleto.equals("");
	}
	
	public boolean temCPF() {
		return this.cpf != null && !this.cpf.equals("");
	}

	public boolean temNomeInformadoComNumeros() {
		String padrao = "\\d+";
		return this.nomeCompleto != null && !this.nomeCompleto.equals("") && this.nomeCompleto.matches(padrao);
	}
	
	public boolean ehCopiaDe(Notificacao notificacao) {
		return     temMesmoNomeCompleto(notificacao) 
				&& temMesmaDataNotificacao(notificacao) 
				&& temMesmaClassificacaoFinal(notificacao)
				&& temMesmaEvolucaoCaso(notificacao) 
				&& temMesmaDataInternacao(notificacao)
				&& temMesmaDataEncerramento(notificacao);
	}
	
	private boolean temMesmoNomeCompleto(Notificacao notificacao) {
		  String nomeCompleto1 = this.getNomeCompleto();
		  String nomeCompleto2 = notificacao.getNomeCompleto();
		  
		  if(nomeCompleto1 != null && nomeCompleto2 != null 
		  && nomeCompleto1.equals(nomeCompleto2)) {
			  return true;
		  } 
		  
		  return false;
	}
	
	private boolean temMesmaDataNotificacao(Notificacao notificacao) {
		  Date dataNotificacao1 = this.getDataNotificacao();
		  Date dataNotificacao2 = notificacao.getDataNotificacao();
		  
		  if(dataNotificacao1 != null && dataNotificacao2 != null 
		  && dataNotificacao1.equals(dataNotificacao2)) {
			  return true;
		  } 
		  
		  return false;
	}
	
	private boolean temMesmaClassificacaoFinal(Notificacao notificacao) {
		  String classificacaoFinal1 = this.getClassificacaoFinal();
		  String classificacaoFinal2 = notificacao.getClassificacaoFinal();
		  
		  if(classificacaoFinal1 != null && classificacaoFinal2 != null 
		  && classificacaoFinal1.equals(classificacaoFinal2)) {
			  return true;
		  } 
		  
		  return false;
	}
	
	private boolean temMesmaEvolucaoCaso(Notificacao notificacao) {
		  String evolucaoCaso1 = this.getEvolucaoCaso();
		  String evolucaoCaso2 = notificacao.getEvolucaoCaso();
		  
		  if(evolucaoCaso1 != null && evolucaoCaso2 != null 
		  && evolucaoCaso1.equals(evolucaoCaso2)) {
			  return true;
		  } 
		  
		  return false;
	}

	private boolean temMesmaDataEncerramento(Notificacao notificacao) {
		  Date dataEncerramento1 = this.getDataEncerramento();
		  Date dataEncerramento2 = notificacao.getDataEncerramento();
		  
		  if(dataEncerramento1 != null && dataEncerramento2 != null 
		  && dataEncerramento1.equals(dataEncerramento2)) {
			  return true;
		  }
		  
		  return false;
	}
	
	private boolean temMesmaDataInternacao(Notificacao notificacao) {
		  Date dataInternacao1 = this.getDataInternacao();
		  Date dataInternacao2 = notificacao.getDataInternacao();
		  
		  if(dataInternacao1 != null && dataInternacao2 != null 
		  && dataInternacao1.equals(dataInternacao2)) {
			  return true;
		  }
		  
		  return false;
	}

}
