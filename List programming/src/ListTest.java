public class ListTest {

	public static void main(String[] args) {

		// Make some Lists
		List list = new Pair(1, new Pair(2, new Pair(3, new NullList())));
		List list2 = new Pair(4, new Pair(5, new Pair(6, new NullList())));
		List list3 = new NullList();

		// Set list3 as sequence of list, list2
		list3 = list.concat(list2);

		// Print list3 to String
		list3.print();

		// Reverse list3 and Print to String
		list3.reverse().print();

		System.out.println();

		// Print List's Info
		System.out.println("Length of List : " + list3.length());
		System.out.println("Sum of List : " + list3.sum());

		System.out.println();

		// Make some Trees
		
		Tree tree3 = new BinTree(new NullTree(), 3, new NullTree());
		Tree tree2 = new BinTree(new NullTree(), 2, new NullTree());
		Tree tree = new BinTree(tree2, 1, tree3);
		Tree tree4 = new BinTree(tree3, 5, tree);

		// Print Tree to String
		System.out.println(tree.toString());

		System.out.println();

		// Print Tree's Info
		System.out.println("Number of Tree's nodes : " + count(tree));
		System.out.println("Sum of Tree's nodes : " + sum(tree));
		System.out.println("Height of Tree : " + height(tree));

		System.out.println();

		// Print traversals
		System.out.print("Pre-order traversal : ");
		preorder(tree).print();
		System.out.print("In-order traversal : ");
		inorder(tree).print();
		System.out.print("Post-order traversal : ");
		postorder(tree).print();

	}
	//Number of Tree's node
		public static int count(Tree tree) {
			int count;
			if (tree.isNull()) {
				return 0;
			} else {
				count = 1;
			}
			count += count(tree.left());
			count += count(tree.right());
			return count;
		}

		// Height of Tree
		public static int height(Tree tree) {
			if (tree.isNull())
				return 0;
			else
				return 1 + Math.max(height(tree.left()), height(tree.right()));
		}

		// Sum of Tree's node
		public static int sum(Tree tree) {
			int sum;
			if (tree.isNull()) {
				return 0;
			} else {
				sum = tree.value();
			}
			sum += sum(tree.left());
			sum += sum(tree.right());
			return sum;
		}

		// Pre-order traversal
		public static List preorder(Tree tree) {
			List l = new NullList();
			if (!tree.isNull()) {
				l = l.concat(new Pair(tree.value(), new NullList()));
				l = l.concat(preorder(tree.left()));
				l = l.concat(preorder(tree.right()));
			}
			return l;
		}

		// In-order traversal
		public static List inorder(Tree tree) {
			List l = new NullList();
			if (!tree.isNull()) {
				l = l.concat(inorder(tree.left()));
				l = l.concat(new Pair(tree.value(), new NullList()));
				l = l.concat(inorder(tree.right()));
			}
			return l;
		}

		// Post-order traversal
		public static List postorder(Tree tree) {
			List l = new NullList();
			if (!tree.isNull()) {
				l = l.concat(postorder(tree.left()));
				l = l.concat(postorder(tree.right()));
				l = l.concat(new Pair(tree.value(), new NullList()));
			}
			return l;
		}
	
}
