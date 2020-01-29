package lk.icoder.retry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project retry
 * @Author DILAN on 1/29/2020
 */
@RestController
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("employee-details/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable("id") Integer id) {
        String employee = testService.getEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
