import java.util.concurrent.*;

public class SumWithSync
{
    private static Sum sum = new Sum();
    public static void main(String[]args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i <= 50; i++)
        {
            executor.execute(new AddOne());
        }

        executor.shutdown();
    }

    private static class AddOne implements Runnable
    {
        public void run()
        {
            synchronized (sum)
            {
                sum.add(1);
            }
        }
    }

    private static class Sum
    {
        private int sum = 0;
        
        public int getSum()
        {
            return sum;
        }

        public synchronized void add(int amt)
        {
            try
            {
                Thread.sleep(5);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }

            sum++;

            System.out.println(sum);
        }
    }
}