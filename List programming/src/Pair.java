public class Pair extends List {

	private int firstElem;
	private List secondElem;

	public Pair(int firstElem, List secondElem) {
		this.firstElem = firstElem;
		this.secondElem = secondElem;
	}
	public Pair(Tree tree){
		this.firstElem = tree.value();
		this.secondElem = new NullList();
	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPair() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int first() {
		// TODO Auto-generated method stub
		return this.firstElem;
	}

	@Override
	public List second() {
		// TODO Auto-generated method stub
		 return this.secondElem;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + firstElem + ", " + secondElem.toString() + ")";
	}
	
}
