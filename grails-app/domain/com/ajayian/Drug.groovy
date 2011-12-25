package com.ajayian

class Drug {

    static constraints = {
    	genericName()
    }
    
    String genericName
    String AHFSId
    List brandNames
    
    TherapeuticClass therapeuticClass
    
	String toString() {
    	return genericName
    }
}
