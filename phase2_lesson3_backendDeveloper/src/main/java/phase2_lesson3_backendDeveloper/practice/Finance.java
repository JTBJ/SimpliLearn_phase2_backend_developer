package phase2_lesson3_backendDeveloper.practice;

public class Finance {

	private long finance_Id;
	private String name;
	private String fType;
	
	public Finance() {
	}

	public Finance(String name, String fType) {
		this.name = name;
		this.fType = fType;
	}

	public long getFinance_Id() {
		return finance_Id;
	}

	public void setFinance_Id(long finance_Id) {
		this.finance_Id = finance_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	@Override
	public String toString() {
		return "Finace [finance_Id=" + finance_Id + ", name=" + name + ", fType=" + fType + "]";
	}
	
}
