package bean;

import java.sql.Timestamp;

public class MngrDataBean {
	private int prd_id; //??? ?±λ‘λ²?Έ
	private String prd_kind; //??? λΆλ₯
	private String prd_name; //???΄λ¦?
	private int prd_price; //??κ°?κ²?
	private short prd_count; //??? ?¬κ³ μ?
	private String prd_image; //???΄λ―Έμ?λͺ?
	private String prd_content; //????΄?©
	private Timestamp reg_date; //??? ?±λ‘λ μ§?
	private Timestamp end_time; //??λ§κ°? μ§?
	
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getPrd_kind() {
		return prd_kind;
	}
	public void setPrd_kind(String prd_kind) {
		this.prd_kind = prd_kind;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public short getPrd_count() {
		return prd_count;
	}
	public void setPrd_count(short prd_count) {
		this.prd_count = prd_count;
	}
	public String getPrd_image() {
		return prd_image;
	}
	public void setPrd_image(String prd_image) {
		this.prd_image = prd_image;
	}
	public String getPrd_content() {
		return prd_content;
	}
	public void setPrd_content(String prd_content) {
		this.prd_content = prd_content;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	
}