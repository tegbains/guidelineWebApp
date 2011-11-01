package com.ajayian

class Drug {

    static constraints = {
    	genericName()
    }
    
    String genericName
    String AHFSId
    List brandNames
    
	String toString() {
    	return genericName
    }
}
