
public class NullTree extends Tree {

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isBinTree() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tree left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tree right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "()";
	}

}
