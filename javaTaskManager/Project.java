package com.packpoised;

public class Project {
    String projectName;
    String buildingType;
    String projectLocation;
    String projectDueDate;
    String projectNumber;
    String erfNumber;
    String totalFeeCharged;
    String totalPaidToDate;
    String projectStatus;
    Person architect;
    Person contractor;
    Person customer;

    public Project(String projectName, String buildingType, String projectLocation, String projectDueDate,
                   String projectNumber, String erfNumber, String totalFeeCharged, String totalPaidToDate,
                   String projectStatus, Person architect, Person contractor, Person customer) {

        this.projectName = projectName;
        this.buildingType = buildingType;
        this.projectLocation = projectLocation;
        this.projectDueDate = projectDueDate;
        this.projectNumber = projectNumber;
        this.erfNumber = erfNumber;
        this.totalFeeCharged = totalFeeCharged;
        this.totalPaidToDate = totalPaidToDate;
        this.projectStatus = projectStatus;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
    }

    public String getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(String projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public String getTotalPaidToDate() {
        return totalPaidToDate;
    }

    public void setTotalPaidToDate(String totalPaidToDate) {
        this.totalPaidToDate = totalPaidToDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public double projectCalculation(String totalFeeCharged, String totalPaidToDate){
        double totalFee, totalPaid;
        
        if(totalFeeCharged == null || totalFeeCharged.isEmpty()){
            totalFee = 0;
        }else{
            totalFee = Double.parseDouble(totalFeeCharged);
        }

        if(totalPaidToDate == null || totalPaidToDate.isEmpty()){
            totalPaid = 0;
        }else{
            totalPaid = Double.parseDouble((totalPaidToDate));
        }
        return totalFee - totalPaid;

    }
    public String toString() {

    String output = "Project Name: " + projectName;
    output += "\nBuilding Type: " + buildingType;
    output += "\nProject Location: " + projectLocation;
    output += "\nProject Due Date: " + projectDueDate;
    output += "\nProject NUmber: " + projectNumber;
    output += "\nERF Number: " + erfNumber;
    output += "\nTotal Fee Charged: " + totalFeeCharged;
    output += "\nTotal Paid to Date: " + totalPaidToDate;
    output += "\n" + architect;
    output += "\n" + contractor;
    output += "\n" + customer;

    return output;

    }


}





