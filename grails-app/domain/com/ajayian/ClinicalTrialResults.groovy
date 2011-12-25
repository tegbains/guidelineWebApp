package com.ajayian

class ClinicalTrialResults {

    static constraints = {
    	clinicalTrial()
    	resultOrder(range:1..10)
		resultOutcomeTitle()
    	resultOutcome()
	    resultOutcomePlaceboValue()
    	resultOutcomeDrugValue()
    	resultOutcomePValue()
    	resultOutcomeComments()
    }
    
    ClinicalTrial clinicalTrial
    
    Integer resultOrder
	String resultOutcomeTitle
    String resultOutcome
    
    Float resultOutcomePlaceboValue
    Float resultOutcomeDrugValue
    Float resultOutcomePValue
    
    String resultOutcomeComments
    
    String toString() {
    	return resultOutcome
    }

}

