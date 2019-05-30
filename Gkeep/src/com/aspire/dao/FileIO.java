package com.aspire.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.aspire.modelbeans.Note;
import com.aspire.modelbeans.User;

public class FileIO {

	List<Note> notes;

	public boolean dataIn(List<Note> notesToBeSaved, User user) {
		File file = new File("" + user.getUserName());
		try {
			FileWriter fileWriter = new FileWriter(file);
			Iterator<Note> iterator = notesToBeSaved.iterator();
			while (iterator.hasNext()) {
				Note note = new Note();
				fileWriter.write(note.getEntryDate()+ note.getMessage() + "---$---");
				fileWriter.flush();
				fileWriter.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<Note> getData(User user) {
		File file = new File("" + user.getUserName());
		try {
			FileReader fileReader = new FileReader(file);
			StringBuffer stringBuffer = new StringBuffer();
			int numCharsRead;
			char[] charArray = new char[1024];
			try {
				while ((numCharsRead = fileReader.read(charArray)) > 0) {
					stringBuffer.append(charArray, 0, numCharsRead);
				}
				if(stringBuffer != null)
					notes = new ArrayList<Note>();
				StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(),"---$---");
				while(stringTokenizer.hasMoreTokens()) {
					Note note = new Note();
					String string = stringTokenizer.nextToken();
					note.setEntryDate(string.substring(0, 16));
					note.setMessage(string.substring(17, string.length()-1));
					notes.add(note);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return notes;
	}
}
