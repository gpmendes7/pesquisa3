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

public class SivepRedomeCSVHandler {
	
	private static ColumnPositionMappingStrategy<SivepRedomeCSV> strategy;
	
	static {
		strategy = new ColumnPositionMappingStrategy<SivepRedomeCSV>();
		strategy.setType(SivepRedomeCSV.class);

		String[] colunas = { "identificacao", "nomeCompleto", "dataNascimento", "municipio", "campo1", "sexo",  "racaCor", "dataInternacao",  "dataEncerramento", "evolucaoCaso"};
 
		strategy.setColumnMapping(colunas);
	}
	
	public static List<SivepRedomeCSV> carregarCSV(String nomeArquivo) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(nomeArquivo));) {
			CsvToBean<SivepRedomeCSV> csvToBean = new CsvToBeanBuilder<SivepRedomeCSV>(reader).withMappingStrategy(strategy)
					.withType(SivepRedomeCSV.class).withSeparator(',').withSkipLines(1).build();
			List<SivepRedomeCSV> registros = csvToBean.parse();
			return registros;
		}
	}
	
	public static void criarCSV(String nomeArquivo, List<SivepRedomeCSV> registros) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo));) {
			StatefulBeanToCsv<SivepRedomeCSV> beanToCsv = new StatefulBeanToCsvBuilder<SivepRedomeCSV>(writer)
														.withMappingStrategy(strategy)
														.withSeparator(',')
														.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
														.build();
			beanToCsv.write(registros);
		}
	}

}
