package com.dkorolev.edu.spring.spring01.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.dkorolev.edu.spring.spring01.domain.Question;

public class QuestionDaoCsvImpl implements QuestionDao {
//    @Value("${separator}")
    private String separator;
//    @Value("${questionsCsv}")
    private String csvFilePath;

    public QuestionDaoCsvImpl(String separator, String csvFilePath) {
	super();
	this.separator = separator;
	this.csvFilePath = csvFilePath;
    }

    @Override
    public List<Question> loadQuestions() throws FileNotFoundException, IOException {

	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	System.out.println("Current relative path is: " + s);
	File file = new File(csvFilePath);
//	System.out.println(readLineByLineJava8(csvFilePath));
	return readCsv(file);
    }

    private static String readLineByLineJava8(String filePath) {
	StringBuilder contentBuilder = new StringBuilder();
	try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
	    stream.forEach(s -> contentBuilder.append(s).append("\n"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return contentBuilder.toString();
    }

    private List<Question> readCsv(File csvFile) throws FileNotFoundException, IOException {
	CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(new File("test321.csv")), CSVFormat.DEFAULT);
	csvPrinter.printRecord("1", "8.3", "70", "10.3");
	csvPrinter.printRecord("1", "8.3", "70", "10.3");
	csvPrinter.flush();
	csvPrinter.close();

	Iterable<CSVRecord> csvParser = CSVFormat.DEFAULT.parse(new FileReader(csvFile));

	List<Question> result = new ArrayList<>();

//	for (CSVRecord record : csvParser) {
//	    System.out.println();
//	}

	for (CSVRecord record : csvParser) {
	    Question question = new Question();
	    question.setQuestion(record.get(0));
	    boolean sepaPassed = false;
	    for (int i = 1; i < record.size(); i++) {
		if (separator.contentEquals(record.get(i))) {
		    sepaPassed = true;
		    continue;
		}
		if (!sepaPassed) {
		    question.getAnswerMap().put(i, record.get(i));
		} else {
		    question.getCorrectAnswerSet().add(new Integer(record.get(i)));
		}
	    }
	    result.add(question);
	}

	return result;
    }
}
