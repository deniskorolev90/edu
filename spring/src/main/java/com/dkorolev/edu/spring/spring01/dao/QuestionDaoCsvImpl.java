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
    private String separator;
    private String csvFilePath;

    public QuestionDaoCsvImpl(String separator, String csvFilePath) {
	super();
	this.separator = separator;
	this.csvFilePath = csvFilePath;
    }

    @Override
    public List<Question> loadQuestions() throws FileNotFoundException, IOException {

	File file = new File(csvFilePath);
	return readCsv(file);
    }

    private List<Question> readCsv(File csvFile) throws FileNotFoundException, IOException {
	Iterable<CSVRecord> csvParser = CSVFormat.DEFAULT.parse(new FileReader(csvFile));

	List<Question> result = new ArrayList<>();

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
