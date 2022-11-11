package bean.bean;

public class Engineer {

	private int EngId; 
	private String EngName; 
	private String EngUserName;
	private String EngPass ;
	private String EngCategory ;
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}
	
	public Engineer(int engId, String engName, String engUserName, String EngPass, String engCategory) {
		super();
		EngId = engId;
		EngName = engName;
		EngUserName = engUserName;
		this.EngPass = EngPass;
		EngCategory = engCategory;
	}
	public int getEngId() {
		return EngId;
	}
	public void setEngId(int engId) {
		EngId = engId;
	}
	public String getEngName() {
		return EngName;
	}
	public void setEngName(String engName) {
		EngName = engName;
	}
	public String getEngUserName() {
		return EngUserName;
	}
	public void setEngUserName(String engUserName) {
		EngUserName = engUserName;
	}
	public String getEngPass() {
		return EngPass;
	}
	public void setEngPass(String EngPass) {
		this.EngPass = EngPass;
	}
	public String getEngCategory() {
		return EngCategory;
	}
	public void setEngCategory(String engCategory) {
		EngCategory = engCategory;
	}

	@Override
	public String toString() {
		return "Engineer [EngId=" + EngId + ", EngName=" + EngName + ", EngUserName=" + EngUserName + ", EngPass="
				+ EngPass + ", EngCategory=" + EngCategory + "]";
	}
	
	
	
}
