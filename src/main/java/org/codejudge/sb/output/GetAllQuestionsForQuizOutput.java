package org.codejudge.sb.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.codejudge.sb.entities.Question;

import java.util.List;

@Getter
@Builder
public class GetAllQuestionsForQuizOutput {

    String name;
    String description;
    List<Question> questions;

}
