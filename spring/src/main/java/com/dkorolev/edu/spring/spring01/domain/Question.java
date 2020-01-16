package com.dkorolev.edu.spring.spring01.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question {
    private String question;
    private HashMap<Integer, String> answerMap = new HashMap<>();
    private Set<Integer> correctAnswerSet = new HashSet<>();

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }

    public HashMap<Integer, String> getAnswerMap() {
	return answerMap;
    }

    public void setAnswerMap(HashMap<Integer, String> answerMap) {
	this.answerMap = answerMap;
    }

    public Set<Integer> getCorrectAnswerSet() {
	return correctAnswerSet;
    }

    public void setCorrectAnswerSet(Set<Integer> correctAnswerSet) {
	this.correctAnswerSet = correctAnswerSet;
    }

    @Override
    public String toString() {
	return "Question [question=" + question + ", answerMap=" + answerMap + ", correctAnswerSet=" + correctAnswerSet
		+ "]";
    }
}
