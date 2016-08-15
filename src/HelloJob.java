import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("hello world begin!");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello world end!");
		
	}
}
