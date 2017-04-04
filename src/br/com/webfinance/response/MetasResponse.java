package br.com.webfinance.response;

public class MetasResponse {

	public MetasResponse(Object metas) {
		this.metas = metas;
	}

	private Object metas;

	public Object getMetas() {
		return metas;
	}

	public void setMetas(Object metas) {
		this.metas = metas;
	}

}
