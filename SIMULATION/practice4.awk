BEGIN{
	count=0;
	pack=0;
	time=0;
}
{
	if($1=="r" && $3=="_2_" && $4=="AGT"){
		count++;
		pack=pack+$8;
		time=$2;
	}
}
END{
	printf("throughput from n0 to n3 is %f\n",((count*pack*8))/(time*1000000));
}
