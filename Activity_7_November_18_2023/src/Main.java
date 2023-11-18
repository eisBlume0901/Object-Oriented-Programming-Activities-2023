import controller.JobPreferenceController;
import model.company.Job;
import model.company.JobLevel;
import model.person.*;

public class Main {
    public static void main(String[] args) {


        JobPreferenceController jobPreferenceController = new JobPreferenceController();
        jobPreferenceController.runJobPreferenceSystem();
        jobPreferenceController.runJobLevelSystem();
//        jobPreferenceController.runJobLevelSystem();




    }
}