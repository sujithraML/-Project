package com.aspire.gkeep;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import com.aspire.gkeep.models.Note;

public class DateComparator implements Comparator<Note>{
	
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	@Override
	public int compare(Note firstNote, Note secondNote) {
		try {
			return format.parse(secondNote.getTimeStamp()).compareTo(format.parse(firstNote.getTimeStamp()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
