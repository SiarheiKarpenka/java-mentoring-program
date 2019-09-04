module com.code.sample.event.service.workshop {

    requires com.code.sample.event.service;

    exports com.code.sample.event.service.workshop;

    provides com.code.sample.event.service.EventService
        with com.code.sample.event.service.workshop.WorkshopEventService;

}