package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.SivepRedomeCSV;
import csv.SivepRedomeCSVHandler;

public class CriarCSVRedomeComCopias {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<SivepRedomeCSV> registros = SivepRedomeCSVHandler.carregarCSV("./arquivos/csv/SIVEP_REDOME.csv");
		
		Map<String, List<SivepRedomeCSV>> regitrosPorChave = new HashMap<>();
		
		for (SivepRedomeCSV registro: registros) {
			String chave = registro.getNomeCompleto() + registro.getDataNascimento();
			
			if(regitrosPorChave.get(chave) == null) {
				regitrosPorChave.put(chave, new ArrayList<SivepRedomeCSV>());
			}
			
			regitrosPorChave.get(chave).add(registro);
			
		}
		
		List<SivepRedomeCSV> registrosComCopia = new ArrayList<SivepRedomeCSV>();
		
		for(String chave : regitrosPorChave.keySet()) {
			if(regitrosPorChave.get(chave).size() > 1) {
				registrosComCopia.addAll(regitrosPorChave.get(chave));
			}
		}
		
		 List<SivepRedomeCSV> registrosComCopiaOrdenado = registrosComCopia.stream()
																	.sorted((o1,o2)-> o1.getNomeCompleto().compareTo(o2.getNomeCompleto()))
																	.collect(Collectors.toList()); 
		 
		 registrosComCopiaOrdenado.add(0, new SivepRedomeCSV("identificacao", "nomeCompleto", "dataNascimento", "municipio", 
				                                          "campo1", "sexo", "racaCor", "dataInternacao", "dataEncerramento", "evolucaoCaso"));
		
		 SivepRedomeCSVHandler.criarCSV("./arquivos/csv/SIVEP_REDOME(Copias).csv", registrosComCopiaOrdenado);
	}

}
