package com.ajayian

class ClinicalTrialResults {

    static constraints = {
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

