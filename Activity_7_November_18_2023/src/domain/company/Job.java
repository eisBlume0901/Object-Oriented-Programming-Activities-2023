package domain.company;

import domain.person.EducationalLevel;

public class Job {

    private String jobType;
    private EducationalLevel educationalLevel;

    private JobLevel jobLevel;

    private String courseName;
    private String responsibilities;
    private String requirements;

    public Job()
    {

    }


    public static class JobBuilder
    {
        private String jobType;
        private EducationalLevel educationalLevel;
        private JobLevel jobLevel;
        private String courseName;
        private String responsibilities;
        private String requirements;

        public JobBuilder(){

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
