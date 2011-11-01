package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(TherapeuticClassController)
@Mock(TherapeuticClass)
class TherapeuticClassControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/therapeuticClass/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.therapeuticClassInstanceList.size() == 0
        assert model.therapeuticClassInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.therapeuticClassInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.therapeuticClassInstance != null
        assert view == '/therapeuticClass/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/therapeuticClass/show/1'
        assert controller.flash.message != null
        assert TherapeuticClass.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/therapeuticClass/list'


        populateValidParams(params)
        def therapeuticClass = new TherapeuticClass(params)

        assert therapeuticClass.save() != null

        params.id = therapeuticClass.id

        def model = controller.show()

        assert model.therapeuticClassInstance == therapeuticClass
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/therapeuticClass/list'


        populateValidParams(params)
        def therapeuticClass = new TherapeuticClass(params)

        assert therapeuticClass.save() != null

        params.id = therapeuticClass.id

        def model = controller.edit()

        assert model.therapeuticClassInstance == therapeuticClass
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/therapeuticClass/list'

        response.reset()


        populateValidParams(params)
        def therapeuticClass = new TherapeuticClass(params)

        assert therapeuticClass.save() != null

        // test invalid parameters in update
        params.id = therapeuticClass.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/therapeuticClass/edit"
        assert model.therapeuticClassInstance != null

        therapeuticClass.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/therapeuticClass/show/$therapeuticClass.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        therapeuticClass.clearErrors()

        populateValidParams(params)
        params.id = therapeuticClass.id
        params.version = -1
        controller.update()

        assert view == "/therapeuticClass/edit"
        assert model.therapeuticClassInstance != null
        assert model.therapeuticClassInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/therapeuticClass/list'

        response.reset()

        populateValidParams(params)
        def therapeuticClass = new TherapeuticClass(params)

        assert therapeuticClass.save() != null
        assert TherapeuticClass.count() == 1

        params.id = therapeuticClass.id

        controller.delete()

        assert TherapeuticClass.count() == 0
        assert TherapeuticClass.get(therapeuticClass.id) == null
        assert response.redirectedUrl == '/therapeuticClass/list'
    }
}
