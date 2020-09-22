#include<iostream>
#include<cstring>
#include<cstdlib>
using namespace std;

// This function Returns length of longest common sequence for A[], B[]
void commonsequence( char *A, char *B, int m, int n )
{
   int L[m+1][n+1];


   for (int i=0; i<=m; i++)
   {
     for (int j=0; j<=n; j++)
     {
       if (i == 0 || j == 0)
         L[i][j] = 0;
       else if (A[i-1] == B[j-1])
         L[i][j] = L[i-1][j-1] + 1;
       else
         L[i][j] = max(L[i-1][j], L[i][j-1]);
     }
   }


   int index = L[m][n];

   // Create a character array to store the longest common sequence string
   char commonsequence[index+1];
   commonsequence[index] = ' '; // Set the terminating character

   // Start from the right-most-bottom-most corner and
   // one by one store characters in commonsequence[]
   int i = m, j = n;
   while (i > 0 && j > 0)
   {
      // If current character array are same

      if (A[i-1] == B[j-1])
      {
          commonsequence[index-1] = A[i-1]; // Put current character in result
          i--; j--; index--;     // reduce values of i, j and index
      }

      // If not same, then find the larger of two and
      // go in the direction of larger value
      else if (L[i-1][j] > L[i][j-1])
         i--;
      else
         j--;
   }

   // Print the longest common sequence
   cout << "Longest Common Sequence of " << A << " and " << B << " is " << commonsequence;
}

// Driver program to test above function
int main()
{
  char A[100]; //enter an maximum array of 100
  char B[100];
  cout << "Enter two sequence" << endl;
  cin >> A >> B;
  int m = strlen(A);
  int n = strlen(B);
  commonsequence(A, B, m, n);
  return 0;
}
