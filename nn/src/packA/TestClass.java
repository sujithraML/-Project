package packA;

public class TestClass extends Film{

	public static void main(String[] args) {
		Film f1=new Film();
		
		f1.getFilmName();				//public 
		f1.getDirectorName();			//protected//special case
		f1.getStoryWriterName();	    //default//special case
	}
	public void testA (){
		this.getDirectorName();			//protected
		this.getFilmName();				//public
		this.getStoryWriterName();		//default//special case
	}
}
