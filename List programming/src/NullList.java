
public class NullList extends List {

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isPair() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int first() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List second() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "()";
	}

}
