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
	
		subCategory()
   		trialName()
   		trialAbbreviation()
   		trialDescription()
   		trialAuthors()
   		
   		publication()
   		publicationYear()
   		publicationDateIndex()
   		
   		patientNumbers()
   		patientDescription()
   		
   		therapeuticClass()
   		drug()
   		
   		interventionMonths()
   		intervention()
   		
   		trialDataSource(inList: ["Original", "Meta-Analysis", "Other"])
   		
   		
   		comments()
	}

}
