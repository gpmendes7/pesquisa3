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

public class CriarCSVRedomeModificadoObito {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) throws IOException, ParseException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<SivepRedomeCSV> registros = SivepRedomeCSVHandler.carregarCSV("./arquivos/csv/SIVEP_REDOME(SemCopias).csv");

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
			
			List<Paciente> result = pacientes.stream() .filter(p ->p.getNomeCompleto().equals(registro.getNomeCompleto()) &&
					 									   sdf.format(p.getDataNascimento()).equals(registro.getDataNascimento()))
					 								.collect(Collectors.toList());
			
			if(result.isEmpty()) {
				continue;
			}
			
			Paciente paciente = result.get(0);
			
			String dataEncerramento = paciente.getDataEncerramento() != null ? sdf.format(paciente.getDataEncerramento()) : null;
			String dataInternacao = paciente.getDataInternacao() != null ? sdf.format(paciente.getDataInternacao()) : null;
			String dataNotificacao = paciente.getDataNotificacao() != null ? sdf.format(paciente.getDataNotificacao()) : null;
			
			Integer idade = calcularIdade(paciente.getDataNotificacao(), paciente.getDataNascimento());
			 
			SivepRedomeModificadoCSV registroModificado = new SivepRedomeModificadoCSV(registro.getIdentificacao(), registro.getNomeCompleto(), registro.getDataNascimento(), idade.toString(), 
																					   registro.getMunicipio(), registro.getCampo1(), registro.getSexo(), registro.getRacaCor(), 
																					   dataInternacao, registro.getDataInternacao(), 		
																					   dataEncerramento, registro.getDataEncerramento(), 		                                                                   		                                                                
					                                                                   paciente.getEvolucaoCaso(), registro.getEvolucaoCaso(),
					                                                                   dataNotificacao, paciente.getResultadoTeste());
			registrosModificados.add(registroModificado);
		}
		
		registrosModificados.add(0, new SivepRedomeModificadoCSV("identificacao", "nomeCompleto", "dataNascimento", "idade", 
				                                                 "municipio", "campo1", "sexo", "racaCor", 
				                                                 "dataInternacao", "dataInternacaoRedome", 
				                                                 "dataEncerramento", "dataEncerramentoRedome", 
				                                                 "evolucaoCaso", "evolucaoCasoRedome",
				                                                 "dataNotificacao", "resultadoTeste"));
		
		SivepRedomeModificadoCSVHandler.criarCSV("./arquivos/csv/SIVEP_REDOME(Modificado-OBITO).csv", registrosModificados);
	}
	
	
	private static Integer calcularIdade(Date dataNotificacao, Date dataNascimento) throws ParseException {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(dataNotificacao);
		int anoDataNotificacao = cal.get(Calendar.YEAR);
		
		cal.setTime(dataNascimento);
		int anoDataNascimento = cal.get(Calendar.YEAR);
		
		return anoDataNotificacao - anoDataNascimento;
	}

	private static List<Paciente> obterPacientes(List<SivepRedomeCSV> registros) throws ParseException {
		String jpql = "\n from Paciente p " 
	                + "\n where p.evolucaoCaso = 'OBITO' and (";

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
		
		jpql += "\n )";

		TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
		
		return query.getResultList();
	}

}
