package csv;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class PacienteCSVHandler {
	
	private static ColumnPositionMappingStrategy<PacienteCSV> strategy;
	
	static {
		strategy = new ColumnPositionMappingStrategy<PacienteCSV>();
		strategy.setType(PacienteCSV.class);

		String[] colunas = { "nomeCompleto", "dataNascimento"};
 
		strategy.setColumnMapping(colunas);
	}
	
	public static List<PacienteCSV> carregarCSV(String nomeArquivo) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(nomeArquivo));) {
			CsvToBean<PacienteCSV> csvToBean = new CsvToBeanBuilder<PacienteCSV>(reader).withMappingStrategy(strategy)
					.withType(PacienteCSV.class).withSeparator(',').withSkipLines(1).build();
			List<PacienteCSV> registros = csvToBean.parse();
			return registros;
		}
	}
	
	public static void criarCSV(String nomeArquivo, List<PacienteCSV> registros) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo));) {
			StatefulBeanToCsv<PacienteCSV> beanToCsv = new StatefulBeanToCsvBuilder<PacienteCSV>(writer)
														.withMappingStrategy(strategy)
														.withSeparator(',')
														.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
														.build();
			beanToCsv.write(registros);
		}
	}

}
