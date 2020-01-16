package com.dkorolev.edu.spring.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dkorolev.edu.spring.spring01.service.ExamService;

public class Main {

    public static void main(String[] args) {
	ClassPathXmlApplicationContext context = null;
	try {
	    context = new ClassPathXmlApplicationContext("/context.xml");
	    ExamService examService = context.getBean(ExamService.class);
	    examService.startExam();
	    System.out.println("OK!!");
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (context != null) {
		context.close();
	    }
	}
    }
}
