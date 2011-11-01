package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class ClinicalTrialCategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def scaffold = ClinicalTrialCategory
	
    def index() {
        redirect(action: "list", params: params)
    }
    
    def listJSON = { 
        render ClinicalTrialCategory.list() as JSON
    }
    
    def showJSON = { 
        render ClinicalTrialCategory.get(params.id) as JSON
    }

  }
