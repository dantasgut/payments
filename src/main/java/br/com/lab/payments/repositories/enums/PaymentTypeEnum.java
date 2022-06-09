package br.com.lab.payments.repositories.enums;

public enum PaymentTypeEnum {

	CREDITCARD(1,"Credit Cart"),
	DEBITCARD(2,"Debit Cart"),
	CASH(3,"Cash"),
	DIGITALPAYMENT(4,"Digital Payment"),
	CRYPTOCURRENCY(5,"Cripto Currency"),
	UNDEFINED(-1,"undefined");
	
		
	private PaymentTypeEnum(Integer id, String type) {
		this.id = id;
		this.type = type;
	}
	
	private Integer id;
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public PaymentTypeEnum getById(Integer id) {
	
		for(PaymentTypeEnum t:PaymentTypeEnum.values()) {
			if(id==t.getId()) {
				return t;
			}
		}
		
		return PaymentTypeEnum.UNDEFINED;
	}
	
	public PaymentTypeEnum getByType(String type) {
		
		for(PaymentTypeEnum t:PaymentTypeEnum.values()) {
			if(type.equals(t.getType())) {
				return t;
			}
		}
		
		return PaymentTypeEnum.UNDEFINED;
	}
	
}
