package bean;

import java.sql.Timestamp;

public class MngrDataBean {
	private String it_num; //물품 번호
	private String it_name; //물품 제목
	private int it_amount; // 물품 개수
	private String it_company; //회사
	private Timestamp it_deadline; // 마감시간
	private int it_cost;
	private String st_com_name; // FK키, 회사 이름;
	
	public String getIt_num() {
		return it_num;
	}
	public void setIt_num(String it_num) {
		this.it_num = it_num;
	}
	public String getIt_name() {
		return it_name;
	}
	public void setIt_name(String it_name) {
		this.it_name = it_name;
	}
	public int getIt_amount() {
		return it_amount;
	}
	public void setIt_amount(int it_amount) {
		this.it_amount = it_amount;
	}
	public String getIt_company() {
		return it_company;
	}
	public void setIt_company(String it_company) {
		this.it_company = it_company;
	}
	public Timestamp getIt_deadline() {
		return it_deadline;
	}
	public void setIt_deadline(Timestamp it_deadline) {
		this.it_deadline = it_deadline;
	}	
	public int getIt_cost() {
		return it_cost;
	}
	public void setIt_cost(int it_cost) {
		this.it_cost = it_cost;
	}
	public String getSt_com_name() {
		return st_com_name;
	}
	public void setSt_com_name(String st_com_name) {
		this.st_com_name = st_com_name;
	}
	
	
}