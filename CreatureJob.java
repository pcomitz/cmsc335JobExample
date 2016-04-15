/*
 * CreatureJob -  keep it simple !
 */

/* 
 *  Jobs for creatures
 *  measure time in seconds
 *    j:<index>:<name>:<creature index>:<time>[:<required artifact:type>:<number>]*	
 * 	  j : 50000 : Get Help : 20000 : 4.00 : Stone : 0 : Potions : 1 : Wands : 1 : Weapons : 0 
 */

 public class CreatureJob implements Runnable { 

 	private String jobName = "";
 	private double jobTime = 0; 
 	private JobStatus jobStatus = null;


 	public CreatureJob(String jobName, double jobTime, JobStatus jobStatus) { 
 		this.jobName = jobName; 
 		this.jobTime = jobTime;  
 		this.jobStatus = jobStatus; 
 		new Thread(this, jobName).start(); 
 	}

 	// Thread starts here
 	public void run()  { 

 		System.out.println("Starting job:"+this.jobName); 

 		long time = System.currentTimeMillis();
    	long startTime = time;
    	double stopTime = (time + 1000 * this.jobTime);
    	double percentComplete = 0; 

    	//main job loop
    	while(time < stopTime) { 

    		//job thread sleeps for 100 ms 
    		try {
    			Thread.currentThread().sleep(100);  
    		} catch (InterruptedException e) { 
    			System.out.println(e.getStackTrace()); 
    		}

    		//update status 
    		percentComplete = (double)(((time - startTime))/(this.jobTime*10)); 
    		jobStatus.putStatus( percentComplete, "RUNNING"); 

    		//get current time
			time = System.currentTimeMillis();

    	} //while

    	//final status and percent complete
    	jobStatus.putStatus( 100, "DONE"); 

 	} //run

 } ///~