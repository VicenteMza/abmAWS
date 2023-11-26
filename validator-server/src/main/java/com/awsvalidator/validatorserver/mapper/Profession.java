package com.awsvalidator.validatorserver.mapper;

public enum Profession {
	
	EMPLEADO_PUBLICO ("Empleado Público"),
	DEVELOPER ("Developer"),
	MEDICO ("Médico");
	
	private java.lang.String description;
	
	private Profession(java.lang.String desc) {
		this.description = desc;
	}

	public java.lang.String getDescription() {
		return description;
	}
}