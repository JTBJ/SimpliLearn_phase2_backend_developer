package phase2_lesson3_backendDeveloper.practice;

public class Color {

	private long color_Id;
	private String name;
	
	public Color() {
	}

	public Color(String name) {
		this.name = name;
	}

	public long getColor_Id() {
		return color_Id;
	}

	public void setColor_Id(long color_Id) {
		this.color_Id = color_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Color [color_Id=" + color_Id + ", name=" + name + "]";
	}
	
}
