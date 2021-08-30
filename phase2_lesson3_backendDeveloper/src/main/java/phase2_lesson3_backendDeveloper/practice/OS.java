package phase2_lesson3_backendDeveloper.practice;

public class OS {

	private long os_Id;
	private String name;
	
	public OS() {
	}

	public OS(String name) {
		this.name = name;
	}

	public long getOs_Id() {
		return os_Id;
	}

	public void setOs_Id(long os_Id) {
		this.os_Id = os_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OS [os_Id=" + os_Id + ", name=" + name + "]";
	}
	
}
