package bean;

import java.sql.Timestamp;

public class MngrDataBean {
	private int prd_id; //?ƒ?’ˆ?˜ ?“±ë¡ë²ˆ?˜¸
	private String prd_kind; //?ƒ?’ˆ?˜ ë¶„ë¥˜
	private String prd_name; //?ƒ?’ˆ?´ë¦?
	private int prd_price; //?ƒ?’ˆê°?ê²?
	private short prd_count; //?ƒ?’ˆ?˜ ?¬ê³ ìˆ˜?Ÿ‰
	private String prd_image; //?ƒ?’ˆ?´ë¯¸ì?ëª?
	private String prd_content; //?ƒ?’ˆ?˜?‚´?š©
	private Timestamp reg_date; //?ƒ?’ˆ?˜ ?“±ë¡ë‚ ì§?
	private Timestamp end_time; //?ƒ?’ˆë§ˆê°?‚ ì§?
	
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