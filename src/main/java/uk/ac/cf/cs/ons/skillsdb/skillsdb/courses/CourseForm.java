package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseForm {

    @NotNull
    @Size(min = 2, max = 30, message = "Invalid name")
    private String name;

    @NotNull
    @Size(min = 2, max = 30, message = "Invalid Address Line")
    private String description;

    @NotNull
    private Boolean isFree = Boolean.FALSE;

    @NotNull
    private LocalDateTime date;


    @NotNull
    @Min(1)
    @NumberFormat(style = NumberFormat.Style.DEFAULT)
    private Double price;

}
