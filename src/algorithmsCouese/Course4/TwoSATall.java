package algorithmsCouese.Course4;

import java.io.File;
import java.io.IOException;

public class TwoSATall {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int ans = 0;
		
//		File file = new File("src/algorithmsCouese/Course4/2sat1.txt");
		File file = new File("src/algorithmsCouese/Course4/input_beaunus_1_2.txt");
		ans = twosat.main(file);
		System.out.println(ans);
//		file = new File("src/algorithmsCouese/Course4/2sat2.txt");
		file = new File("src/algorithmsCouese/Course4/input_beaunus_10_20.txt");
		ans = twosat.main(file);
		System.out.println(ans);
//		file = new File("src/algorithmsCouese/Course4/2sat3.txt");
		file = new File("src/algorithmsCouese/Course4/input_beaunus_11_40.txt");
		ans = twosat.main(file);
		System.out.println(ans);
//		file = new File("src/algorithmsCouese/Course4/2sat4.txt");
		file = new File("src/algorithmsCouese/Course4/input_beaunus_12_40.txt");
		ans = twosat.main(file);
		System.out.println(ans);
//		file = new File("src/algorithmsCouese/Course4/2sat5.txt");
		file = new File("src/algorithmsCouese/Course4/input_beaunus_13_80.txt");
		ans = twosat.main(file);
		System.out.println(ans);
//		file = new File("src/algorithmsCouese/Course4/2sat6.txt");
		file = new File("src/algorithmsCouese/Course4/input_beaunus_15_100.txt");
		ans = twosat.main(file);
		System.out.println(ans);
	}

}
