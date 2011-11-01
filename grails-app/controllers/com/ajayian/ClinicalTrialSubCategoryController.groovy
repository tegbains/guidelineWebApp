package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class ClinicalTrialSubCategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def scaffold = ClinicalTrialSubCategory

    def index() {
        redirect(action: "list", params: params)
    }

    def listJSON = { 
        render ClinicalTrialSubCategory.list() as JSON
    }
    
    def showJSON = { 
        render ClinicalTrialSubCategory.get(params.id) as JSON
    }

	def listJSONbyCategory = { 
		def category = ClinicalTrialCategory.get( params.id)
		
//		render category as JSON
		
		if(category) {
			def myCLT = ClinicalTrialSubCategory.findAllByCategory(category)
			render myCLT as JSON
		} else {
			render ClinicalTrialSubCategory.list() as JSON
		}
		
		
    }

}
