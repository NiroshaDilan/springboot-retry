package lk.icoder.retry;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project retry
 * @Author DILAN on 1/29/2020
 */
@Service
public class TestServiceImpl implements TestService {

    private RestTemplate restTemplate;

    public TestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getEmployeeById(int id) {

        final String uri = "http://localhost:8081/employees/{id}";

        Map<String, String> params = new HashMap<>();
        params.put("id", "1");

        String result = restTemplate.getForObject(uri, String.class, params);
        assert result != null;
        if (result.equals("Pending")) {
            throw new RemoteServiceNotAvailableException("Retrying...");
        }

        return result;
    }

    @Override
    public String getBackendResponseFallBack(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}
