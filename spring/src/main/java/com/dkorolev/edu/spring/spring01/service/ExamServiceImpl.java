package com.dkorolev.edu.spring.spring01.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dkorolev.edu.spring.spring01.dao.QuestionDao;
import com.dkorolev.edu.spring.spring01.domain.Question;

public class ExamServiceImpl implements ExamService {

    private QuestionDao dao;

    public ExamServiceImpl(QuestionDao dao) {
	super();
	this.dao = dao;
    }

    @Override
    public void startExam() throws Exception {
	List<Question> questionList = dao.loadQuestions();

	System.out.println("Exam started!\n");

	int i = 0;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Set<Integer> correctUserAnswers = new HashSet<>();
	for (Question question : questionList) {
	    System.out.println("\nQuestion #" + ++i + ":\n" + question.getQuestion() + "\nAnswers:");
	    for (int j = 1; j <= question.getAnswerMap().size(); j++) {
		System.out.println("[" + j + "] " + question.getAnswerMap().get(j));
	    }
	    Integer userAnswerInt = null;
	    while (userAnswerInt == null) {
		String userAnswer = reader.readLine();
		try {
		    userAnswerInt = new Integer(userAnswer);
		} catch (Exception e) {
		    System.out.println("Enter valid answer index\n");
		    userAnswer = null;
		}
	    }
	    if (userAnswerInt.equals(question.getCorrectAnswerSet().toArray()[0])) {
		correctUserAnswers.add(i);
	    }
	}

	System.out.println("Exam finished!\nCorrect answers: " + correctUserAnswers.size() + "/" + questionList.size()
		+ "\nQuestions passed: ");
	for (Integer questCor : correctUserAnswers) {
	    System.out.println(questCor + " ");
	}
    }
}
