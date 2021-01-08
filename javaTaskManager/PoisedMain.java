package com.packpoised;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PoisedMain {

    public static void main(String[] args) {
        // the boolean variable called login will be used to instantiate the while loop
        // the ArrayList called projectArray will be used to hold information captured
        boolean login = true;
        ArrayList<Project> projectArray = new ArrayList<>(1);

        while (login) {
            // once the while loop is "active" the user will see a menu to choose from.
            System.out.println("WELCOME TO POISED PROJECT MANAGEMENT SYSTEM");
            System.out.println("Please enter your selection from the list below\n" +
                    "N " + " to create New Project\n" +
                    "E " + "to Exit the program\n" +
                    "U " + "to update or to finalise a project");

            Scanner userSelect1 = new Scanner(System.in);
            String userSelection = userSelect1.nextLine();
            if (userSelection.equalsIgnoreCase("N")) {
                // creating a new project
                System.out.print("Enter the Project Name: ");
                Scanner scanner = new Scanner(System.in);
                String projectName = scanner.nextLine();

                System.out.print("Enter the Building project type: ");
                String buildingType = scanner.nextLine();

                System.out.print("Enter the address of the project: ");
                String projectLocation = scanner.nextLine();

                System.out.print("Enter the due date for this project (eg.yyyy-mm-dd): ");
                String projectDueDate = scanner.nextLine();

                System.out.print("Enter the Project Number: ");
                String projectNumber = scanner.nextLine();

                System.out.print("Enter the ERF number for this project: ");
                String erfNumber = scanner.nextLine();

                System.out.print("Enter the Total Fee Charged for this project: ");
                String totalFeeCharged = scanner.nextLine();

                System.out.print("Enter the Total Paid to date: ");
                String totalPaidToDate = scanner.nextLine();

                //creating a Architect for the project
                System.out.println("Enter Architect details below");

                Scanner userSelect2 = new Scanner(System.in);

                String personTitle = "Architect";

                System.out.print("Enter Architect name:  ");
                String personName = userSelect2.nextLine();

                System.out.print("Enter Architect surname: ");
                String personSurname = userSelect2.nextLine();


                System.out.print("Enter Architect email address: ");
                String personEmail = userSelect2.nextLine();

                System.out.print("Enter Architect physical address: ");
                String personPhysicalAddress = userSelect2.nextLine();

                System.out.print("Enter Architect phone number: ");
                String personPhoneNumber = userSelect2.nextLine();

                Person person1 = new Person(personTitle, personName, personSurname, personEmail, personPhysicalAddress, personPhoneNumber);
                System.out.println("Architect has been successfully assigned");
                System.out.println(person1);
                System.out.println();

                //creating a Contractor for the project
                System.out.println("Enter Contractor details below");

                personTitle = "Contractor";

                System.out.print("Enter Contractor name: ");
                personName = userSelect2.nextLine();

                System.out.print("Enter Contractor surname: ");
                personSurname = userSelect2.nextLine();

                System.out.print("Enter Contractor email address: ");
                personEmail = userSelect2.nextLine();

                System.out.print("Enter Contractor physical address: ");
                personPhysicalAddress = userSelect2.nextLine();

                System.out.print("Enter Contractor phone number: ");
                personPhoneNumber = userSelect2.nextLine();

                Person person2 = new Person(personTitle, personName, personSurname, personEmail, personPhysicalAddress, personPhoneNumber);
                System.out.println("Contractor has been successfully assigned");
                System.out.println(person2);
                System.out.println();

                //creating a Customer for the project
                System.out.println("Enter Customer details below ");

                personTitle = "Customer";

                System.out.print("Enter Customer name: ");
                personName = userSelect2.nextLine();

                System.out.print("Enter Customer surname: ");
                personSurname = userSelect2.nextLine();

                System.out.print("Enter Customer email address: ");
                personEmail = userSelect2.nextLine();

                System.out.print("Enter Customer physical address: ");
                personPhysicalAddress = userSelect2.nextLine();

                System.out.print("Enter Customer phone number: ");
                personPhoneNumber = userSelect2.nextLine();

                Person person3 = new Person(personTitle, personName, personSurname, personEmail, personPhysicalAddress, personPhoneNumber);
                System.out.println("Customer has been successfully assigned");
                System.out.println(person3);
                System.out.println();
                // if project name is blank, we append the customer surname to projectName.
                if(projectName.isBlank()){
                    projectName = personSurname + " " + buildingType;
                }

                Project project1 = new Project(projectName, buildingType, projectLocation, projectDueDate, projectNumber,
                        erfNumber, totalFeeCharged, totalPaidToDate, "inProgress", person1, person2, person3);
                System.out.println(project1);
                projectArray.add(project1);
            }

            if (userSelection.equalsIgnoreCase("U")) {

                System.out.print("Enter the Project Number for the project you'd like to update:");
                Scanner scanner = new Scanner(System.in);
                String projectNumber = scanner.nextLine();
                StringBuffer sb = new StringBuffer(projectNumber);
                // we have to iterate over our array and compare projectNumbers with input
                for (Project proj : projectArray) {
                    // loop through our current list of projects
                    if (proj.projectNumber.contentEquals(sb)) {
                        System.out.println(proj);
                        System.out.println();
                    // presenting update options
                        System.out.println("would you like to change the project due date Enter (enter Y or hit Enter to continue) ? ");
                        String responseToUpdate = scanner.nextLine();

                        if(responseToUpdate.equalsIgnoreCase("Y")) {
                            System.out.println(proj.getProjectDueDate());
                            System.out.println("Enter a new date : ");
                            responseToUpdate = scanner.nextLine();
                            proj.setProjectDueDate(responseToUpdate);
                        }

                        System.out.println("would you like to update amount of fees paid to date Enter (enter Y or hit Enter to continue) ? ");
                            responseToUpdate = scanner.nextLine();
                        if(responseToUpdate.equalsIgnoreCase("Y")) {
                            System.out.println(proj.getTotalPaidToDate());
                            System.out.println("Enter new amount : ");
                            responseToUpdate = scanner.nextLine();
                            proj.setTotalPaidToDate(responseToUpdate);
                        }

                        System.out.println("would you like to update contractor details Enter (enter Y or hit Enter to continue) ? ");
                            responseToUpdate = scanner.nextLine();
                            if(responseToUpdate.equalsIgnoreCase("Y")) {
                                System.out.println(proj.contractor.getPersonPhoneNumber());
                                System.out.println();
                                System.out.println("Enter new contact details : ");
                                responseToUpdate = scanner.nextLine();
                                proj.contractor.setPersonPhoneNumber(responseToUpdate);
                            }
                            // here we allow the user to finalise the project and change the status of the project
                        System.out.println("would you like to Finalise this project ? (enter Y or hit Enter to continue) ? ");
                        responseToUpdate = scanner.nextLine();
                        if(responseToUpdate.equalsIgnoreCase("Y")) {
                            System.out.println(proj.getProjectStatus());
                            // we generate an Invoice for the project
                            double answer = proj.projectCalculation(proj.totalFeeCharged, proj.totalPaidToDate);
                            if(answer != 0){
                                DecimalFormat df = new DecimalFormat("#.##");
                                answer = Double.parseDouble(df.format(answer));
                                System.out.println("Invoice for " + proj.customer.personName + " " + proj.customer.personSurname);
                                System.out.println("Customer Contact(s): " + proj.customer.getPersonPhoneNumber());
                                System.out.println("Project Name "+ proj.projectName);
                                System.out.println("Amount customer must still pay: R" + answer);
                            }
                            proj.setProjectStatus("Finalized");

                            // here is where we will write to file
                        }
                            System.out.println(projectArray);
                    }
                }
            }
            if(userSelection.equalsIgnoreCase("F")){
                System.out.println(projectArray);
            }
            if (userSelection.equalsIgnoreCase("E")) {
                login = false;
            }
        }

    }
}


//                    File file = new File("append.txt");
//                    FileWriter newInfoCheck = new FileWriter(file, true);
//                    BufferedWriter newInfoInsert = new BufferWriter(newInfoCheck);
//                    newInfoInsert.write("something for file");
//                    newInfoCheck.close();
//                    newInfoInsert.close();


