package model.company;


import java.util.*;

public abstract class CompanyFactory
{
    private String name;
    private List<Job> jobHiringPositionList;

    public CompanyFactory(String name)
    {
        this.name = name;
        this.jobHiringPositionList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addJob(Job job)
    {
        jobHiringPositionList.add(job);
    }

    public List<Job> getJobHiringPositionList() {
        return jobHiringPositionList;
    }

    protected abstract Job createJob(String jobType);
    public Job offerJob(String jobType)
    {
        Job job = null;

        job = createJob(jobType);

        return job;
    }


    public abstract void isHiringJob(String jobType);
}
