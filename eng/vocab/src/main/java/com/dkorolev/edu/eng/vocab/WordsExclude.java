package com.dkorolev.edu.eng.vocab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsExclude {
    public static void main(String[] args) {
	String s1 = "resource/unbre/words.txt";
	String s2 = "resource/bladerunner/wordsAll.txt";
	new WordsExclude().execute(s1, s2);
    }

    /**
     * 
     * @param pathWhere где удалить
     * @param pathWhat  что удалить
     */
    public void execute(String pathWhere, String pathWhat) {
	String whereS = Utils.fileToString(pathWhere);
	List<String> where = new ArrayList<>(Arrays.asList(whereS.split("\n")));
	String whatS = Utils.fileToString(pathWhat);
	List<String> what = Arrays.asList(whatS.split("\n"));
	List<String> whatUpper = new ArrayList<String>(what.size());
	for (String s : what) {
	    whatUpper.add(s.toUpperCase());
	}

	for (int i = where.size() - 1; i >= 0; i--) {
	    if (whatUpper.contains(where.get(i).toUpperCase())) {
		where.remove(i);
	    }
	}

	System.out.println(listToString(where));
    }

    public static String listToString(List<String> list) {
	StringBuilder sb = new StringBuilder();
	for (String word : list) {
	    sb
		    // .append(wordMap.get(word)).append(" ")
		    .append(word).append("\n");
	}

	return sb.toString();
    }
}
