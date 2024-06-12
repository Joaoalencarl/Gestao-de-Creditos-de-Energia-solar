package model;

public class Clientes {
	private String idcli;
	private String nomecli;
	private String nomeemp;
	private String cpf;
	private String cnpj;
	private String tel1;
	private String tel2;
	
	public Clientes() {
		super();
	}
	
	public Clientes(String idcli, String nomecli, String nomeemp, String cpf, String cnpj, String tel1, String tel2) {
		super();
		this.idcli = idcli;
		this.nomecli = nomecli;
		this.nomeemp = nomeemp;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.tel1 = tel1;
		this.tel2 = tel2;
	}
	
	public String getIdcli() {
		return idcli;
	}
	public void setIdcli(String idcli) {
		this.idcli = idcli;
	}
	public String getNomecli() {
		return nomecli;
	}
	public void setNomecli(String nomecli) {
		this.nomecli = nomecli;
	}
	public String getNomeemp() {
		return nomeemp;
	}
	public void setNomeemp(String nomeemp) {
		this.nomeemp = nomeemp;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	
}
