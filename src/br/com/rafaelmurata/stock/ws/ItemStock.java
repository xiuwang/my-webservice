package br.com.rafaelmurata.stock.ws;

public class ItemStock {

	public ItemStock() {
	}
	public ItemStock(String cod, Integer amount) {
		super();
		this.cod = cod;
		this.amount = amount;
	}
	private String cod;
	private Integer amount;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
