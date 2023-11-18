package domain.company;

import java.util.*;

public class SyCipGorresVelayoAndCo extends CompanyFactory
{
    private List<String> jobHiringList;

    public SyCipGorresVelayoAndCo()
    {
        this.jobHiringList = new ArrayList<>();
    }
    @Override
    protected Job createJob(String jobType)
    {
        if (jobType.equalsIgnoreCase("Accountant"))
        {
            Job accountantJob = new Job.JobBuilder()
                    .setJobType("Accountant")
                    .build();
            jobHiringList.add(accountantJob.toString());
            return accountantJob;
        }
        else if (jobType.equals("Software Developer"))
        {
            Job softwareDeveloperJob = new Job.JobBuilder()
                    .setJobType("Software Developer")
                    .build();
            jobHiringList.add(softwareDeveloperJob.toString());
            return softwareDeveloperJob;
        }
        else return null;
    }

    public void displayJobHiringPositions()
    {
        for (String jobPositions : jobHiringList)
            System.out.println(jobPositions);
    }

    @Override
    public String toString() {
        return "SGV & Co.";
    }
}
