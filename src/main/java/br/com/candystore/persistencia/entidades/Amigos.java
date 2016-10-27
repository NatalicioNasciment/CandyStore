package br.com.candystore.persistencia.entidades;

public class Amigos {
	private int id;
	private String nome;
	private String apelido;
	private int  telefone;
	private String redeSocial;
	
	public Amigos(){}
	
	public Amigos(String nome, String apelido){	
		this.setNome(nome);
		this.setApelido(apelido);
	}
	
	public Amigos(String redeSocial, int telefone){	
		this.setRedeSocial(redeSocial);
		this.setTelefone(telefone);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
}
