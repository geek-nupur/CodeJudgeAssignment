package org.codejudge.sb.Exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FailureException extends Exception {

    String status;
    String reason;
}
