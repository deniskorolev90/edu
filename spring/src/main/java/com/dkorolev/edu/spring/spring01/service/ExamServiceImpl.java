package com.dkorolev.edu.spring.spring01.service;

import java.util.List;

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
	
	System.out.println(questionList);
    }
}
