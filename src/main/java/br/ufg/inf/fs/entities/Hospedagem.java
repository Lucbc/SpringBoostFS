package br.ufg.inf.fs.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_hospedagem")
public class Hospedagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hospedagem")
	private Integer idHospedagem;
	
	@OneToOne
	@JoinColumn(name="id_quarto")
	private Quarto idQuarto;

	@OneToOne
	@JoinColumn(name="id_hospede")
	private Hospede idHospede;
	
	@Column(name="dt_checkin")
	private String dtCheckin;
	
	@Column(name="dt_checkout")
	private String dtCheckout;

	public Hospedagem() {
		super();
	}

	public Hospedagem(Integer idHospedagem, Quarto idQuarto, Hospede idHospede, String dtCheckin,String dtCheckout) {
		super();
		this.idHospedagem = idHospedagem;
		this.idQuarto = idQuarto;
		this.idHospede = idHospede;
		this.dtCheckin = dtCheckin;
		this.dtCheckout = dtCheckout;
	}

	public Integer getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(Integer idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

	public Quarto getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Quarto idQuarto) {
		this.idQuarto = idQuarto;
	}

	public Hospede getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(Hospede idHospede) {
		this.idHospede = idHospede;
	}

	public String getDtCheckin() {
		return dtCheckin;
	}

	public void setDtCheckin(String dtCheckin) {
		this.dtCheckin = dtCheckin;
	}

	public String getDtCheckout() {
		return dtCheckout;
	}

	public void setDtCheckout(String dtCheckout) {
		this.dtCheckout = dtCheckout;
	}

	@Override
	public String toString() {
		return "Hospedagem [idHospedagem=" + idHospedagem + ", idQuarto=" + idQuarto + ", idHospede=" + idHospede
				+ ", dtCheckin=" + dtCheckin + ", dtCheckout=" + dtCheckout + "]";
	}	
}