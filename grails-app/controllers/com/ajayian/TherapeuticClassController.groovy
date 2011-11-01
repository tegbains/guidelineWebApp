package com.ajayian

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON

class TherapeuticClassController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def scaffold = TherapeuticClass
    
    def listJSON = { 
        render TherapeuticClass.list() as JSON
    }
    
    def showJSON = { 
        render TherapeuticClass.get(params.id) as JSON
    }

}
