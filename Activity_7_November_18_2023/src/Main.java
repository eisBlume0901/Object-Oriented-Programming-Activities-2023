import controller.JobPreferenceController;
public class Main {
    public static void main(String[] args) {


//        JobPreferenceController jobPreferenceController = new JobPreferenceController();
//        jobPreferenceController.enterPersonalDetails();
//        jobPreferenceController.runJobPreferenceSystem();
//        jobPreferenceController.runJobLevelSystem();
//        jobPreferenceController.work();

        JobPreferenceController jobPreferenceController = new JobPreferenceController();
        jobPreferenceController.start();

    }
}