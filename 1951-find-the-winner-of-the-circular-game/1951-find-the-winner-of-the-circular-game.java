class Solution {
    public  int Josephus(int N, int k) {

    // Initialize variables i and ans with 1 and 0 respectively.
    int i = 1, ans = 0;

    // Run a while loop till i <= N
    while (i <= N) {

      // Update the Value of ans and Increment i by 1
      ans = (ans + k) % i;
      i++;
    }

    // Return required answer
    return ans + 1;
  }
    public int findTheWinner(int n, int k) {
        return Josephus(n,k);
    }
}