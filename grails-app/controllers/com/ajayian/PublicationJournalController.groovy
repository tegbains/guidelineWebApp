package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class PublicationJournalController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

	def scaffold = PublicationJournal
	
    def listJSON = { 
        render PublicationJournal.list() as JSON
    }
    
    def showJSON = { 
        render PublicationJournal.get(params.id) as JSON
    }
  
}
