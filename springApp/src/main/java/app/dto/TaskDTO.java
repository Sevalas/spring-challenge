package app.dto;

import java.io.Serializable;
import java.util.UUID;

public class TaskDTO implements Serializable {

    private String id;
    private String reporterName;
    private String assigneeName;
    private String creationDate;
    private String updateDate;
    private String title;
    private String description;
    private String status;

    public TaskDTO() {
        this.id =  UUID.randomUUID().toString();
    }

    public TaskDTO(String id, String reporterName, String assigneeName, String creationDate, String updateDate, String title, String description, String status) {
        this.id = id != null ? id : UUID.randomUUID().toString();
        this.reporterName = reporterName;
        this.assigneeName = assigneeName;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String setId(String id) {
        return id != null ? id : UUID.randomUUID().toString();
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id='" + id + '\'' +
                ", reporterName='" + reporterName + '\'' +
                ", assigneeName='" + assigneeName + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
