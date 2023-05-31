package enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}


