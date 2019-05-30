package bankk;

public class CurrentTh {

	public static void main(String[] args) {
		try {
			Thread t1=Thread.currentThread();
			System.out.println(t1.getId());
			System.out.println(t1.getState());
			System.out.println(t1.getPriority());
			System.out.println(t1.isAlive());
			System.out.println(Thread.MAX_PRIORITY);
			System.out.println(Thread.MIN_PRIORITY);
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
