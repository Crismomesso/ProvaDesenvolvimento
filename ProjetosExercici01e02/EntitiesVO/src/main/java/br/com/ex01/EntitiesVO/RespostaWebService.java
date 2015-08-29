package br.com.ex01.EntitiesVO;

public class RespostaWebService {

	String cep ;
	String logradouro;
	String complemento;
	String bairro;
	String localidade;
	String uf;
	String ibge;
	String erro;
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String hasErro() {
		return this.erro;
	}
}
