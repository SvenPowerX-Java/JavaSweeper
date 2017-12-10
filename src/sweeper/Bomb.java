package sweeper;

class Bomb {
	private Matrix bombMap;
	private int totalBombs;
	
	public Bomb(int totalBombs) {
		this.totalBombs = totalBombs;
	}
	
	void start() {
		bombMap = new Matrix(Box.ZERO);
		for (int j = 0; j < totalBombs; j++)
			placeBomb();
	}
	
	Box get(Coord coord) {
		return bombMap.get(coord);
	}
	private void fixBombsCount() {
		int maxBombs = Ranges.getSize().getX() * Ranges.getSize().getY() / 2;
		if (totalBombs>maxBombs)
			totalBombs = maxBombs;
	}
	private void placeBomb() {
		while (true) {
			Coord coord = Ranges.getRandomCoord();
			if (Box.BOMB == bombMap.get(coord))
				continue;
			bombMap.set(coord, Box.BOMB);
			incNumbersAroundBomb(coord);
			break;
		}
		
	}
	
	private void incNumbersAroundBomb(Coord coord) {
		for (Coord around :	Ranges.getCoordsAround(coord)) {
			if (Box.BOMB!=bombMap.get(around))
			bombMap.set(around,bombMap.get(around).getNextNumberBox());
		}
	}
	
	public int getTotalBombs() {
		return totalBombs;
	}
}
