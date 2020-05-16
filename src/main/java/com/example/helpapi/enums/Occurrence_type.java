package com.example.helpapi.enums;

public enum Occurrence_type {
	Frt( "Furto"   ),
	RBU( "Roubo"   ),
	ASS( "Assalto" );

	String occurrence_type;
	
	Occurrence_type( String occurrence_type ) {
		this.occurrence_type = occurrence_type;
	}
}
