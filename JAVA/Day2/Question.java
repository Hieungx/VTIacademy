package Day2;

import java.time.LocalDate;
import java.util.Date;

public class Question {
	int					questionID	;
	String				content		;
	CategoryQuestion	category	;
	TypeQuestion		type		;
	Account					creator	;
	LocalDate			createDate	;
	Exam[] exams;
}
