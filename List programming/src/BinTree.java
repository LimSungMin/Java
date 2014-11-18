public class BinTree extends Tree {
	private int value;
	private Tree leftTree;
	private Tree rightTree;
	
	public BinTree(Tree left, int value, Tree right){
		this.value = value;
		this.leftTree = left;
		this.rightTree = right;
	}
	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBinTree() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Tree left() {
		// TODO Auto-generated method stub
		return leftTree;
	}

	@Override
	public Tree right() {
		// TODO Auto-generated method stub
		return rightTree;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+leftTree.toString()+ " : " + value + " : "+rightTree.toString()+")";
		
	}
	
}
