package media;

import java.util.Scanner;

public class TestMedia {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("which content has to accessed Song or Drama or Show or AudioBook or Movie");
		String choice=sc.next();
		switch(choice) {
		case "Song":
			Song songobj =new Song();
			songobj.setSongName(choice);
			System.out.println(songobj.getSongName());
			System.out.println("Do you want to play or pause or continue or stop or delete \n Enter true or false");
			String s1=sc.next();
			switch(s1) {
			case "continue":
				songobj.setBoolContinueeValue(sc.nextBoolean());
				System.out.println(songobj.isBoolContinueeValue());
				songobj.continuee();
				break;
			case "delete":
				songobj.setBoolDeleteValue(sc.nextBoolean());
				System.out.println(songobj.isBoolDeleteValue());
				songobj.delete();
				break;
			case "load":	
				songobj.setBoolLoadValue(sc.nextBoolean());
				System.out.println(songobj.isBoolLoadValue());
				songobj.load();
				break;
			case "pause":	
				songobj.setBoolPauseValue(sc.nextBoolean());
				System.out.println(songobj.isBoolPauseValue());
				songobj.pause();
				break;
			case "play":	
				songobj.setBoolPlayValue(sc.nextBoolean());
				System.out.println(songobj.isBoolPlayValue());
				songobj.play();
				break;
			case "record":
				songobj.setBoolRecordValue(sc.nextBoolean());
				System.out.println(songobj.isBoolRecordValue());
				songobj.record();
				break;
			case "stop":	
				songobj.setBoolStopValue(sc.nextBoolean());
				System.out.println(songobj.isBoolStopValue());
				songobj.stop();
				break;
			}
			break;
		case "Drama":
			Drama dramaobj =new Drama();
			dramaobj.setDramaName(choice);
			System.out.println(dramaobj.getDramaName());
			System.out.println("Do you want to play or pause or continue or stop or record or delete \n Enter true or false");
			String s2=sc.next();
			switch(s2) {
			case "continue":
				dramaobj.setBoolContinueeValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolContinueeValue());
				dramaobj.continuee();
				break;
			case "delete":
				dramaobj.setBoolDeleteValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolDeleteValue());
				break;
			case "load":	
				dramaobj.setBoolLoadValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolLoadValue());
				dramaobj.load();
				break;
			case "pause":	
				dramaobj.setBoolPauseValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolPauseValue());
				dramaobj.pause();
				break;
			case "play":	
				dramaobj.setBoolPlayValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolPlayValue());
				dramaobj.play();
				break;
			case "record":
				dramaobj.setBoolRecordValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolRecordValue());
				dramaobj.record();
				break;
			case "stop":	
				dramaobj.setBoolStopValue(sc.nextBoolean());
				System.out.println(dramaobj.isBoolStopValue());
				dramaobj.stop();
				break;
			}
			break;
		case "Show":
			Shows showobj =new Shows ();
			showobj.setShowName(choice);
			System.out.println(showobj.getShowName());
			System.out.println("Do you want to play or pause or continue or stop or record or delete \n Enter true or false");
			String s3=sc.next();
			switch(s3) {
			case "continue":
				showobj.setBoolContinueeValue(sc.nextBoolean());
				System.out.println(showobj.isBoolContinueeValue());
				showobj.continuee();
				break;
			case "delete":
				showobj.setBoolDeleteValue(sc.nextBoolean());
				System.out.println(showobj.isBoolDeleteValue());
				showobj.delete();
				break;
			case "load":	
				showobj.setBoolLoadValue(sc.nextBoolean());
				System.out.println(showobj.isBoolLoadValue());
				showobj.load();
				break;
			case "pause":	
				showobj.setBoolPauseValue(sc.nextBoolean());
				System.out.println(showobj.isBoolPauseValue());
				showobj.pause();
				break;
			case "play":	
				showobj.setBoolPlayValue(sc.nextBoolean());
				System.out.println(showobj.isBoolPlayValue());
				showobj.play();
				break;
			case "record":
				showobj.setBoolRecordValue(sc.nextBoolean());
				System.out.println(showobj.isBoolRecordValue());
				showobj.record();
				break;
			case "stop":	
				showobj.setBoolStopValue(sc.nextBoolean());
				System.out.println(showobj.isBoolStopValue());
				showobj.stop();
				break;
			}
			break;
		case "AudioBook":
			AudioBook audiobookobj =new AudioBook();
			audiobookobj.setAudioBookName(choice);
			System.out.println(audiobookobj.getAudioBookName());
			System.out.println("Do you want to play or pause or continue or stop or record or delete \n Enter true or false");
			String s4=sc.next();
			switch(s4) {
			case "continue":
				audiobookobj.setBoolContinueeValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolContinueeValue());
				audiobookobj.continuee();
				break;
			case "delete":
				audiobookobj.setBoolDeleteValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolDeleteValue());
				audiobookobj.delete();
				break;
			case "load":	
				audiobookobj.setBoolLoadValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolLoadValue());
				audiobookobj.load();
				break;
			case "pause":	
				audiobookobj.setBoolPauseValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolPauseValue());
				audiobookobj.pause();
				break;
			case "play":	
				audiobookobj.setBoolPlayValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolPlayValue());
				audiobookobj.play();
				break;
			case "record":
				audiobookobj.setBoolRecordValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolRecordValue());
				audiobookobj.record();
				break;
			case "stop":	
				audiobookobj.setBoolStopValue(sc.nextBoolean());
				System.out.println(audiobookobj.isBoolStopValue());
				audiobookobj.stop();
				break;
			}
			break;
		case "Movie":
			Movie movieobj =new Movie();
			movieobj.setMovieName(choice);
			System.out.println(movieobj.getMovieName());
			System.out.println("Do you want to play or pause or continue or stop or record or delete \n Enter true or false");
			String s5=sc.next();
			switch(s5) {
			case "continue":
				movieobj.setBoolContinueeValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolContinueeValue());
				movieobj.continuee();
				break;
			case "delete":
				movieobj.setBoolDeleteValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolDeleteValue());
				movieobj.delete();
				break;
			case "load":	
				movieobj.setBoolLoadValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolLoadValue());
				movieobj.load();
				break;
			case "pause":	
				movieobj.setBoolPauseValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolPauseValue());
				movieobj.pause();
				break;
			case "play":	
				movieobj.setBoolPlayValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolPlayValue());
				movieobj.play();
				break;
			case "record":
				movieobj.setBoolRecordValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolRecordValue());
				movieobj.record();
				break;
			case "stop":	
				movieobj.setBoolStopValue(sc.nextBoolean());
				System.out.println(movieobj.isBoolStopValue());
				movieobj.stop();
				break;
			}
			break;
		}
		
		sc.close();
	}
}
