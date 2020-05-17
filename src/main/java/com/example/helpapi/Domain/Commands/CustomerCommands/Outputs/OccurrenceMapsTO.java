package com.example.helpapi.Domain.Commands.CustomerCommands.Outputs;

import java.util.Calendar;

import com.example.helpapi.Domain.Models.Occurrence;

public class OccurrenceMapsTO {

	 private int id;
	 private String tipo_ocorrencia;
	 private String endereco;
	 private double longitude;
	 private double latitude;
	 private String descricao;
	 private Calendar data;
	 private String usuario;
	 private String image;
	 
	 public OccurrenceMapsTO(Occurrence occurrence) {
		 this.id = occurrence.getId();
		 this.tipo_ocorrencia = occurrence.getOccurrence_type();
		 this.endereco = occurrence.getAddress().getName_street();
		 this.longitude = occurrence.getLongitude();
		 this.latitude = occurrence.getLatitude();
		 this.descricao = occurrence.getDescription();
		 this.data = occurrence.getDate();
		 this.usuario = occurrence.getCustomer().getName();
		 this.image = occurrence.getImage();
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo_ocorrencia() {
		return tipo_ocorrencia;
	}

	public void setTipo_ocorrencia(String tipo_ocorrencia) {
		this.tipo_ocorrencia = tipo_ocorrencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	 
}
