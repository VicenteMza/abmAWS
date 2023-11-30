package com.crudAWS.crud.model;

public enum Profession {
	
	EMPLEADO_PUBLICO ("Empleado Público"),
	DEVELOPER ("Developer"),
	MEDICO ("Médico");
	
	private String description;
	
	private Profession(String desc) {
		this.description = desc;
	}

	public String getDescription() {
		return description;
	}
}