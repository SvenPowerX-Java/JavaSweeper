package sweeper;

class Flag {
	private Matrix flagMap;
	private int countOfClosdBoxes;
	
	void start() {
		flagMap = new Matrix(Box.CLOSED);
		
		countOfClosdBoxes = Ranges.getSize().getX() * Ranges.getSize().getY();
		
		/* для отладки
		for (Coord around :
				Ranges.getCoordsAround(new Coord(4, 4))) {

			flagMap.set(around, Box.OPENED);
		}*/
	}
	
	Box get(Coord coord) {
		return flagMap.get(coord);
	}
	
	public void setOpenedToBox(Coord coord) {
		flagMap.set(coord, Box.OPENED);
		countOfClosdBoxes--;
	}
	
	public void setFlagedToBox(Coord coord) {
		flagMap.set(coord, Box.FLAGED);
	}
	
	public void toggleFlagedToBox(Coord coord) {
		switch (flagMap.get(coord)) {
			case FLAGED:setClosedToBox(coord);break;
			case CLOSED:setFlagedToBox(coord);break;
		}
	}
	
	private void setClosedToBox(Coord coord) {
		flagMap.set(coord, Box.CLOSED);
	}
	
	int getCountOfClosedBoxex() {
		return countOfClosdBoxes;
	}
	
	 void setBombedToBox(Coord coord) {
		flagMap.set(coord, Box.BOMBED);
	}
	
	void setOpenedToClosedBombBox(Coord coord) {
		if (flagMap.get(coord) == Box.CLOSED)
			flagMap.set(coord, Box.OPENED);
	}
	
	void setNobombToFlagedSafeBox(Coord coord) {
		if (flagMap.get(coord) == Box.FLAGED)
			flagMap.set(coord, Box.NOBOMB);
	}
	
	
	public int getCountOfFlagedBoxesAround(Coord coord) {
		int count = 0;
		for (Coord around :
				Ranges.getCoordsAround(coord)) {
			if (flagMap.get(around) == Box.FLAGED)
				count++;
		}
		return count;
	}
}
