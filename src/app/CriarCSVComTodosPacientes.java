package app;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PacienteCSV;
import csv.PacienteCSVHandler;
import modelo.Paciente;

public class CriarCSVComTodosPacientes {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) throws ParseException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		emf = Persistence.createEntityManagerFactory("sivep2");
		em = emf.createEntityManager();
		
		List<Paciente> pacientes = obterPacientes();
		
		em.close();
		emf.close();
		
		List<PacienteCSV> pacientesCSV = new ArrayList<PacienteCSV>(); 
		
		for (Paciente paciente : pacientes) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String dataNascimento = paciente.getDataNascimento() != null ? sdf.format(paciente.getDataNascimento()) : null;
			
			PacienteCSV pacienteCSV = new PacienteCSV(paciente.getNomeCompleto(), dataNascimento);
			pacientesCSV.add(pacienteCSV);
		}
		
		pacientesCSV.add(0, new PacienteCSV("nomeCompleto", "dataNascimento"));

		PacienteCSVHandler.criarCSV("./arquivos/csv/Pacientes(SIVEP).csv", pacientesCSV);
	}
	
	
	private static List<Paciente> obterPacientes() throws ParseException {
		String jpql = "\n from Paciente p ";

		TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
		
		return query.getResultList();
	}

}
