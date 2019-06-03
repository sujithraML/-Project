package com.aspire.gkeep.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.utils.Constants;
import com.aspire.gkeep.utils.ErrorCodes;

@Component
public class NoteDAOImplFiles implements NoteDAO {

	List<Note> notes;
	List<Note> pinned;
	@Autowired
	Note note;


	public boolean isFileExists(String username) throws GenericException {
		try {
			if (username != null) {
				File file = new File(Constants.DIRECTORY + username + "/");
				String[] files = file.list();
				for (String tempFile : files) {	//
					if (tempFile.equals(Constants.PINNED)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
		return false;
	}

	@Override
	public void saveTrash(List<Note> trash, String user) throws GenericException {
		File file = new File(Constants.DIRECTORY + user + "/" + Constants.BIN);
		try {
			FileWriter fileWriter = new FileWriter(file);
			Iterator<Note> iterator = trash.iterator();
			while (iterator.hasNext()) {
				Note note = new Note();
				note = iterator.next();
				fileWriter.write(note.getLabel() + Constants.ASTREIKPATTERN);
				fileWriter.write(note.getTimeStamp() + " : " + note.getContent() + Constants.DOLLARPATTERN
						+ System.lineSeparator());
			}
			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		} catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
	}

	@Override
	public List<Note> getTrash(String name) throws GenericException {
		File file = new File(Constants.DIRECTORY + name + "/" + Constants.BIN);
		try {
			FileReader fileReader = new FileReader(file);
			StringBuffer stringBuffer = new StringBuffer();
			int numCharsRead;
			char[] charArray = new char[1024];
			try {
				while ((numCharsRead = fileReader.read(charArray)) > 0) {
					stringBuffer.append(charArray, 0, numCharsRead);
				}
				if (stringBuffer != null)
					notes = new ArrayList<Note>();
				StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(),
						Constants.DOLLARPATTERN + System.lineSeparator());
				while (stringTokenizer.hasMoreTokens()) {
					Note note = new Note();
					String string = stringTokenizer.nextToken();
					StringTokenizer tempStringTokenizer = new StringTokenizer(string, Constants.ASTREIKPATTERN);
					note.setLabel(tempStringTokenizer.nextToken());
					String tempString = tempStringTokenizer.nextToken();
					note.setTimeStamp(tempString.substring(0, 17));
					note.setContent(tempString.substring(20, tempString.length()));
					notes.add(note);
				}
			} catch (IOException e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
		return notes;
	}

	@Override
	public String savePinnedNotes(List<Note> pinned, String user) throws GenericException {
		File file = new File(Constants.DIRECTORY + user + "/" + Constants.PINNED);
		String status = "";
		if (isFileExists(user)) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				Iterator<Note> iterator = pinned.iterator();
				while (iterator.hasNext()) {
					Note note = new Note();
					note = iterator.next();
					fileWriter.write(note.getLabel() + Constants.ASTREIKPATTERN);
					fileWriter.write(note.getTimeStamp() + " : " + note.getContent() + Constants.DOLLARPATTERN
							+ System.lineSeparator());
				}
				fileWriter.flush();
				fileWriter.close();
				status = Constants.PINNED;

			} catch (IOException e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		} else
			status = ErrorCodes.USERUNAVAILABLEERROR;
		return status;
	}

	@Override
	public List<Note> getNotes(String name) throws UserNotFoundException, GenericException {
		File file = new File(Constants.DIRECTORY + name + "/" + name + Constants.FILEEXTENSION);
		if (isFileExists(name)) {
			try {
				notes = new ArrayList<Note>();
				notes.addAll(getPinnedNotes(name));
				FileReader fileReader = new FileReader(file);
				StringBuffer stringBuffer = new StringBuffer();
				int numCharsRead;
				char[] charArray = new char[1024];
				try {
					while ((numCharsRead = fileReader.read(charArray)) > 0) {
						stringBuffer.append(charArray, 0, numCharsRead);
					}
					if (stringBuffer != null)
						notes = new ArrayList<Note>();
					StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(),
							Constants.DOLLARPATTERN + System.lineSeparator());
					while (stringTokenizer.hasMoreTokens()) {
						Note note = new Note();
						String string = stringTokenizer.nextToken();
						StringTokenizer tempStringTokenizer = new StringTokenizer(string, Constants.ASTREIKPATTERN);
						note.setLabel(tempStringTokenizer.nextToken());
						String tempString = tempStringTokenizer.nextToken();
						note.setTimeStamp(tempString.substring(0, 17));
						note.setContent(tempString.substring(20, tempString.length()));
						notes.add(note);
					}
					fileReader.close();
				} catch (IOException e) {
					throw new GenericException(ErrorCodes.IOEXCEPTION, e);
				}
			} catch (FileNotFoundException e) {
				throw new GenericException(ErrorCodes.FILENOTFOUNDEXCEPTION, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		}
		return notes;
	}

	@Override
	public List<Note> getPinnedNotes(String name) throws UserNotFoundException, GenericException {
		File file = new File(Constants.DIRECTORY + name + "/" + Constants.PINNED);
		if (isFileExists(name)) {
			try {
				FileReader fileReader = new FileReader(file);
				StringBuffer stringBuffer = new StringBuffer();
				int numCharsRead;
				char[] charArray = new char[1024];
				try {
					while ((numCharsRead = fileReader.read(charArray)) > 0) {
						stringBuffer.append(charArray, 0, numCharsRead);
					}
					if (stringBuffer != null)
						notes = new ArrayList<Note>();
					StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(),
							Constants.DOLLARPATTERN + System.lineSeparator());
					while (stringTokenizer.hasMoreTokens()) {
						Note note = new Note();
						String string = stringTokenizer.nextToken();
						StringTokenizer tempStringTokenizer = new StringTokenizer(string, Constants.ASTREIKPATTERN);
						note.setLabel(tempStringTokenizer.nextToken());
						String tempString = tempStringTokenizer.nextToken();
						note.setTimeStamp(tempString.substring(0, 17));
						note.setContent(tempString.substring(20, tempString.length()));
						notes.add(note);
					}
					fileReader.close();
				} catch (IOException e) {
					throw new GenericException(ErrorCodes.IOEXCEPTION, e);
				}
			} catch (FileNotFoundException e) {
				throw new GenericException(ErrorCodes.FILENOTFOUNDEXCEPTION, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		}
		return notes;
	}

	@Override
	public String unpinNotes(Note note, String user) throws UserNotFoundException, GenericException {
		File file = new File(Constants.DIRECTORY + user + "/" + Constants.PINNED);
		pinned = new ArrayList<Note>();
		String status = "";
		if (isFileExists(user)) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				pinned = getNotes(user);
				Iterator<Note> iterator = pinned.iterator();
				while (iterator.hasNext()) {
					Note tempNote = new Note();
					tempNote = iterator.next();
					fileWriter.write(tempNote.getLabel() + Constants.ASTREIKPATTERN);
					fileWriter.write(tempNote.getTimeStamp() + " : " + tempNote.getContent() + Constants.DOLLARPATTERN
							+ System.lineSeparator());
				}
				fileWriter.flush();
				fileWriter.close();
				status = Constants.PINNED;

			} catch (IOException e) {
				throw new GenericException(ErrorCodes.IOEXCEPTION, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		} else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return status;
	}

	@Override
	public int[] saveNotes(List<Note> notesToBeSaved, String userName) throws CustomIOException, GenericException {
		File file = new File(Constants.DIRECTORY + userName + "/" + userName + Constants.FILEEXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			Iterator<Note> iterator = notesToBeSaved.iterator();
			while (iterator.hasNext()) {
				Note note = new Note();
				note = iterator.next();
				fileWriter.write(note.getLabel() + Constants.ASTREIKPATTERN);
				fileWriter.write(note.getTimeStamp() + " : " + note.getContent() + Constants.DOLLARPATTERN
						+ System.lineSeparator());
			}
			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			throw new GenericException(ErrorCodes.IOEXCEPTION, e);
		} catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}

		return null;
	}
}
