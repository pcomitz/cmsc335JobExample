/*
 * A text UI for reporting Tjob status
 */


 public class MyUI { 

 	private JobStatus jobStatus; 
 	private boolean runGUI = false; 
 	private String[] statusFields; 
 	
 	public MyUI(JobStatus jobStatus) {
 		this.jobStatus = jobStatus;  
 		statusFields = new String[2]; 
 		runUI(); 
 	}

 	private void runUI() { 
 			
 		while(!(jobStatus.getStatusString().equals("DONE"))) { 
 			System.out.println("UI running"); 
 			statusFields = jobStatus.getStatusArray();
 			System.out.println("jobStatus:"+statusFields[0]); 
 			System.out.println("percentComplete:"+statusFields[1]); 

 		} //while	

 		statusFields = jobStatus.getStatusArray();
 		System.out.println("final jobStatus:"+statusFields[0]); 
 		System.out.println("percentComplete:"+statusFields[1]); 	
 	}

 } ///~