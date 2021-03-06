package symbol;

public class Symbol {
	private final String type;
	private final String name;
	private int offset;

	public Symbol(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		switch(type) {
			case "boolean":
				return 1;

			case "int":
				return 4;

			default:               /* int[], Instances of classes */
				return 8;
		}
	}

	public boolean isStatic() {
		return type.startsWith("static");
	}

	public boolean hasType(String type) {
		return this.type.equals(type);
	}

	public boolean sameTypeAs(Symbol s) {
		return hasType(s.getType());
	}

	public int getOffset() {
		return offset;
	}

	public static boolean isBasicType(String type) {
		switch(type) {
			case "boolean":
			case "int":
			case "int[]":
				return true;

			default:
				return false;
		}
	}
}
