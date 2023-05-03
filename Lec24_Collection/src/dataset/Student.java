package dataset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String id;
	private String name;
	private int grade;
	private String major;
	private Score score;

} // end class Student
