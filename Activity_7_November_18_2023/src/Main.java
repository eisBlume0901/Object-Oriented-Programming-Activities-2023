import controller.JobPreferenceController;
import model.company.Job;
import model.company.JobLevel;
import model.person.*;
import view.UserInterface;

public class Main {
    public static void main(String[] args) {


        JobPreferenceController jobPreferenceController = new JobPreferenceController();
        jobPreferenceController.enterPersonalDetails();
        jobPreferenceController.runJobPreferenceSystem();
        jobPreferenceController.runJobLevelSystem();
        jobPreferenceController.work();


    }
}