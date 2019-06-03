package com.aspire.gkeep.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.NoArgumentException;
import com.aspire.gkeep.exceptions.UserNameUnAvailableException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Media;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.models.Reminder;
import com.aspire.gkeep.models.User;
import com.aspire.gkeep.services.NoteService;
import com.aspire.gkeep.utils.ErrorCodes;
import com.aspire.gkeep.utils.Paths;

@RestController
@RequestMapping(Paths.NOTESPATH)
public class NoteController {

	@Autowired
	@Qualifier("noteServiceImplHibernate")
	NoteService noteService;
	@Autowired
	Note note;
	@Autowired
	Reminder reminder;

	// all null check

	/* creates file storage for the user when user registers himself */
	@PostMapping(value = Paths.USERPATH)
	public ResponseEntity<String> registerUser(@RequestBody User user)
			throws GenericException, UserNotFoundException, EmptyValueException {
		try {
			if (noteService.authenticateUser(user.getName())==true)
				throw new UserNameUnAvailableException(ErrorCodes.USERNAMEUNAVAILABLEEXCEPTION);
			else
				noteService.registerUser(user);
			return ResponseEntity.ok(ErrorCodes.USERNAMEUNAVAILABLEEXCEPTION);
		} catch (NullPointerException exception) {
			throw new EmptyValueException(ErrorCodes.ILLEGALARGUMENTEXCEPTION, exception);
		} catch (Exception exception) {
			throw new GenericException(ErrorCodes.ERRORCODE, exception);
		}
	}

//	/* not yet implemented */
	@GetMapping(value = Paths.USERPATH)
	public ResponseEntity<String> authenticateUser(@RequestParam(value = "userName") String userName)
			throws UserNotFoundException, GenericException, EmptyValueException {
		try {
			if(noteService.authenticateUser(userName)==true)
				return ResponseEntity.ok(ErrorCodes.USERNAMEUNAVAILABLEERROR);
			else
				throw new UserNameUnAvailableException(ErrorCodes.USERNAMEUNAVAILABLEEXCEPTION);
				
		} catch (NullPointerException exception) {
			throw new EmptyValueException(ErrorCodes.ILLEGALARGUMENTEXCEPTION, exception);
		} catch (Exception exception) {
			throw new GenericException(ErrorCodes.ERRORCODE, exception);
		}
	}

	/* Returns all the notes belong to the user */
	@GetMapping(value = Paths.NOTESPATH)
	public List<Note> getNotes(@RequestParam(value = "name") String name)
			throws UserNotFoundException, GenericException, EmptyValueException {
		return noteService.getNotes(name);
	}

	/*
	 * adds note to user's storage(file) and returns the true if added successfully
	 */
	@PostMapping(value = Paths.NOTESPATH, consumes = "application/json")
	public void addNote(@RequestParam(value = "name") String name, @RequestBody Note note)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		try {
			if (!note.getContent().equals(""))
				noteService.addNote(name, note);
			else
				throw new NoArgumentException(ErrorCodes.CONTENTEMPTYEXCEPTION);
		} catch (Exception exception) {
			throw new EmptyValueException(ErrorCodes.ILLEGALARGUMENTEXCEPTION, exception);
		}
	}

	/*
	 * removes the note on the user's storage and returns true if removed
	 * successfully
	 */
	@DeleteMapping(value = Paths.NOTESPATH)
	public void removeNote(@RequestParam(value = "userName") String userName, @RequestBody Note note)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		noteService.removeNote(userName, note);
	}

	/* Adds label to a note specified */

	@PatchMapping(value = Paths.NOTESPATH)
	public void addLabel(@RequestParam(value = "user") String user, @RequestBody Note note,
			@RequestParam(value = "label") String label)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		noteService.addLabel(user, note.getTimeStamp(), label);
	}

	/* pins the specified note to the top of the list */
	@PatchMapping(value = Paths.NOTESPINPATH)
	public void pinNote(@RequestParam(value = "user") String user, @RequestBody Note note)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		noteService.pinNote(user, note);
	}

	/* edits the note and saves it in the user's storage */

	@PatchMapping(value = Paths.NOTESEDITPATH)
	public void editNote(@RequestParam(value = "user") String user, @RequestBody Note editedNote)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		noteService.editNote(user, editedNote);

	}

	@PutMapping(value = Paths.NOTESUNPINPATH)
	public void unPinNote(@RequestParam(value = "user") String user, @RequestBody Note note)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		noteService.unPinNote(user, note);
	}

	/* saves the last deleted notes and returns it on demand */

	@GetMapping(value = Paths.NOTESBINPATH)
	public List<Note> getTrash(@RequestParam(value = "user") String user) throws GenericException {
		return noteService.getTrash(user);
	}

	/* sends the note as email,message etc. */

	@PutMapping(value = Paths.NOTESSENDPATH)
	public void sendNote(@RequestParam(value = "user") String user, @RequestBody Note note, @RequestBody Media media)
			throws NoArgumentException {
		if (user.equals(null) && note.equals(null) && media.equals(null))
			throw new NoArgumentException(ErrorCodes.NAMEORBODYNULLERROR);
		else
			noteService.sendNote(user, note, media);
	}

	/* copies the note and returns the object */

	@GetMapping(value = Paths.NOTESCOPYPATH)
	public void copyNote(@RequestParam(value = "user") String user, @RequestParam(value = "timeStamp") String timeStamp)
			throws UserNotFoundException, GenericException, NoArgumentException {
		if (user.equals(null) && timeStamp.equals(null))
			throw new NoArgumentException(ErrorCodes.NAMEORBODYNULLERROR);
		else
			noteService.copyNote(user, timeStamp);
	}

	/* group some notes and saves it in mentioned folder name */

