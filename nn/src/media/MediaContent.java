package media;

public class MediaContent {
	
	public String songName;
	public String showName;
	public String movieName;
	public String audioBookName;
	public String dramaName;
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getAudioBookName() {
		return audioBookName;
	}
	public void setAudioBookName(String audioBookName) {
		this.audioBookName = audioBookName;
	}
	public String getDramaName() {
		return dramaName;
	}
	public void setDramaName(String dramaName) {
		this.dramaName = dramaName;
	}

	
	
	private boolean boolPlayValue;
	private boolean boolPauseValue;
	private boolean boolLoadValue;
	private boolean boolContinueeValue;
	private boolean boolStopValue;
	private boolean boolRecordValue;
	private boolean boolDeleteValue;
	
	public boolean isBoolPlayValue() {
		return boolPlayValue;
	}
	public void setBoolPlayValue(boolean boolPlayValue) {
		this.boolPlayValue = boolPlayValue;
	}
	public boolean isBoolPauseValue() {
		return boolPauseValue;
	}
	public void setBoolPauseValue(boolean boolPauseValue) {
		this.boolPauseValue = boolPauseValue;
	}
	public boolean isBoolLoadValue() {
		return boolLoadValue;
	}
	public void setBoolLoadValue(boolean boolLoadValue) {
		this.boolLoadValue = boolLoadValue;
	}
	public boolean isBoolContinueeValue() {
		return boolContinueeValue;
	}
	public void setBoolContinueeValue(boolean boolContinueeValue) {
		this.boolContinueeValue = boolContinueeValue;
	}
	public boolean isBoolStopValue() {
		return boolStopValue;
	}
	public void setBoolStopValue(boolean boolStopValue) {
		this.boolStopValue = boolStopValue;
	}
	public boolean isBoolRecordValue() {
		return boolRecordValue;
	}
	public void setBoolRecordValue(boolean boolRecordValue) {
		this.boolRecordValue = boolRecordValue;
	}
	public boolean isBoolDeleteValue() {
		return boolDeleteValue;
	}
	public void setBoolDeleteValue(boolean boolDeleteValue) {
		this.boolDeleteValue = boolDeleteValue;
	}
	public void load() {
		if(boolLoadValue)
			System.out.println("Loaded");
	}
	public void play() {
		if(boolPlayValue)
			System.out.println("Played");
	}
	public void pause() {
		if(boolPauseValue)
			System.out.println("Paused");
	}
	public void continuee() {
		if(boolContinueeValue)
			System.out.println("Continue");
	}
	public void stop() {
		if(boolStopValue)
			System.out.println("Stopped");
	}
	public void record() {
		if(boolRecordValue)
			System.out.println("Recorded");
	}
	public void delete() {
		if(boolDeleteValue)
			System.out.println("Deleted");
	}
}
