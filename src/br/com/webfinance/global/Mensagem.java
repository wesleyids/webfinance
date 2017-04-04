package br.com.webfinance.global;

public class Mensagem {

	public static final String SUCCESS = "success";
	public static final String ERROR   = "error";
	
	public static final String INSERT_SUCCESS = "Inserido com sucesso";
	public static final String ALTER_SUCCESS = "Alterado com sucesso";
	public static final String RETRIEVE_SUCCESS = "Localizado com sucesso";
	public static final String DELETE_SUCCESS = "Excluído com sucesso";
	
	public static String getNameEntidade(String clazzName){
		return clazzName;
	}
}
