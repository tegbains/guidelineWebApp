package com.ajayian



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(PublicationJournalController)
@Mock(PublicationJournal)
class PublicationJournalControllerTests {

    void testIndex() {
        controller.index()
        assert "/publicationJournal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.publicationJournalInstanceList.size() == 0
        assert model.publicationJournalInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.publicationJournalInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.publicationJournalInstance != null
        assert view == '/publicationJournal/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/publicationJournal/show/1'
        assert controller.flash.message != null
        assert PublicationJournal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/publicationJournal/list'


        def publicationJournal = new PublicationJournal()

        // TODO: populate domain properties

        assert publicationJournal.save() != null

        params.id = publicationJournal.id

        def model = controller.show()

        assert model.publicationJournalInstance == publicationJournal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/publicationJournal/list'


        def publicationJournal = new PublicationJournal()

        // TODO: populate valid domain properties

        assert publicationJournal.save() != null

        params.id = publicationJournal.id

        def model = controller.edit()

        assert model.publicationJournalInstance == publicationJournal
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/publicationJournal/list'

        response.reset()


        def publicationJournal = new PublicationJournal()

        // TODO: populate valid domain properties

        assert publicationJournal.save() != null

        // test invalid parameters in update
        params.id = publicationJournal.id

        controller.update()

        assert view == "/publicationJournal/edit"
        assert model.publicationJournalInstance != null

        publicationJournal.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/publicationJournal/show/$publicationJournal.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/publicationJournal/list'

        response.reset()

        def publicationJournal = new PublicationJournal()

        // TODO: populate valid domain properties
        assert publicationJournal.save() != null
        assert PublicationJournal.count() == 1

        params.id = publicationJournal.id

        controller.delete()

        assert PublicationJournal.count() == 0
        assert PublicationJournal.get(publicationJournal.id) == null
        assert response.redirectedUrl == '/publicationJournal/list'
    }
}
