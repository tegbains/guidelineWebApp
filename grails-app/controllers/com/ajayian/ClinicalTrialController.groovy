package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import grails.web.JSONBuilder

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

	def showJSON2 = { 
	
		def aTrial = ClinicalTrial.get(params.id)
        render aTrial as JSON
    }


	def test = {
	
		def builder = new JSONBuilder()
		def result = builder.build {
			categories = ['a', 'b', 'c']
			title ="Hello JSON"
			information = {
				pages = 10
			}
		}
		
		// prints the JSON text
		println result.toString()
		
		def sw = new StringWriter()
		render sw
	
	}
  
}
