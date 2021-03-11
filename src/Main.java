import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.NullPointerException;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;


import org.xml.sax.SAXException;






public class Main{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException,NullPointerException{
		Mark mark = new Mark();
		Course courseName = new Course();
		Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		int option;
		String name;
		String surname;
		int id;
		String gender;
		String dob;
		String status;
		String graden;
		String injava;
		String incalculus2;
		String inhistory;
		String inweb;
		String inenglish;
		Scanner sc=new Scanner(System.in);
		 int point=0;
		String connectionUrl = "jdbc:postgresql://localhost:5432/students";
	    Class.forName("org.postgresql.Driver");
	    System.out.println("Choose one option");
	    System.out.println("1. Show students list");
	    System.out.println("2. Show courses");
	    System.out.println("3. Add student");
	    System.out.println("4. Show student's grade");
		System.out.println("5. Grade in Letter");
		System.out.println("6. Add student's grade");
	    try {
	  	   con = DriverManager.getConnection(connectionUrl,"postgres","502568");
	  	 st=con.createStatement();
	  	 option =sc.nextInt();
	  	 if(option==1) {
	  	 rs=st.executeQuery("select * from students_list");
		
	  	System.err.println("Students list:");
        while(rs.next()) 
     	   System.out.println("Student's ID-"+rs.getInt("id")+". Name-"+rs.getString("firstname")+". Surname-"+rs.getString("surname")+". Gender-"+rs.getString("gender")+". Date of birth-"+rs.getDate("dob")+". Status-"+rs.getString("status"));
	  	 }
	  	 else if(option==2) {
	  		
	    rs1=st.executeQuery("select * from courses");
	    System.err.println("Info about student's courses");
	    while(rs1.next())
	    	System.out.println("Student name-"+rs1.getString("student_name")+". Course-"+rs1.getString("course")+". Teacher-"+rs1.getString("teacher"));
	    
	  	 }
	  	 else if(option==3) {
	  		 System.out.println("Type name");
	  		name=sc.next();
	  		 System.out.println("Type surname");
	  		 surname=sc.next();
	  		System.out.println("Type gender");
	  		gender=sc.next();
	  		System.out.println("Type date of birth yyyy-MM-dd");
	  		dob=sc.next();
	  		System.out.println("Type status");
	  		status=sc.next();
	  		rs2=st.executeQuery("insert into students_list(firstname,surname,gender,dob,status) values ('"+name+"','"+surname+"','"+gender+"','"+dob+"','"+status+"')");
	  		}
	  	 else if(option==4) {
	  		 System.out.println("Type student's id");
	  		 id=sc.nextInt();
	  		 rs3=st.executeQuery("select * from grades where (id="+"'"+id+"'"+")");
	  		 while(rs3.next()) {
	  			 System.out.println("ID-"+rs3.getInt("id")+". Student name-"+rs3.getString("name")+". Java's grade="+rs3.getDouble("java")+". Calc grade="+rs3.getDouble("calculus_2")+". History grade="+rs3.getDouble("history")+". WEB grade="+rs3.getDouble("web_development")+". English grade="+rs3.getDouble("english"));
	  		 }
	  	 }
	  	 else if(option==5){
			System.out.println("Type to get letter mark");
			  point= sc.nextInt();
			   mark.addPoint(point);
			   mark.convertation();
			 	System.out.println("Grades with letters: "+mark.getPoint());
			   System.out.println("Grades with letters: "+mark.getLetter());

		 }
		 else if(option==6){
			 sc.nextLine();
			 System.out.println("Type name");
			 graden=sc.next();
			 System.out.println("Type java grade:");
			 injava=sc.next();
			 System.out.println("Type calculus grade:");
			 incalculus2=sc.next();
			 System.out.println("Type history grade:");
			 inhistory=sc.next();
			 System.out.println("Type web technology grade:");
			 inweb=sc.next();
			 System.out.println("Type english grade:");
			 inenglish=sc.next();
			 rs4=st.executeQuery("insert into grades(name,java,calculus_2,history,web_development,english) values ('"+graden+"','"+injava+"','"+incalculus2+"','"+inhistory+"','"+inweb+"','"+inenglish+"')");
		 }
	  	 
	  	 
	    
	    }catch(Exception e) {
	  	   System.out.println(e);
	    }finally {
	 	   try {
	 		  st.close();
	 		 con.close();
	 		   rs.close();

			   for (var resultSet : Arrays.asList(rs1, rs2, rs3)) {
				   resultSet.close();
			   }

		   }catch(SQLException throwables) {
	 		   throwables.printStackTrace();
	 	   }
		
		
		
	}}}
	
	
	
