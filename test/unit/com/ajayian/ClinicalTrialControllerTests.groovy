package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ClinicalTrialController)
@Mock(ClinicalTrial)
class ClinicalTrialControllerTests {

    void testIndex() {
        controller.index()
        assert "/clinicalTrial/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.clinicalTrialInstanceList.size() == 0
        assert model.clinicalTrialInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.clinicalTrialInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.clinicalTrialInstance != null
        assert view == '/clinicalTrial/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/clinicalTrial/show/1'
        assert controller.flash.message != null
        assert ClinicalTrial.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrial/list'


        def clinicalTrial = new ClinicalTrial()

        // TODO: populate domain properties

        assert clinicalTrial.save() != null

        params.id = clinicalTrial.id

        def model = controller.show()

        assert model.clinicalTrialInstance == clinicalTrial
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrial/list'


        def clinicalTrial = new ClinicalTrial()

        // TODO: populate valid domain properties

        assert clinicalTrial.save() != null

        params.id = clinicalTrial.id

        def model = controller.edit()

        assert model.clinicalTrialInstance == clinicalTrial
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrial/list'

        response.reset()


        def clinicalTrial = new ClinicalTrial()

        // TODO: populate valid domain properties

        assert clinicalTrial.save() != null

        // test invalid parameters in update
        params.id = clinicalTrial.id

        controller.update()

        assert view == "/clinicalTrial/edit"
        assert model.clinicalTrialInstance != null

        clinicalTrial.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/clinicalTrial/show/$clinicalTrial.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrial/list'

        response.reset()

        def clinicalTrial = new ClinicalTrial()

        // TODO: populate valid domain properties
        assert clinicalTrial.save() != null
        assert ClinicalTrial.count() == 1

        params.id = clinicalTrial.id

        controller.delete()

        assert ClinicalTrial.count() == 0
        assert ClinicalTrial.get(clinicalTrial.id) == null
        assert response.redirectedUrl == '/clinicalTrial/list'
    }
}
