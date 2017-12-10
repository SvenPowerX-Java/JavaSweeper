package sweeper;

public class Game {
	
	private Bomb bomb;
	private Flag flag;
	
	public GameState getState() {
		return state;
	}
	
	private GameState state;
	
	public Game(int cols, int rows, int bombs) {
		Ranges.setSize(new Coord(cols, rows));
		bomb = new Bomb(bombs);
		flag = new Flag();
	}
	
	public void start() {
		bomb.start();
		flag.start();
		state = GameState.PLAYED;
		
	}
	
	public Box getBox(Coord coord) {
		if (flag.get(coord) == Box.OPENED)
			return bomb.get(coord); //Нижний слой
		else
			return flag.get(coord); //Верхний слой
	}
	
	public void pressLeftButton(Coord coord) {
		flag.setOpenedToBox (coord);
	}
	
	public void pressRightButton(Coord coord) {
//		flag.setFlagedToBox(coord);//отладка
		flag.toggleFlagedToBox(coord);
	}
}
