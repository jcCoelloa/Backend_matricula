package com.matricula.seguridad;

import java.util.Date;

//Clase tres
public class AuthResponse {

	private String token;
	private Date expiracion;
	
	public AuthResponse(String token, Date expiracion) {
		this.token = token;
		this.expiracion = expiracion;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(Date expiracion) {
		this.expiracion = expiracion;
	}
	
	
	
}