//	@PostMapping(value = Paths.NOTESGROUPPATH, consumes = "application/json")
//	public String groupNotes(String user, String groupName, @RequestBody List<Note> notes) {
//		return user.equals(null) && note.equals(null) ? ErrorCodes.NAMEAORBODYNULLERROR
//				: noteService.groupNotes(user, groupName, notes);
//	}

	/*
	 * adds a reminder with time returns true if added successfully
	 */

	@PostMapping(value = Paths.REMINDERSPATH, consumes = "application/json")
	public void addReminder(@RequestParam(value = "user") String user,
			@RequestParam(value = "reminder") String reminder, @RequestParam(value = "datetime") String datetime)
			throws UserNotFoundException, GenericException, NoArgumentException {
		try {
			if (user.equals(""))
				throw new NoArgumentException(ErrorCodes.NAMENULLERROR);
			else
				noteService.addReminder(user, reminder, datetime);
		} catch (Exception exception) {
			throw new GenericException(ErrorCodes.ERRORCODE, exception);
		}
	}

	/*
	 * make a note as reminder with time as input returns true if added successfully
	 */

	@PatchMapping(value = Paths.REMINDERSPATH)
	public void makeItAsReminder(@RequestParam(value = "user") String user, @RequestParam(value = "time") String time,
			@RequestBody Note note) throws UserNotFoundException, CustomIOException, GenericException {
		try{ 
			if(user.equals("") && note.getContent().equals(""))
				throw new NoArgumentException(ErrorCodes.NAMEORBODYNULLERROR);
			else
				 noteService.makeItAsReminder(user, time, note);
		} catch(Exception exception) {
			throw new GenericException(ErrorCodes.ERRORCODE,exception);
		}
				
	}

	/* returns all the reminders saved for the specified user */

	@GetMapping(value = Paths.REMINDERSPATH)
	public List<Reminder> getAllReminders(@RequestParam(value = "user") String user)
			throws UserNotFoundException, GenericException {
		return noteService.getAllReminders(user);
	}

	/* edits reminder and saves it */

	@PatchMapping(value = Paths.REMINDERSEDITPATH)
	public String editReminder(@RequestParam(value = "user") String user,
			@RequestParam(value = "reminder") String editedReminder, @RequestParam(value = "time") String editedTime)
			throws UserNotFoundException, CustomIOException, GenericException {
		return user.equals(null) && note.equals(null) ? ErrorCodes.NAMEORBODYNULLERROR
				: noteService.editReminder(user, editedReminder, editedTime);
	}

	@GetMapping("/getOK")
	public ResponseEntity<String> get() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.clear();
		return new ResponseEntity<String>("GET response", HttpStatus.OK);
	}

	@GetMapping("/get404")
	public ResponseEntity<String> getResource() {
		// return new ResponseEntity<String>("GET response", HttpStatus.NOT_FOUND);
		return ResponseEntity.ok("GET response");
	}

	public ResponseEntity<String> getSavedURI() throws URISyntaxException {
		URI uri = new URI(System.getenv(""));

		System.out.println(uri);
		return null;
	}

	@GetMapping("/test")
	public Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Host", "aspiresys.com");
		return map;
	}
//	@GetMapping("uri")
//	public ResponseBody getResponse() {
//		ResponseBody responseBody = Response.BAD;
//		return responseBody;
//	}
}
