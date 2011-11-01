package com.ajayian

class TherapeuticClass {

    static constraints = {
    	therapeuticClassName()
    }
    
    String therapeuticClassName
    String therapeuticClassNameAbbreviation
    String AHFSClassification
    
	String toString() {
    	return therapeuticClassName
    }


}
