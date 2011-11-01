package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ClinicalTrialCategoryController)
@Mock(ClinicalTrialCategory)
class ClinicalTrialCategoryControllerTests {

    void testIndex() {
        controller.index()
        assert "/clinicalTrialCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.clinicalTrialCategoryInstanceList.size() == 0
        assert model.clinicalTrialCategoryInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.clinicalTrialCategoryInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.clinicalTrialCategoryInstance != null
        assert view == '/clinicalTrialCategory/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/clinicalTrialCategory/show/1'
        assert controller.flash.message != null
        assert ClinicalTrialCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialCategory/list'


        def clinicalTrialCategory = new ClinicalTrialCategory()

        // TODO: populate domain properties

        assert clinicalTrialCategory.save() != null

        params.id = clinicalTrialCategory.id

        def model = controller.show()

        assert model.clinicalTrialCategoryInstance == clinicalTrialCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialCategory/list'


        def clinicalTrialCategory = new ClinicalTrialCategory()

        // TODO: populate valid domain properties

        assert clinicalTrialCategory.save() != null

        params.id = clinicalTrialCategory.id

        def model = controller.edit()

        assert model.clinicalTrialCategoryInstance == clinicalTrialCategory
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialCategory/list'

        response.reset()


        def clinicalTrialCategory = new ClinicalTrialCategory()

        // TODO: populate valid domain properties

        assert clinicalTrialCategory.save() != null

        // test invalid parameters in update
        params.id = clinicalTrialCategory.id

        controller.update()

        assert view == "/clinicalTrialCategory/edit"
        assert model.clinicalTrialCategoryInstance != null

        clinicalTrialCategory.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/clinicalTrialCategory/show/$clinicalTrialCategory.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialCategory/list'

        response.reset()

        def clinicalTrialCategory = new ClinicalTrialCategory()

        // TODO: populate valid domain properties
        assert clinicalTrialCategory.save() != null
        assert ClinicalTrialCategory.count() == 1

        params.id = clinicalTrialCategory.id

        controller.delete()

        assert ClinicalTrialCategory.count() == 0
        assert ClinicalTrialCategory.get(clinicalTrialCategory.id) == null
        assert response.redirectedUrl == '/clinicalTrialCategory/list'
    }
}
