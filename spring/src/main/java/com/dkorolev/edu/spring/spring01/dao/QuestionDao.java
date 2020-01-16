package com.dkorolev.edu.spring.spring01.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.dkorolev.edu.spring.spring01.domain.Question;

public interface QuestionDao {
    public List<Question> loadQuestions() throws FileNotFoundException, IOException;
}
