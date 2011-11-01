package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ClinicalTrialSubCategoryController)
@Mock(ClinicalTrialSubCategory)
class ClinicalTrialSubCategoryControllerTests {

    void testIndex() {
        controller.index()
        assert "/clinicalTrialSubCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.clinicalTrialSubCategoryInstanceList.size() == 0
        assert model.clinicalTrialSubCategoryInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.clinicalTrialSubCategoryInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.clinicalTrialSubCategoryInstance != null
        assert view == '/clinicalTrialSubCategory/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/clinicalTrialSubCategory/show/1'
        assert controller.flash.message != null
        assert ClinicalTrialSubCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialSubCategory/list'


        def clinicalTrialSubCategory = new ClinicalTrialSubCategory()

        // TODO: populate domain properties

        assert clinicalTrialSubCategory.save() != null

        params.id = clinicalTrialSubCategory.id

        def model = controller.show()

        assert model.clinicalTrialSubCategoryInstance == clinicalTrialSubCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialSubCategory/list'


        def clinicalTrialSubCategory = new ClinicalTrialSubCategory()

        // TODO: populate valid domain properties

        assert clinicalTrialSubCategory.save() != null

        params.id = clinicalTrialSubCategory.id

        def model = controller.edit()

        assert model.clinicalTrialSubCategoryInstance == clinicalTrialSubCategory
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialSubCategory/list'

        response.reset()


        def clinicalTrialSubCategory = new ClinicalTrialSubCategory()

        // TODO: populate valid domain properties

        assert clinicalTrialSubCategory.save() != null

        // test invalid parameters in update
        params.id = clinicalTrialSubCategory.id

        controller.update()

        assert view == "/clinicalTrialSubCategory/edit"
        assert model.clinicalTrialSubCategoryInstance != null

        clinicalTrialSubCategory.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/clinicalTrialSubCategory/show/$clinicalTrialSubCategory.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/clinicalTrialSubCategory/list'

        response.reset()

        def clinicalTrialSubCategory = new ClinicalTrialSubCategory()

        // TODO: populate valid domain properties
        assert clinicalTrialSubCategory.save() != null
        assert ClinicalTrialSubCategory.count() == 1

        params.id = clinicalTrialSubCategory.id

        controller.delete()

        assert ClinicalTrialSubCategory.count() == 0
        assert ClinicalTrialSubCategory.get(clinicalTrialSubCategory.id) == null
        assert response.redirectedUrl == '/clinicalTrialSubCategory/list'
    }
}
