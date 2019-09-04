Feature: Event CRUD Operations

  Scenario: client makes call to POST /event-service/v1.0/events
    When the client calls POST '/event-service/v1.0/events' and Body with Event with title: 'Title 1', place: 'Place 1', speaker 'Speaker 1', event type 'WORKSHOP', date '2018-11-27T19:56:12'.
    Then the client receives status code of 201


  Scenario: client makes call to PUT /event-service/v1.0/events/1
    When the client calls PUT '/event-service/v1.0/events/1' and Body with Event with title: 'Title 2', place: 'Place 2', speaker 'Speaker 2', event type 'TECH_TALK', date '2018-11-27T19:56:12'.
    Then the client receives status code of 200