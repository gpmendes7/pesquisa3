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

public class SivepRedomeModificadoCSVHandler {
	
	private static ColumnPositionMappingStrategy<SivepRedomeModificadoCSV> strategy;
	
	static {
		strategy = new ColumnPositionMappingStrategy<SivepRedomeModificadoCSV>();
		strategy.setType(SivepRedomeModificadoCSV.class);

		String[] colunas = { "identificacao", "nomeCompleto", "dataNascimento", "idade",
				             "municipio", "campo1", "sexo",  "racaCor", 
				             "dataInternacao",  "dataInternacaoRedome",
				             "dataEncerramento", "dataEncerramentoRedome",
				             "evolucaoCaso",  "evolucaoCasoRedome"};
 
		strategy.setColumnMapping(colunas);
	}
	
	public static List<SivepRedomeModificadoCSV> carregarCSV(String nomeArquivo) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(nomeArquivo));) {
			CsvToBean<SivepRedomeModificadoCSV> csvToBean = new CsvToBeanBuilder<SivepRedomeModificadoCSV>(reader).withMappingStrategy(strategy)
					.withType(SivepRedomeModificadoCSV.class).withSeparator(',').withSkipLines(1).build();
			List<SivepRedomeModificadoCSV> registros = csvToBean.parse();
			return registros;
		}
	}
	
	public static void criarCSV(String nomeArquivo, List<SivepRedomeModificadoCSV> registros) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo));) {
			StatefulBeanToCsv<SivepRedomeModificadoCSV> beanToCsv = new StatefulBeanToCsvBuilder<SivepRedomeModificadoCSV>(writer)
														.withMappingStrategy(strategy)
														.withSeparator(',')
														.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
														.build();
			beanToCsv.write(registros);
		}
	}

}
