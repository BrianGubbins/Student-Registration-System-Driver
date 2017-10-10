/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.briangubbins.StudentRegistrationSystemDriver;

/**
 *
 * @author brian
 */

import java.util.ArrayList;
import org.joda.time.LocalDate;
import io.github.briangubbins.StudentRegistrationSystem.*;

public class driver {
    
    public static void main(String[] args) {

                // creating modules
                Module machineLearning = new Module("Machine Learning & Data Mining", "CT475");
		Module advancedSkills = new Module("Advanced Professional Skills", "CT436");
		Module softwareEngineering = new Module("Software Engineering", "CT417");
                Module PowerElectronics = new Module("Power Electronics", "EE457");
                Module PowerSystems = new Module("Power Systems", "EE456");
                
                // creating course start and end dates
                LocalDate startDate = new LocalDate(2015, 9, 5);
		LocalDate endDate = new LocalDate(2019, 5, 31);
                
                /* adding students to a number of CSIT Modules and them modules to the CSIT course */
                ArrayList<Module> CSITModules = new ArrayList<Module>();
		CSITModules.add(advancedSkills);
		CSITModules.add(softwareEngineering);
		CSITModules.add(machineLearning);
                
                Student student1 = new Student("Eoghan Horan", 21, new LocalDate(1996, 3, 17), 1);
		Student student2 = new Student("Nada Newesser", 22, new LocalDate(1995, 9, 28), 2);
		Student student3 = new Student("Stephen Downey", 23, new LocalDate(1994, 8, 23), 3);
                
                ArrayList<Student> CSITStudents = new ArrayList<Student>();
		CSITStudents.add(student1);
		CSITStudents.add(student2);
		CSITStudents.add(student3);
                
                CourseProgramme CSIT = new CourseProgramme("Computer Science & Information Technology", CSITModules, startDate, endDate);

                enrollment(CSITStudents, CSITModules, CSIT);
                
                printStudents(CSITStudents);

		
                /* adding students to a number of engineering Modules and them modules to the engineering course */
                ArrayList<Module> engineeringModules = new ArrayList<Module>();
		engineeringModules.add(machineLearning);
		engineeringModules.add(PowerElectronics);
		engineeringModules.add(PowerSystems);

		Student student4 = new Student("Joe dockry", 20, new LocalDate(1997, 2, 12), 4);
		Student student5 = new Student("Fred Moloney", 25, new LocalDate(1992, 9, 14), 5);
		Student student6 = new Student("Brian Gubbins", 21, new LocalDate(1996, 9, 8), 6);

		ArrayList<Student> engineeringStudents = new ArrayList<Student>();
		engineeringStudents.add(student4);
		engineeringStudents.add(student5);
		engineeringStudents.add(student6);
                
                CourseProgramme engineering = new CourseProgramme("Electronic and Computer Engineering", engineeringModules, startDate, endDate);

		enrollment(engineeringStudents, engineeringModules, engineering);

		printStudents(engineeringStudents);
	}

	public static void enrollment(ArrayList<Student> students, ArrayList<Module> modules, CourseProgramme course) {
		for(Module module : modules) {
			module.addStudents(students);
		}
		for(Student student : students) {
			student.enroll(course);
		}
	}

	public static void printStudents(ArrayList<Student> students) {
		for(Student student : students) {
			printStudentDetails(student);
			CourseProgramme course = student.getCourse();
			System.out.println("Course Programme: " + course.getName());
			System.out.println("Modules: " + formatModules(course.getModules()));
			System.out.println("\n");
		}
	}

	public static void printStudentDetails(Student student) {
		System.out.println("Name: " + student.getName());
                System.out.println("Username: " + student.getUsername());
		System.out.println("ID: " + student.getId());
		System.out.println("Age: " + student.getAge());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
	}

	public static String formatModules(ArrayList<Module> modules) {
		String allModules = "";
		for(Module module : modules) {
			allModules += module.getName() + ", ";
		}
		return allModules;
	}
    
}


