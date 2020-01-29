package lk.icoder.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @Project retry
 * @Author DILAN on 1/29/2020
 */
public interface TestService {

    @Retryable(value = { RemoteServiceNotAvailableException.class }, maxAttempts = 10, backoff = @Backoff(delay = 1000))
    String getEmployeeById(int id);

    @Recover
    String getBackendResponseFallBack(RuntimeException e);
}
