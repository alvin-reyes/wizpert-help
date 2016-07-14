
public class ExecutorServiceWp {e


	public void step()
	      {
	          int n = parts.length / THREAD;
	          int mar = parts.length % THREAD; //remainder
	  
	          pB=new Part[parts.length];
	          for(int i=0;i<parts.length;i++) //copies the original array to a buffer; only this gets modified by the threads
	 79         {
	 80             pB[i] = new Part(parts[i].getMap());
	 81         }
	 82 
	 83         List<Runnable> runnables = new ArrayList<>();
	 84         int start=0,end=n+(mar>0?1:0);
	 85         if(mar>0)
	 86             mar--;
	 87         for(int t = 0; t<THREAD && end!=start; t++)
	 88         {
	 89             runnables.add(new Stepper(start,end));
	 90             start=end;
	 91             end=start+n+(mar>0?1:0); //equal amounts go to one thread, except for the remainder which is added to the first ones
	 92             if(mar>0)
	 93                 mar--;
	 94         }
	 95         ExecutorService executor = Executors.newFixedThreadPool(THREAD); //I change this variable, but it runs quickest at 1
	 96         for(Runnable task : runnables)
	 97             executor.submit(task);
	 98         try {Thread.sleep(30); } catch (Exception e) {}
	 99         //executor.shutdown();          //I'm not sure whether this is required or not    
	100         /*Runnable a = new Stepper(0,parts.length);  //I have also tried running the program from the main thread, but it is slower than THREAD=1
	101         a.run();*/
	102         parts = pB; //The buffer is the new original
	103     }
}
