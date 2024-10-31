package game;

public class Dialogue {
	
	private static Pause pause;
	
	public Dialogue() {
		pause = new Pause();
	}
	
	public static void characterDialogue(String name, String text) {
		
		System.out.println("[ " + name + " ]");
		for (char ch: text.toCharArray()) {
			System.out.print(ch);
			pause.pause(25);
		}
		
	}
	
	public static void infoDialogue(String text) {
		
		for (char ch: text.toCharArray()) {
			System.out.print(ch);
			pause.pause(25);
		}
		
	}

}
