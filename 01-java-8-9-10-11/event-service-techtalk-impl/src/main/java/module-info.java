module com.code.sample.event.service.techtalk {

    requires com.code.sample.event.service;

    exports com.code.sample.event.service.techtalk;

    provides com.code.sample.event.service.EventService
        with com.code.sample.event.service.techtalk.TechTalkEventService;
}