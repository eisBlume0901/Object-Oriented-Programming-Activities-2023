package model.company;

import model.person.EducationalLevel;

public class Job implements Cloneable {

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

    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public String getRequirements() {
        return requirements;
    }

    protected Job clone()
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
    public static class JobBuilder
    {
        private String jobType;
        private EducationalLevel educationalLevel;
        private JobLevel jobLevel;
        private String courseName;
        private String responsibilities;
        private String requirements;

        public JobBuilder() {

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
