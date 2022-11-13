package leedcode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedulep207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++)
            courses.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++)
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] track=new int[numCourses];
        System.out.println(track);
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(courses,i,track)==false)return false;
        }
        return true;
    }
    public static boolean dfs(List<List<Integer>> courses,int start,int[] track)
    {
        if(track[start]==2) return true; // point is already clear
        if(track[start]==1) return false; // loop!
            track[start]=1; //start exploring!
        for(int j=0;j<courses.get(start).size();j++)
        {
            if(dfs(courses,courses.get(start).get(j),track)==false)return false;
        }
        track[start]=2; //point clear!
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int numCourses = 2;
//    	List<Integer> precourse = Arrays.asList(1,0);
//    	List<Integer> precourse2 = Arrays.asList(0,1);
    	int[][] myarray = new int[2][2];
        myarray[0][0] = 1;
        myarray[0][1] =  myarray[1][0] =  0;
        myarray[1][1] = 1;
    	System.out.println(canFinish(numCourses,myarray));
	}

}
