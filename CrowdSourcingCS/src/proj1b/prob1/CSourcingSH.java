package proj1b.prob1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stripe.Stripe;


//Cookie expires in 1 minute
//All System.out messages are used for debugging and error checking
@WebServlet("/CSourcingSH")
public class CSourcingSH extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public CSourcingSH() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.println("Fuck you ");
    	
    	
    	
    	Stripe.apiKey = "sk_test_i9n6SuzJusoU4ExgCdDUp8mt";
    	
    	
    	PrintWriter out = response.getWriter();
    	/*
        response.setContentType("text/html"); 
        out.println("<h2>Please wait while we process your request . . . </h2>");*/
    
        
    	// Get the credit card details submitted by the form
    	//String token = request.getParameter("stripetok");
    	String name = request.getParameter("nm");
    	String netid = request.getParameter("nid");
    	String pamount = request.getParameter("op1");
    	String choice = request.getParameter("op2");
    	Calendar cal = Calendar.getInstance();
    	String curdate =  cal.getTime().toString();
    	String finalString = curdate + "," +name + "," + netid + "," + pamount + "," + choice;
    	System.out.println("The id is "+finalString);
    	
    	File f = new File("/Users/akshaytata/Library/Mobile Documents/com~apple~CloudDocs/shdata.text");
    	if(f.exists())
    	{
    		System.out.println(f.getPath());
    		try(FileWriter fw = new FileWriter(f.getPath(), true);
    			    BufferedWriter bw = new BufferedWriter(fw);
    			    PrintWriter out1 = new PrintWriter(bw))
    			{
    			    out1.println(finalString);
    			    //more code
    			} catch (IOException e) {
    			    //exception handling left as an exercise for the reader
    			}
    	}
    	else
    	{
    		//Create file
    		f.createNewFile();
    		
    		//Open and write in file
    		try(FileWriter fw = new FileWriter("/Users/akshaytata/Library/Mobile Documents/com~apple~CloudDocs/shdata.text", true);
    			    BufferedWriter bw = new BufferedWriter(fw);
    			    PrintWriter out1 = new PrintWriter(bw))
    			{
    			    out1.println(finalString);
    			} catch (IOException e) {
    			    //exception handling left as an exercise for the reader
    			}
    		
    		
    		
    	}
    	
    	
        try {
            Thread.sleep(3000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
    	
    	  out.flush();
    	  out = response.getWriter();
    	  response.setContentType("text/html"); 
          out.println("Payment Confirmed!. See you at the social hour"); 
      

}
}
