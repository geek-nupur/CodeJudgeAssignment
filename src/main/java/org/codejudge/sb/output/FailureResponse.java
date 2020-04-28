package org.codejudge.sb.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FailureResponse {

    String status = "failure";
    String reason;

}
