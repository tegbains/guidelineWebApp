package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class ClinicalTrialResultsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def scaffold = ClinicalTrialResults

    def index() {
        redirect(action: "list", params: params)
    }
   
    def listJSON = { 
        render ClinicalTrialResults.list() as JSON
    }
    
    def showJSON = { 
        render ClinicalTrialResults.get(params.id) as JSON
    }

   
}
