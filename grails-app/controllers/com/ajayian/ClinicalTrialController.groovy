package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class ClinicalTrialController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def scaffold = ClinicalTrial

    def index() {
        redirect(action: "list", params: params)
    }

    def listJSON = { 
        render ClinicalTrial.list() as JSON
    }
    
    def showJSON = { 
        render ClinicalTrial.get(params.id) as JSON
    }

  
}
