package at.fh.mc.task_2a_service;

import at.fh.mc.task_2a_server.DummyData;

import javax.jws.WebService;

@WebService
public interface ISimpleInterface {
    String saySomething();
    DummyData getDummyData(String _name);
}
