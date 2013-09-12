package br.com.findplaces.webservices.enumerator;

public enum StatusCode{
	
	SUCCESS("SUCCESS",0),	
	ERROR("OPS, BAD BAD SERVER", 1),
	NOT_ALLOWED("HUM...I THINK YOU SHOULD'T BE HERE",2);
	

	private String message;
	private Integer code;
	
	private StatusCode(String message, Integer code){
		this.setMessage(message);
		this.setCode(code);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
