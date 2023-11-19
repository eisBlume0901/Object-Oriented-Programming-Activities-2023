package model.company;

import model.person.*;

import java.util.List;


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
                    .setResponsibilities("Managing and reporting financial information for " + this.getName())
                    .setRequirements("Accountancy\n Finance Management\n")
                    .setEducationalLevel(EducationalLevel.BACHELOR)
                    .setJobLevel(JobLevel.ENTRY)
                    .build();

            System.out.println(defaultAccountantJob.getResponsibilities());

            Job accountantJob = defaultAccountantJob.clone();
            accountantJob = new Accountant();
            accountantJob.setJobType("Accountant");
            accountantJob.setResponsibilities("Managing and reporting financial information for " + this.getName());
            accountantJob.setRequirements("Accountancy\n Finance Management\n");
            accountantJob.setEducationalLevel(EducationalLevel.BACHELOR);

            System.out.println("You are applying as an " + accountantJob.toString());
            accountantJob.generateSalaryRange(JobLevel.ENTRY);

            addJob(accountantJob);
            return accountantJob;
        }
        if (jobType.equals("Software Developer"))
        {
            Job defaultSoftwareDeveloperJob = new Job.JobBuilder()
                    .setJobType("Software Developer")
                    .setResponsibilities("")
                    .setRequirements("Computer Science \n Computer Engineering \n Information Technology")
                    .setEducationalLevel(EducationalLevel.BACHELOR)
                    .setJobLevel(JobLevel.ENTRY)
                    .build();

            Job softwareDeveloperJob = defaultSoftwareDeveloperJob.clone();
            softwareDeveloperJob = new SoftwareDeveloper();
            softwareDeveloperJob.setJobType("Software Developer");
            softwareDeveloperJob.setEducationalLevel(EducationalLevel.BACHELOR);
            softwareDeveloperJob.setRequirements("Computer Science \n Computer Engineering \n Information Technology");

            return softwareDeveloperJob;
        }
        if (jobType.equals("Human Resources Manager"))
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

        for (Job job : getJobHiringPositionList())
        {
            if (job.toString().equalsIgnoreCase(jobType))
            {
                return this.getName();
            }
        }
        return "No " + jobType + " found in " + this.getName();
    }

}
