package com.api.scheduleone;

import java.util.Date;

public class JobOne extends Thread {
	
	Thread Jobone = new Thread()
	{
		public void run()
		{
			for(int i=0;i<10;i++)
			{
				System.out.println("jobone" +new Date());
			}
		}
		
	};
	

	

}
