package com.pubstack.homework.ws.boxed.api.delegate;

import com.pubstack.homework.ws.boxed.api.OperationsApiDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class DefaultApiDelegateImpl.
 */
@Service
public class DefaultApiDelegateImpl extends ApiDelegate implements OperationsApiDelegate {

    /**
     * The log.
     */
    Logger log = LoggerFactory.getLogger(DefaultApiDelegateImpl.class);

    /**
     * Gets the operations.
     *
     * @return the operations
     */
    @Override
    public ResponseEntity<List<String>> getOperations() {
        final Optional<String> acceptHeader = getAcceptHeader();
        ResponseEntity<List<String>> re = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        if (acceptHeader.isPresent() && acceptHeader.get().contains("application/json")) {
            final List<String> methods = new ArrayList<>();
            methods.add("/operations");
            methods.add("/merge");
            re = new ResponseEntity<>(methods, HttpStatus.OK);
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface,"
                    + " so no example is generated");
        }
        return re;
    }
}
