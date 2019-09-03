// Matrix.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <ctime>

using namespace std;
void main()
{

	float density = 40;	
	int vertices = 10;
	int count = 0;
	int numElements = vertices*(vertices - 1) / 2;
	srand(clock());
	vector<vector<int>> matrix(vertices, vector<int>(vertices));

	for (int i = 0; i< vertices; i++)
	{
		for (int j = 0; j< vertices; j++)
		{
			float r = (rand()%100);

			if (r <= density)
			{
				matrix[i][j] = 1;

			}
			else
			{
				matrix[i][j] = 0;
			}
			cout << matrix[i][j];
			cout << "value of i :" << i << " Value of j :" << j << endl;

		}
	}
	cout << "done" << endl;
	for (int i = 0; i < vertices; i++)
	{
		for (int j = 0; j < vertices; j++)
		{
			if (matrix[i][j] = 0)
			{
				count++;
			};
		}
	}
	cout << count  << endl;
	cout << numElements << endl;
	cout << (float)count/numElements << endl;

}

