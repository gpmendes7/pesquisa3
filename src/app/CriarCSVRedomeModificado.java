package app;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.SivepRedomeCSV;
import csv.SivepRedomeCSVHandler;
import csv.SivepRedomeModificadoCSV;
import csv.SivepRedomeModificadoCSVHandler;
import modelo.Paciente;

public class CriarCSVRedomeModificado {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) throws IOException, ParseException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<SivepRedomeCSV> registros = SivepRedomeCSVHandler.carregarCSV("./arquivos/csv/SIVEP_REDOME.csv");

		emf = Persistence.createEntityManagerFactory("sivep2");
		em = emf.createEntityManager();
		
		List<Paciente> pacientes = obterPacientes(registros);
		
		em.close();
		emf.close();
		
		Set<String> chaves = new HashSet<>();
		List<SivepRedomeCSV> registrosSemCopia = new ArrayList<SivepRedomeCSV>(); 

		for (SivepRedomeCSV registro : registros) {
			String chave = registro.getNomeCompleto() + registro.getDataNascimento();
			
			if(!chaves.contains(chave)) {
				chaves.add(chave);
				registrosSemCopia.add(registro);
			}
		}
		
		List<SivepRedomeModificadoCSV> registrosModificados = new ArrayList<SivepRedomeModificadoCSV>(); 
		
		for (SivepRedomeCSV registro : registrosSemCopia) {		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Paciente paciente = pacientes.stream() .filter(p ->p.getNomeCompleto().equals(registro.getNomeCompleto()) &&
					 									   sdf.format(p.getDataNascimento()).equals(registro.getDataNascimento()))
					 								.collect(Collectors.toList()).get(0);
			
			String dataEncerramento = paciente.getDataEncerramento() != null ? sdf.format(paciente.getDataEncerramento()) : null;
			String dataInternacao = paciente.getDataInternacao() != null ? sdf.format(paciente.getDataInternacao()) : null;

			 
			SivepRedomeModificadoCSV registroModificado = new SivepRedomeModificadoCSV(registro.getIdentificacao(), registro.getNomeCompleto(), registro.getDataNascimento(), calcularIdade(registro).toString(), 
																					   registro.getMunicipio(), registro.getCampo1(), registro.getSexo(), registro.getRacaCor(), 
																					   dataInternacao, registro.getDataInternacao(), 		
																					   dataEncerramento, registro.getDataEncerramento(), 		                                                                   		                                                                
					                                                                   paciente.getEvolucaoCaso(), registro.getEvolucaoCaso());
			registrosModificados.add(registroModificado);
		}
		
		registrosModificados.add(0, new SivepRedomeModificadoCSV("identificacao", "nomeCompleto", "dataNascimento", "idade", 
				                                                 "municipio", "campo1", "sexo", "racaCor", 
				                                                 "dataInternacao", "dataInternacaoRedome", 
				                                                 "dataEncerramento", "dataEncerramentoRedome", 
				                                                 "evolucaoCaso", "evolucaoCasoRedome"));
		
		SivepRedomeModificadoCSVHandler.criarCSV("./arquivos/csv/SIVEP_REDOME(Modificado).csv", registrosModificados);
	}
	
	private static Integer calcularIdade(SivepRedomeCSV registro) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataEncerramento = registro.getDataEncerramento() != null && !registro.getDataEncerramento().isBlank() ? sdf.parse(registro.getDataEncerramento()) : null;
		Date dataInternacao = registro.getDataInternacao() != null && !registro.getDataInternacao().isBlank() ? sdf.parse(registro.getDataInternacao()) : null;
		Date dataNascimento = registro.getDataNascimento() != null && !registro.getDataNascimento().isBlank() ? sdf.parse(registro.getDataNascimento()) : null;
		Date dataAtual = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataNascimento);
		int year1 = cal.get(Calendar.YEAR);
		
		if(dataEncerramento != null) {
			cal.setTime(dataEncerramento);
			int year2 = cal.get(Calendar.YEAR);
			return year2 - year1;
		} else if(dataInternacao != null) {
			cal.setTime(dataInternacao);
			int year2 = cal.get(Calendar.YEAR);
			return year2 - year1;
		} else {
			cal.setTime(dataAtual);
			int year2 = cal.get(Calendar.YEAR);
			return year2 - year1;
		}
	}

	private static List<Paciente> obterPacientes(List<SivepRedomeCSV> registros) throws ParseException {
		String jpql = "\n from Paciente p " 
	                + "\n where ";

		for (SivepRedomeCSV registro : registros) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimentoRedome = sdf1.parse(registro.getDataNascimento());

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String dataNascimentoBanco = sdf2.format(dataNascimentoRedome);

			jpql += "\n (p.nomeCompleto = '" + registro.getNomeCompleto() + "' and p.dataNascimento = '" + dataNascimentoBanco + "') ";

			if (registros.indexOf(registro) != registros.size() - 1) {
				jpql += " or ";
			}
		}

		TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
		
		return query.getResultList();
	}

}
