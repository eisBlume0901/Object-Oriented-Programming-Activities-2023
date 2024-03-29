package model.company;

import model.person.EducationalLevel;

public class Job implements Cloneable, SalaryGenerator {

    private String jobType;
    private EducationalLevel educationalLevel;

    private JobLevel jobLevel;

    private String courseName;
    private String responsibilities;
    private String requirements;

    public Job()
    {

    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Job clone()
    {
        try
        {
            return (Job) super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException)
        {
            cloneNotSupportedException.printStackTrace();
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public void generateSalaryRange(JobLevel jobLevel) {

        System.out.println("No salary for default job");
    }

    public static class JobBuilder
    {
        private String jobType;
        private EducationalLevel educationalLevel;
        private JobLevel jobLevel;
        private String courseName;
        private String responsibilities;
        private String requirements;

        public JobBuilder() {
            /*
            Purpose of Builder Design Pattern:
            To allow construction of objects step by step.

            Job job1 = new Job.JobBuilder().setJobType("Accountant").build();

             */
        }

        public JobBuilder setJobType(String jobType)
        {
            this.jobType = jobType;
            return this;
        }

        public JobBuilder setEducationalLevel(EducationalLevel educationalLevel)
        {
            this.educationalLevel = educationalLevel;
            return this;
        }

        public JobBuilder setJobLevel(JobLevel jobLevel)
        {
            this.jobLevel = jobLevel;
            return this;
        }

        public JobBuilder setCourseName(String courseName)
        {
            this.courseName = courseName;
            return this;
        }

        public JobBuilder setResponsibilities(String responsibilities)
        {
            this.responsibilities = responsibilities;
            return this;
        }

        public JobBuilder setRequirements(String requirements)
        {
            this.requirements = requirements;
            return this;
        }

        public Job build()
        {
            Job job = new Job();
            job.jobType = this.jobType;
            job.educationalLevel = this.educationalLevel;
            job.jobLevel = this.jobLevel;
            job.courseName = this.courseName;
            job.responsibilities = this.responsibilities;
            job.requirements = this.requirements;
            return job;
        }
    }
}
