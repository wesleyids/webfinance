package br.com.webfinance.response;

public class CategoriasResponse {

	public CategoriasResponse(Object categorias){
		this.categorias = categorias;
	}
	
	private Object categorias;

	public Object getCategorias() {
		return categorias;
	}

	public void setCategorias(Object categorias) {
		this.categorias = categorias;
	}
	
	
}
