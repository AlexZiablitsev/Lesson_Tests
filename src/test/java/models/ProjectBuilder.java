package models;

import enums.ProjectType;

public class ProjectBuilder {

    private String name;
    private String newName;
    private String Announcement;
    private boolean isShowAnnouncement;
    private ProjectType projectType;

    public static class Builder {
        private ProjectBuilder projectBuilder;


        public Builder(ProjectBuilder projectBuilder) {
            this.projectBuilder = projectBuilder;
        }

        public Builder() {

        }

        public ProjectBuilder build() {
            return projectBuilder;
        }

        public Builder withName(String name){
            projectBuilder.name = name;
            return this;
        }
        public Builder withAnnouncement(String announcement){
            projectBuilder.Announcement = announcement;
            return this;
        }public Builder withisShowAnnouncement(boolean isShowAnnouncement){
            projectBuilder.isShowAnnouncement = isShowAnnouncement;
            return this;
        }

        public Builder withProjectType(ProjectType projectType) {
            projectBuilder.projectType = projectType;
            return this;
        }
    }
}
