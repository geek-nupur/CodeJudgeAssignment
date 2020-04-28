package org.codejudge.sb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "options"}))
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = " options", nullable = false)
    private String options;

    @Column(name = "correct_option", nullable = false)
    private byte correctOption;

    @Column(name = "quiz_id", nullable = false)
    private int quiz;

    @Column(name = "points", nullable = false)
    private short points;

}
