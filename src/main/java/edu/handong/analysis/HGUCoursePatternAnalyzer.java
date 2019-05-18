package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.ArrayList;

public class HGUCoursePatternAnalyzer {

	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis"
						};

	int numOfStudents;
	int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	//	Student[] students;
//	Course[] courses;

	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {

		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);

		students = initiateStudentArrayFromLines(lines);

		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}

		courses = initiateCourseArrayFromLines(lines);

		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}

	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		int j=0;
		int nameLength = lines.length;
		String[] names = new String[nameLength];
		Student[] myStudent = new Student[nameLength];

		for(int i=0;i<nameLength;i++) {
			names[i] = lines[i].split(",")[1].trim();
			Student student1 = new Student(names[i]);
			if(i>0) {
				if(studentExist(myStudent,student1) ==false) {
					myStudent[j] = new Student(names[i]);
					j++;
				}
			}
			else {
				myStudent[j] = new Student(names[i]);
				j++;

			}

		}

		ArrayList<Student> myStudent2 = new ArrayList<Student>();

		for(int i=0;i<j;i++) {
			myStudent2.add(myStudent[i]);
//			myStudent2[i] = myStudent[i];
		}
		// TODO: implement this method


		return myStudent2;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {

		int i=0;


		while(students[i]!=null) {
			if(students[i].getName().equals(student.getName()) ==true)
				return true;
			else
				i++;
		}
		// TODO: implement this method

			return false;
	}

	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {

		int j=0;
		int nameLength = lines.length;
		String[] names = new String[nameLength];
		Course[] myCourse = new Course[nameLength];

		for(int i=0;i<nameLength;i++) {
			names[i] = lines[i].split(",")[2].trim();
			Course course1 = new Course(names[i]);
			if(i>0) {
				if(courseExist(myCourse,course1) ==false) {
					myCourse[j] = new Course(names[i]);
					j++;
				}
			}
			else {
				myCourse[j] = new Course(names[i]);
				j++;

			}

		}

		ArrayList<Course> myCourse2 = new ArrayList<Course>();

		for(int i=0;i<j;i++) {
			myCourse2.add(myCourse[i]);
//			myCourse2[i] = myCourse[i];
		}

		// TODO: implement this method


		return myCourse2;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {

		int i=0;


		while(courses[i]!=null) {
			if(courses[i].getCourseName().equals(course.getCourseName()) ==true)
				return true;
			else
				i++;
		}
		// TODO: implement this method

			return false;

	}

}
