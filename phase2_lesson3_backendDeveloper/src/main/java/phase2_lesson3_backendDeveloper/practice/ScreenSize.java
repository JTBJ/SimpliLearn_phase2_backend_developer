package phase2_lesson3_backendDeveloper.practice;

public class ScreenSize {

	private long screen_Id;
	private String size;
	
	public ScreenSize() {
	}

	public ScreenSize(String size) {
		this.size = size;
	}

	public long getScreen_Id() {
		return screen_Id;
	}

	public void setScreen_Id(long screen_Id) {
		this.screen_Id = screen_Id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ScreenSize [screen_Id=" + screen_Id + ", size=" + size + "]";
	}
	
}
