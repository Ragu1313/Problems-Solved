/*
The Hero Test -1
Problem statement
Ninja wants the hero certificate to get the support of local police and government to help the people. But to get the hero certificate he needs to clear an exam.

The exam consists of ‘N’ questions from ‘1’ to ‘N’. To clear the exam Ninja needs to solve in a particular order. He needs to leave one question after solving one question(assume that after ‘N’th question he will come back to the first question). He will perform this action till all questions are solved. Help Ninja in exams by telling him the order.

For Example:
If there are ‘5’ questions then the order will be:
“ 2 4 1 5 3 ”
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 5
1 <= N <= 3000

Where ‘T’ is the number of test cases, ‘N’ is the number of questions.

Time limit: 1 second.
Sample Input 1:
2
6
4      
Sample Output 1:
2 4 6 3 1 5
2 4 3 1
Explanation of Sample Output 1:
Test Case 1:  
There are 6 questions and the order is [2, 4, 6, 3, 1, 5]. Ninja will start solving the questions as shown in the image below:

Test Case 2:
There are 6 questions and the order is [2, 4, 3, 1]. Ninja will start solving the questions as shown in image below: 

Sample Input 2:
2
10 
7
Sample Output 2:
2 4 6 8 10 3 7 1 9 5 
2 4 6 1 5 3 7 
*/

public class Solution {
	public static ArrayList<Integer> theOrder(int n) {
		// Write your code here.
		// int arr[] = new int[n];
		int flag[] = new int [n+1];
		// for(int i=0;i<n;i++)
		// 	arr[i] = i+1;
		ArrayList<Integer> res = new ArrayList<>();
		int count = 0;
		int c = 0;
		while(count<n-1){
			for(int i=0;i<n;i++){
				// if()
				if(flag[i+1]==0){
					c++;
					if(c==2){
						flag[i+1] = 1;
						res.add(i+1);
						c = 0;
						count++;
					}	
				}
			}
		}
		for(int i=1;i<=n;i++){
			if(flag[i]==0){
				res.add(i);
				break;
			}		
		}
		return res;
	}
}
