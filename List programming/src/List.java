abstract class List {
	public abstract boolean isNull();

	public abstract boolean isPair();

	public abstract int first();

	public abstract List second();

	public abstract String toString();

	// print
	public void print() {
		List l = this;
		System.out.print("[");

		while (true) {
			if (l.isNull()) {
				System.out.println("]");
				break;
			} else {
				System.out.print(l.first() + (l.second().isNull() ? "" : ","));
				l = l.second();
			}
		}
	}

	// length
	public int length() {
		List l = this;
		int count;

		count = 0;
		while (l.isPair()) {
			count = count + 1;
			l = l.second();
		}

		return count;
	}

	// sum
	public int sum() {
		List l = this;
		int sum;

		sum = 0;
		while (l.isPair()) {
			sum = sum + l.first();
			l = l.second();
		}

		return sum;
	}

	// concat
	public List concat(List l) {
		if (this.isNull()) {
			return l;
		} else {
			return new Pair(this.first(), this.second().concat(l));
		}
	}

	// reverse
	public List reverse() {
		if(this.isNull()){
			return this;
		}else{
			return this.second().reverse().concat(new Pair(this.first(), new NullList()));
		}
	}

}
