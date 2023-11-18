package model.company;

import model.person.Accountant;
import model.person.SoftwareDeveloper;


public class Accenture extends CompanyFactory
{
    public Accenture()
    {
        super("Accenture");

    }
    @Override
    protected Job createJob(String jobType)
    {
        if (jobType.equalsIgnoreCase("Accountant"))
        {
            Job defaultAccountantJob = new Job.JobBuilder()
                    .setJobType("Accountant")
                    .build();
            addJob(defaultAccountantJob);

            Job accountantJob = new Accountant().clone();
            System.out.println("You are applying as an " + accountantJob.toString());

            return accountantJob;
        }
        else if (jobType.equals("Software Developer"))
        {
            Job softwareDeveloperJob = new Job.JobBuilder()
                    .setJobType("Software Developer")
                    .build();
            addJob(softwareDeveloperJob);

            Job softwareDevelopmentJob = new SoftwareDeveloper().clone();

            return softwareDeveloperJob;
        }
        else if (jobType.equals("Human Resources Manager"))
        {
            Job humanResourcesManagerJob = new Job.JobBuilder()
                    .setJobType("Human Resources Manager")
                    .build();

            addJob(humanResourcesManagerJob);
            return humanResourcesManagerJob;
        }
        else return null;
    }

    @Override
    public String isHiringJob(String jobType) {
        for (Job job : getJobHiringPositionList()) {
            if (job.getJobType().equalsIgnoreCase(jobType)) {
                return getName();
            }
        }
        return "No Job available at " + getName();
    }

}
