package br.com.ex01.EntitiesVO;

import java.util.List;


/**
 * CLasse que representa o endereco 
 * @author Cristiano Momesso
 *
 */
public class AdressVO {

	private String id;
	private String zip;
	private String logradouro;
	private String numerStreet;
	private String city;
	private String state;
	private String bairro;
	private String complemento;
	private Integer userId;
	private String index;
	
	
	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumerStreet() {
		return numerStreet;
	}
	public void setNumerStreet(String numerStreet) {
		this.numerStreet = numerStreet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
