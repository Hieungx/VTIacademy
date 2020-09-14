package Day1;

import java.time.LocalDate;
import java.util.Date;

public class Exam {
	short 				examID		;
	String 				code		;
	String 				title		;
	CategoryQuestion 	category;
	short 				duration	;
	Account 				creator	;
	LocalDate 			createDate	;
	Question[]	questions;
}
