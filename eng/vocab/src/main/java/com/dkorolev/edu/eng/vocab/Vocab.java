package com.dkorolev.edu.eng.vocab;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Vocab {

    public static final String PATTERN = "[0-9]| |<|>|--|;|:|,|\\.|\\/|\\n|\\?|!|\"";

    public static void main(String[] args) {
	new Vocab().test();
    }

    public void test() {
	System.out.println("Working Directory = " + System.getProperty("user.dir"));
	String s = Utils.fileToString("resource/rockandmorty/401/Rick.and.Morty.S04E01.720p.WEBRip.x264-TBS.srt");
	s = doVocabStuff(s);
	System.out.println(s);
    }

    public Vocab() {
    }

    private boolean contains(Set<String> strings, String s) {
//	for (String string : strings) {
//	    if (string.toUpperCase().equals(s.toUpperCase())) {
//		return true;
//	    }
//	}
//	return false;
	return strings.contains(s);
    }

    public String doVocabStuff(String text) {
	String[] splitted = text.split(PATTERN);
	Map<Word, Integer> wordMap = new HashMap<>();

	for (String word : splitted) {
	    Word wordObj = new Word(word);
	    if (wordMap.containsKey(wordObj)) {
		wordMap.put(wordObj, wordMap.get(wordObj) + 1);
	    } else {
		wordMap.put(wordObj, 1);
	    }
	}

	List<Word> words = new ArrayList<>(wordMap.keySet());
	words.sort(new Comparator<Word>() {
	    public int compare(Word o1, Word o2) {
		return Integer.compare(wordMap.get(o2), wordMap.get(o1));
	    };
	});

	StringBuilder sb = new StringBuilder();
	for (Word word : words) {
	    sb
		    // .append(wordMap.get(word)).append(" ")
		    .append(word).append("\n");
	}

	return sb.toString();
    }
    

}
