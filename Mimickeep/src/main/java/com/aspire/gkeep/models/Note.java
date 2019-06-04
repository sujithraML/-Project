package com.aspire.gkeep.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.stereotype.Component;

import com.aspire.gkeep.utils.Type;

@Entity
@org.hibernate.annotations.Entity
@Table(name = "Note", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "timeStamp")
})
@Component
public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5052323089220974874L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer noteId;
	@Column(name = "label", unique = true,  nullable = false, length = 20)
	private String label;
	@Column(name = "content",  nullable = false, length = 1000)
	private String content;
	@Column(name = "timeStamp",  nullable = false, length = 17)
	private String timeStamp;
	@Column(name = "type", nullable = false, length = 20)
	private Type type;
	
	public Note(){
		
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public String getLabel() {
		return label;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		if(timeStamp.equals("")) {
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
			this.timeStamp = timeFormat.format(LocalDateTime.now());
		}
		else
			this.timeStamp = timeStamp;
	}
}
