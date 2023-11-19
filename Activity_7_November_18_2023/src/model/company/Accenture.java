package model.company;

import model.person.*;

public class Accenture extends CompanyFactory
{
    public Accenture()
    {
        super("Accenture");
    }
    @Override
    protected Job createJob(String jobType) {
        if (jobType.equalsIgnoreCase("Accountant")) {
            Job defaultAccountantJob = new Job.JobBuilder()
                    .setJobType("Accountant")
                    .setResponsibilities("Managing and reporting financial information for " + this.getName())
                    .setRequirements("Accountancy\n Finance Management\n")
                    .setEducationalLevel(EducationalLevel.BACHELOR)
                    .setJobLevel(JobLevel.ENTRY)
                    .build();

            Job accountantJob = defaultAccountantJob.clone();
            accountantJob = new Accountant();
            accountantJob.setJobType("Accountant");
            accountantJob.setResponsibilities("Managing and reporting financial information for " + this.getName());
            accountantJob.setRequirements("Accountancy\n Finance Management\n");
            accountantJob.setEducationalLevel(EducationalLevel.BACHELOR);
            addJob(accountantJob);
            return accountantJob;
        }
        if (jobType.equals("Software Developer")) {
            Job defaultSoftwareDeveloperJob = new Job.JobBuilder()
                    .setJobType("Software Developer")
                    .setResponsibilities("Responsibilities: Designing algorithms and flowcharts, producing clean, efficient code based on specifications, integrating software components and third-party programs, verifying and deploying programs and systems, troubleshooting, debugging and upgrading existing software, gathering and evaluating user feedback.")
                    .setRequirements("Computer Science \n Computer Engineering \n Information Technology")
                    .setEducationalLevel(EducationalLevel.BACHELOR)
                    .setJobLevel(JobLevel.ENTRY)
                    .build();

            Job softwareDeveloperJob = defaultSoftwareDeveloperJob.clone();
            softwareDeveloperJob = new SoftwareDeveloper();
            softwareDeveloperJob.setJobType("Software Developer");
            softwareDeveloperJob.setEducationalLevel(EducationalLevel.BACHELOR);
            softwareDeveloperJob.setRequirements("Computer Science \n Computer Engineering \n Information Technology");

            
            addJob(softwareDeveloperJob);


            return softwareDeveloperJob;
        }

        if (jobType.equals("Human Resources Manager")) {
            Job defaultHumanResourcesManagerJob = new Job.JobBuilder()

                    .setJobType("Human Resources Manager")
                    .setResponsibilities("Managing employment and new recruits for" + this.getName())
                    .setRequirements("Psychology")
                    .setEducationalLevel(EducationalLevel.BACHELOR)
                    .setJobLevel(JobLevel.MID)
                    .build();

            Job humanResourcesManagerJob = defaultHumanResourcesManagerJob.clone();
            humanResourcesManagerJob = new HumanResourcesManager();
            humanResourcesManagerJob.setJobType("Human Resources Manager");
            humanResourcesManagerJob.setResponsibilities("Managing employment and new recruits for" + this.getName());
            humanResourcesManagerJob.setRequirements("Psychology");
            humanResourcesManagerJob.setEducationalLevel(EducationalLevel.BACHELOR);

            addJob(humanResourcesManagerJob);
            return humanResourcesManagerJob;
        } else return null;
    }

    @Override
    public void isHiringJob(String jobType) {
        for (Job job : getJobHiringPositionList())
        {
            if (job.toString().equalsIgnoreCase(jobType))
            {
                System.out.println(this.getName());
            }
        }
    }
}
