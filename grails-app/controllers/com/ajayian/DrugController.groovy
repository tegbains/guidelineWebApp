package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class DrugController {
    static scaffold = true
    
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    
     def index() {
        redirect(action: "list", params: params)
    }

    def listJSON = { 
        render Drug.list() as JSON
    }
    
    def showJSON = { 
        render Drug.get(params.id) as JSON
    }

    
}
