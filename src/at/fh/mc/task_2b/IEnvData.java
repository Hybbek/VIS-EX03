package at.fh.mc.task_2b;

import javax.jws.WebService;

@WebService
public interface IEnvData {
    EnvData[] requestEnvironmentDataTypes();
}
