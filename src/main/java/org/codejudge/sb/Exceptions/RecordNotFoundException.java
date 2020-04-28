package org.codejudge.sb.Exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
//@NoArgsConstructor
public class RecordNotFoundException extends Exception {

    String status;
    String reason;

}
