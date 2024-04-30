package Demo;

public class Nv {
	private String masv;
	private String name;
	private String sdt;
	private String email;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Nv(String masv, String name, String sdt, String email) {
		super();
		this.masv = masv;
		this.name = name;
		this.sdt = sdt;
		this.email = email;
	}
	public Nv() {
		super();
	}
	
}
