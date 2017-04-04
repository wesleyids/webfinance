package br.com.webfinance.response;

public class DespesasResponse {

	public DespesasResponse(Object despesas){
		this.despesas = despesas;
	}
	
	private Object despesas;

	public Object getDespesas() {
		return despesas;
	}

	public void setDespesas(Object despesas) {
		this.despesas = despesas;
	}
	
}
