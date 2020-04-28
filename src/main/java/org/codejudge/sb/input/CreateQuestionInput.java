package org.codejudge.sb.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionInput {

    String name;
    String options;
    byte correctOption;
    short points;
    int quiz;
}
