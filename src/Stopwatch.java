public class Stopwatch { 

    private long start;

   /**
     * Create a stopwatch object.
     */
    public Stopwatch() {
        start = 0;
    } 


   /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public double stopTimer() {
        long now = System.currentTimeMillis();
        double time = (now - start) / 1000.0;
        start = 0;
        return time;
    }
    
    public void startTime()
    {
    	start = System.currentTimeMillis();
    }
} 
