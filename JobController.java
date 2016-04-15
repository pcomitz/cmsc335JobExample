/* 
 * A controller/driver for creature jobs 
 */

 public class JobController { 

 	public static void main(String[] args) { 

		JobStatus jobStatus = new JobStatus(); 
		CreatureJob creatureJob; 

		//start the job
 		if(args.length >= 2)
 			creatureJob = new CreatureJob(args[0], Double.parseDouble(args[1]), jobStatus);
 		else
 			creatureJob = new CreatureJob("Topple Mordor", 4, jobStatus);
 	
 		//start the UI 
 		MyUI ui = new MyUI(jobStatus); 
 	
 	}

 } ///~