package kmitl.charanpat.mvc.model.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student",uniqueConstraints = {@UniqueConstraint(columnNames={"student_id"})})
public class Student {

    @Id
    @NotNull
    @Column(name = "student_id" ,columnDefinition = "character varying (6)",nullable = false)
    private String student_id;

    @NotNull
    @Column(name = "temperature", columnDefinition = "DOUBLE(10, 1)")
    private double temperature;

    @NotNull
    @Column(name = "sick", columnDefinition = "character varying (6)",nullable = false)
    private String sick;

}
