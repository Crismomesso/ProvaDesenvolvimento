package br.com.ex01.EntitiesVO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


/**
 * Entidade que retorna os erros ocorridos nos servicos
 * @author Cristiano Momesso
 *
 */
@XmlRootElement
@XmlAccessorType(value=XmlAccessType.FIELD)
public class ErroVO implements Serializable {

	private static final long serialVersionUID = -6057820737419323540L;

	private String mensagemErro;

	public ErroVO() {
	}

	public ErroVO(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

}
