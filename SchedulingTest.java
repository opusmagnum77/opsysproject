import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;


public class SchedulingTest {

	static ArrayList<Integer> originalJobs = new ArrayList<Integer>();
	static ArrayList<Integer> FCFSJobs = new ArrayList<Integer>();
	static ArrayList<Integer> SJNJobs = new ArrayList<Integer>();
	static ArrayList<Integer> waitingTimesForFCFS = new ArrayList<Integer>();
	static ArrayList<Integer> waitingTimesForSJN = new ArrayList<Integer>();
	static int numJobs = 0;

	public void run(){
		numJobs = 10;
		FCFS();
	}


	static void loadJobs() {

		//	Create random execution time for each job with arrivalOrder of n (0-numJobs) within 1-10 seconds
		for(int i=0; i<=numJobs; i++){
			int executionTime = new Random().nextInt(10000) + 1000; //time in millisecs
			FCFSJobs.add(executionTime);



			FCFSJobs = originalJobs;
			SJNJobs = originalJobs;


		}

	}
	public static void FCFS(){
		long serviceTime=0;
		//Execute list of jobs 	

		//set start time to current system time
		long startTime = System.currentTimeMillis();


		//this forces system to wait for duraiton of job
		for (int i=0; i<FCFSJobs.size(); i++){ 
			System.out.println(FCFSJobs.get(i));
			long startTimeWait = System.currentTimeMillis(); //fetch starting time
			while(false||(System.currentTimeMillis()-startTimeWait)<FCFSJobs.get(i));
			{


			}

			serviceTime = System.currentTimeMillis()-startTime;
			long waitTime = serviceTime-1000*i; //ie: 1st item came in at 1,000
			int waitTimeInt = (int)serviceTime;
			waitingTimesForFCFS.add(waitTimeInt);
			System.out.println("Service Time " + serviceTime + " miliseconds.");



		}

		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time for FCFS was " + (stopTime - startTime) + " miliseconds.");
		
		//Find average completionTime
		//	Sum all completionTimes and divide by numJobs
		//Print average completion time 
		int holdSum=0;
		for (Integer wT: waitingTimesForFCFS){
			holdSum += wT;
		}

		int waitTimeAvg = holdSum/waitingTimesForFCFS.size();

		System.out.println("Avg wait time: " + waitTimeAvg);
	}




	public static void SJN(){
		long startTime = System.currentTimeMillis();


		Collections.sort(SJNJobs);
		//Sort list by execution time
		//Execute list of jobs 	
		//	For each job
		//Wait for executionTime
		//Add waitTime to completionTimesForSJN
		//




		//this forces system to wait for duration of job
		for (int i=0; i<SJNJobs.size(); i++){ 
			System.out.println(SJNJobs.get(i));
			long startTimeWait = System.currentTimeMillis(); //fetch starting time
			while(false||(System.currentTimeMillis()-startTimeWait)<SJNJobs.get(i));


			{


			}

			long serviceTime = System.currentTimeMillis()-startTime;
			int j = originalJobs.indexOf(SJNJobs.get(i));
			long waitTime = serviceTime-1000*j; //ie: 1st item came in at 1,000
			int waitTimeInt = (int)waitTime;
			waitingTimesForSJN.add(waitTimeInt);
			System.out.println("Service Time " + serviceTime + " miliseconds.");


		}

		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time for SJN was " + (stopTime - startTime) + " miliseconds.");
		
		//Find average completionTime
		//	Sum all completionTimes and divide by numJobs
		//Print average completion time 
		int holdSum=0;
		for (Integer wT: waitingTimesForSJN){
			holdSum += wT;
		}

		int waitTimeAvg = holdSum/waitingTimesForSJN.size();

		System.out.println("Avg wait time: " + waitTimeAvg);


	}
	//
	public static void test(){
		numJobs = 10;
		loadJobs();
		FCFS();
		SJN();


	}
	

	//Find average completion time for SJN
	//	Sum all completionTimes and divide by numJobs
	//Print average execution time for SJN


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
	}

}


