package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class schedulejobs {
	
	public static class jobInfo {
		public Long weight;
		public Long length;
		
		public jobInfo(){
			this.weight=0l;
			this.length=0l;
		}
	}
	private static File file1 = new File("src/algorithmsCouese/Course3/jobs.txt");
	private static HashMap<Long,ArrayList<jobInfo>> jobPriorityD = new HashMap<Long,ArrayList<jobInfo>>();
	private static HashMap<Double,ArrayList<jobInfo>> jobPriorityR = new HashMap<Double,ArrayList<jobInfo>>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getJobPriority();
		
		//Case1 :  Difference
		Long sumtime = 0l;
		Long sumlength = 0l;
		ArrayList<Long> sumall = new ArrayList<>();
		while (!jobPriorityD.isEmpty()) {
			Collection<Long> keys = jobPriorityD.keySet();
			Long maxkey = Collections.max(keys);
			ArrayList<jobInfo> jobinfos = jobPriorityD.get(maxkey);
			
			ArrayList<Long> weights = new ArrayList<>();
			ArrayList<Long> lenghts = new ArrayList<>();
			
			for (jobInfo jobinfo :jobinfos) {
				weights.add(jobinfo.weight);
				lenghts.add(jobinfo.length);
			}
			while (!weights.isEmpty()) {
				Long obj = Collections.max(weights);
				int index = weights.indexOf(obj);
				
				Long weight = weights.get(index);
				Long length = lenghts.get(index);
				sumlength = sumlength+length;
				sumtime = sumtime + sumlength*weight;
				System.out.println("weight :"+weight);
				System.out.println("length :"+length);
				System.out.println("sumlength :"+sumlength);
				System.out.println("sumlength*weight :"+sumlength*weight);
				System.out.println("sumtime :"+sumtime);
				System.out.println("");
				sumall.add(sumtime);
				weights.remove(index);
				lenghts.remove(index);
			}
			jobPriorityD.remove(maxkey);
		}
		long max = Collections.max(sumall);
		System.out.println("Case1 time: max"+max);
		System.out.println("Case1 time:"+sumtime);
		
		//Case2 :  Ratio
		sumtime = 0l;
		sumlength = 0l;
		while (!jobPriorityR.isEmpty()) {
			Collection<Double> keys = jobPriorityR.keySet();
			Double maxkey = Collections.max(keys);
			ArrayList<jobInfo> jobinfos = jobPriorityR.get(maxkey);
			
			ArrayList<Long> weights = new ArrayList<>();
			ArrayList<Long> lenghts = new ArrayList<>();
			
			for (jobInfo jobinfo :jobinfos) {
				weights.add(jobinfo.weight);
				lenghts.add(jobinfo.length);
			}
			while (!weights.isEmpty()) {
				Long obj = Collections.max(weights);
				int index = weights.indexOf(obj);
				Long weight = weights.get(index);
				Long length = lenghts.get(index);
				sumlength = sumlength+length;
				sumtime = sumtime + sumlength*weight;
				weights.remove(index);
				lenghts.remove(index);
			}
			jobPriorityR.remove(maxkey);
		}
		System.out.println("Case2 time:"+sumtime);
		
		System.out.println("End");
	}

	private static void getJobPriority() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file1));
		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text Longo a vector of Strings
				String[] jobsall = line.split(" ");
				
				// get job weight and length
				Long jobWeight = Long.parseLong(jobsall[0]);
				Long jobLength = Long.parseLong(jobsall[1]);
				Long jobDifference = jobWeight - jobLength;
				double jobRatio = jobWeight/(double)jobLength;
				
				jobInfo jobTmp = new jobInfo();
				jobTmp.weight = jobWeight;
				jobTmp.length = jobLength;
				
				ArrayList<jobInfo> jobinfosD =new ArrayList<>();
				ArrayList<jobInfo> jobinfosR =new ArrayList<>();
				
				if(jobPriorityD.containsKey(jobDifference)) {
					jobinfosD = jobPriorityD.get(jobDifference);
				}
				jobinfosD.add(jobTmp);
				jobPriorityD.put(jobDifference, jobinfosD);
				
				if(jobPriorityR.containsKey(jobRatio)) {
					jobinfosR = jobPriorityR.get(jobRatio);
				}
				jobinfosR.add(jobTmp);
				jobPriorityR.put(jobRatio, jobinfosR);
				
				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
	}

}
