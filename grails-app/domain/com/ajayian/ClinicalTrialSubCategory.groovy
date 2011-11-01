package com.ajayian

class ClinicalTrialSubCategory {

    static constraints = {
    	subCategoryName()
    }
    ClinicalTrialCategory category
    String subCategoryName
    String subCategoryDescription
    
    String toString() {
    	return subCategoryName
    }

}
