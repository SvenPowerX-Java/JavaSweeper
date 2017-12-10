package sweeper;

public class Game {
	
	private Bomb bomb;
	private Flag flag;
	
	public Game(int cols, int rows, int bombs) {
		Ranges.setSize(new Coord(cols, rows));
		bomb = new Bomb(bombs);
		flag = new Flag();
	}
	
	public void start() {
		bomb.start();
		flag.start();
		
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
}
