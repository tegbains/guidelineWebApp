package com.ajayian

class ClinicalTrial {


    static hasMany = [results:ClinicalTrialResults]
        
    ClinicalTrialSubCategory subCategory
    
    TherapeuticClass therapeuticClass
    
    String trialName
    String trialAbbreviation
    String trialDescription
    String trialAuthors
    
    PublicationJournal publication
    Integer publicationYear
   	String publicationDateIndex

    Integer patientNumbers
    String patientDescription

    String intervention
    Integer interventionMonths

    String comments
    
    Drug drug
    
    String trialDataSource
    
    String toString() {
    	return trialName
    }

	static constraints = {
   		trialName()
   		trialAbbreviation()
   		trialDescription()
   		trialAuthors()
   		trialDataSource(inList: ["Original", "Meta-Analysis", "Other"])
   		
	}

}
