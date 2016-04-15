/*
 * a class for representing the job status
 * putStatus and getStatusArray are synchronized
 */


 public class JobStatus { 

 	private double percentComplete; 
 	private String statusString = null;
 	private String[] fields = new String[2]; 
 	private boolean statusUpdateAvailable = false;

 	public JobStatus() { 
 		percentComplete = 0; 
 		statusString = "WAITING"; 
 	}

 	//getters and setters
 	public void setPercentComplete(double percentComplete) {
 		this.percentComplete = percentComplete; 
 	}

 	public void setStatus(String status) { 
 		this.statusString = status; 
 	}

 	public double getPercentComplete() { 
 		return percentComplete; 
 	}

 	public String getStatusString() { 
 		return statusString; 
 	}

 	public JobStatus getStatus() { 
 		return this; 
 	}

 	/*
 	 * note synchronized
 	 */
 	public synchronized void putStatus(double percentComplete, String statusString) { 
 		
 		//wait for GUI to retrive status 
 		while(statusUpdateAvailable == true) { 
 			try{
 				wait();
 			} catch(InterruptedException e) { 
 				System.out.println(e.getStackTrace()); 
 			}	 
 		}

 		//notify new status update available
 		this.percentComplete = percentComplete; 
 		this.statusString = statusString; 
 		statusUpdateAvailable = true; 
 		notify();
 	}

 	/*
 	 * note synchronized
 	 */
 	public synchronized String[] getStatusArray() { 

 		//no new update,  wait
 		while(statusUpdateAvailable == false) { 
 			try { 
 				//wait for job to put a new status
 				wait();
 			} catch(InterruptedException e) { 
 				System.out.println(e.getStackTrace()); 
 			}
 		}

 		//notify GUI that update is available
 		statusUpdateAvailable = false; 
 		notify(); 
 		fields[0] = statusString;  
 		fields[1] = new Double(percentComplete).toString();
 		return fields; 
 	}


 } ///~