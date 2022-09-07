package Persistance;
import java.sql.*;

import java.util.*;
import Metier.*;
import Presentation.*;

//
public class test{
  public static void main(String args[]) throws ClassNotFoundException
   {    
//	    	
//	    	package com.journaldev.files;
//
	    	/*import java.awt.Desktop;
	    	import java.io.File;
	    	import java.io.IOException;
	    	
	    	public class test{

	    	    public static void main(String[] args) throws IOException {
	    	        //text file, should be opening in default text editor
	    	        File file = new File("C:\\Users\\user\\Documents\\document_livrable\\Filtre.java");
	    	        
	    	        //first check if Desktop is supported by Platform or not
	    	        if(!Desktop.isDesktopSupported()){
	    	            System.out.println("Desktop is not supported");
	    	            return;
	    	        }
	    	        
	    	        Desktop desktop = Desktop.getDesktop();
	    	        if(file.exists()) desktop.open(file);
	    	        
	    	        //let's try to open PDF file
	    	        
	    	    }*/

	    	//}
	    	Controleur s=new Controleur();
	    	//modifierprojet f = new modifierprojet(s);
	    	//s.getdoc("fil", 1);
	    	login f = new login(s);
	    	//formsdoc f =new formsdoc(s, 2);
	    	//fenetreaffectation f = new fenetreaffectation(s);
	    	//Daoprojet dao = new Daoprojet();
	    	//fenetreprojet f = new  fenetreprojet(s, dao.getAll());
	    	f.show();
	    	//gestion fe = new gestion(s);
	    	 //.arg.show();
	    	/*
	        // Creating the connection using Oracle DB
	        String sql="insert into etudiant (nom, prenom ,email , filiere , niveau , password)"
	        		+ "values ('khalid', 'khalid' , 'kh@gmail.com','GI', '2eme' ,'12345')";
	        Connection con = null;
	 
	        // Try block to check for exceptions
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            // Registering drivers
	            DriverManager.registerDriver(
	                new com.mysql.jdbc.Driver());
	 
	            // Reference to connection interface
	            con = Connexion.getConnexion();
	            // Creating a statement
	            Statement st = con.createStatement();
	            int m = st.executeUpdate(sql);
	            if (m == 1)
	                System.out.println(
	                    "inserted successfully : " + sql);
	            else
	                System.out.println("insertion failed");
	            
	            con.close();
	        }
	 
	        // Catch block to handle exceptions
	        catch (Exception ex) {
	            // Display message when exceptions occurs
	            System.err.println(ex);*/
	     
	        }}
	     
	

