// Homework 1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

//  convert this program to c++
//  change to c++ io
//  change to one line comments
//  change defines of constants to const
//  change array to vector<>
//  inline any short function

#include <iostream> //C++ io
#include <vector> //vector template
using namespace std;
inline void sum(int& p, int n, vector<int>& d) //passing p by reference to be modified, d by reference to be more efficiency since vector won't be modified.
{
	for (int i = 0; i < n; ++i)
		p = p + d[i];  //for loop to add all the elements in the vector together
}
int main()
{
	const int N = 40; //a constant representing summing numbers from zero up to but not including itself
	int accum = 0; //accumulation variable
	vector<int> data(N);
	for (int i = 0; i < N; ++i)
		data[i] = i;  //for loop to insert 0 to 39 in a vector
	sum(accum, N, data);
	cout << "sum is " << accum << endl; //print output
	return 0;
}

//This is the original C program
///*  Convert this program to C++
//*   change to C++ io
//*   change to one line comments
//*   change defines of constants to const
//*   change array to vector<>
//*   inline any short function
//*/
//
//#include <stdio.h>
//#define N 40
//void sum(int*p, int n, int d[])
//{
//	int i;
//	*p = 0;
//	for (i = 0; i < n; ++i)
//		*p = *p + d[i];
//}
//int main()
//{
//	int i;
//	int accum = 0;
//	int data[N];
//	for (i = 0; i < N; ++i)
//
//		data[i] = i;
//
//	sum(&accum, N, data);
//	printf("sum is %d\n", accum);
//	return 0;
//}