package Game;
public class ShogiGUIRunner {

	public static void main(String[] args) {
		Board board = new ShogiBoard();
		ShogiGameGUI gui = new ShogiGameGUI(board);
		gui.displayGame();
	}
}
