package domain.company;

public abstract class CompanyFactory
{
    protected abstract Job createJob(String jobType);
    public Job offerJob(String jobType)
    {
        Job job = null;

        job = createJob(jobType);

        return job;
    }

}
