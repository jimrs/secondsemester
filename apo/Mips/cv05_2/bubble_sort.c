int pole[5]={5,3,4,1,2};
int main()
{
	int N = 5,i,j,tmp;
	for(i=0; i<N; i++)
		for(j=0; j<N-1-i; j++)
			if(pole[j+1]<pole[j])
			{
				tmp = pole[j+1];
				pole[j+1] = pole[j];
				pole[j] = tmp;
			}
	return 0;
}
