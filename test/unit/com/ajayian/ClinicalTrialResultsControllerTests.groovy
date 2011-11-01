package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ClinicalTrialResultsController)
@Mock(ClinicalTrialResults)
class ClinicalTrialResultsControllerTests {

    void testIndex() {
        controller.index()
        assert "/clinicalTrialResults/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.clinicalTrialResultsInstanceList.size() == 0
        assert model.clinicalTrialResultsInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.clinicalTrialResultsInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.clinicalTrialResultsInstance != null
        assert view == '/clinicalTrialResults/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/clinicalTrialResults/show/1'
        assert controller.flash.message != null
        assert ClinicalTrialResults.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialResults/list'


        def clinicalTrialResults = new ClinicalTrialResults()

        // TODO: populate domain properties

        assert clinicalTrialResults.save() != null

        params.id = clinicalTrialResults.id

        def model = controller.show()

        assert model.clinicalTrialResultsInstance == clinicalTrialResults
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialResults/list'


        def clinicalTrialResults = new ClinicalTrialResults()

        // TODO: populate valid domain properties

        assert clinicalTrialResults.save() != null

        params.id = clinicalTrialResults.id

        def model = controller.edit()

        assert model.clinicalTrialResultsInstance == clinicalTrialResults
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialResults/list'

        response.reset()


        def clinicalTrialResults = new ClinicalTrialResults()

        // TODO: populate valid domain properties

        assert clinicalTrialResults.save() != null

        // test invalid parameters in update
        params.id = clinicalTrialResults.id

        controller.update()

        assert view == "/clinicalTrialResults/edit"
        assert model.clinicalTrialResultsInstance != null

        clinicalTrialResults.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/clinicalTrialResults/show/$clinicalTrialResults.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialResults/list'

        response.reset()

        def clinicalTrialResults = new ClinicalTrialResults()

        // TODO: populate valid domain properties
        assert clinicalTrialResults.save() != null
        assert ClinicalTrialResults.count() == 1

        params.id = clinicalTrialResults.id

        controller.delete()

        assert ClinicalTrialResults.count() == 0
        assert ClinicalTrialResults.get(clinicalTrialResults.id) == null
        assert response.redirectedUrl == '/clinicalTrialResults/list'
    }
}
