package hospital.controller;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

import hospital.dao.*;
import hospital.dto.*;


public class HospitalPerosnMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=======welcome======");
		Person person = new Person();
		Encounter encounter = new Encounter();
		PersonDetail detail=new PersonDetail();
		Branchdao daob = new Branchdao();
		Hospitaldao daoh = new Hospitaldao();
		MedOrder medorder = new MedOrder();
		PersonSave save=new PersonSave();
		MedItems medItems=new MedItems(); 
		
		Branchdao dao1=new Branchdao();

		boolean check = true;
		do {
			System.out.println("Enter ur choice  \n 1.Hospital app \n 2.Person App \n 3.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				
				boolean repeat=true;
				Hospital hospital=new Hospital();
				Branch branch=new Branch();
				Address address=new Address();
				Hospitaldao dao=new Hospitaldao();
				
				Addressdao dao2=new Addressdao();
				do{
					System.out.println("do u want to register the hospital??");
					System.out.println("1:Register hospital\n2:Existing hospital\n3:Exit");
					System.out.println("enter your choice");
					int choice3=scanner.nextInt();
					switch(choice3){
					case 1:{
						System.out.println("enter the hospitalId");
						int hid=scanner.nextInt();
						System.out.println("enter the hospital name");
						String hname=scanner.next();
						System.out.println("enter the ceo name");
						String hceo=scanner.next();
						hospital.setH_id(hid);
						hospital.setH_name(hname);
						hospital.setH_ceo(hceo);
						dao.saveHospital(hospital);
						System.out.println("hospital registered successfully");
						System.out.println("**************");
						boolean innerexit=true;
						do{
							System.out.println("do u wanna add branch for hospital");
							System.out.println("press 1 :for adding branch");
							System.out.println("press 2 :to display existing branch");
							System.out.println("press 3 :to exit");
							System.out.println("please enter your choice");
							int choice1=scanner.nextInt();
							switch(choice1){
							case 1:{
								System.out.println("enter the branch id");
								int bid=scanner.nextInt();
								System.out.println("enter the branch location");
								String blocation=scanner.next();
								System.out.println("enter the branch manager");
								String bmanager=scanner.next();
								branch.setB_id(bid);
								branch.setB_location(blocation);
								branch.setB_manager(bmanager);
								List<Branch> list=new ArrayList<Branch>();
								list.add(branch);
								
								dao1.saveBranch(list, hid);	
								System.out.println("branch added successfully");
								System.out.println("************");
								System.out.println(" click 1 to add address");
							
								
								int choice2=scanner.nextInt();
								switch(choice2){
								case 1:{
									System.out.println("enter the address");
									System.out.println("enter the building no");
									int buildingno=scanner.nextInt();
									System.out.println("enter the street");
									String street=scanner.next();
									System.out.println("enter the district");
									String district=scanner.next();
									System.out.println("enter the state");
									String state=scanner.next();
									System.out.println("enter the pincode");
									long pincode=scanner.nextLong();
									address.setBuilding_no(buildingno);
									address.setStreet(street);
									address.setDistrict(district);
									address.setState(state);
									address.setPincode(pincode);
									branch.setAddress(address);
									dao2.saveAddress(address, branch.getB_id());
								}
								break;
								
								}
								break;
							}
							case 2:{
								List<Branch>list=dao1.getBranch();
								System.out.println(list);
								System.out.println("displayed existing branch");
							}
							break;
							case 3:innerexit=false;
								
							
							
							}
						}while(innerexit);
						}
						case 2:{
								List<Branch>list1=dao.getHospital();
								System.out.println(list1);
								System.out.println("displayed existing hospital");
								
								
								
								
								
							}
							break;
							case 3:{
								repeat=false;
							}	
					}
				}while(repeat);
                System.out.println("=======thank you=========");
			}break; //case1 
				

			case 2: {

				boolean exit = true;
				do {
					System.out.println("Choose your option \n 1.New Person \n 2.Existing person \n 3.Exit");
					int num = scanner.nextInt();
					switch (num) {
					case 1: {
						System.out.println("enter person id");
						int person_id = scanner.nextInt();
						System.out.println("Enter Person name");
						String person_name = scanner.next();
						System.out.println("Enter Person Phone");
						long person_phone = scanner.nextLong();
						System.out.println("Enter Person address");
						String person_address = scanner.next();
						person.setPerson_id(person_id);
						person.setPerson_name(person_name);
						person.setPerson_phone(person_phone);
						person.setPerson_address(person_address);
						
						save.savePerson(person);

						System.out.println("pls provide your details to admit hospaital");
						
						System.out.println("Enter admission id");
						int encounter_id = scanner.nextInt();
						System.out.println("Enter the date ");
						String encounter_date = scanner.next();
						System.out.println("enter your health issue");
						String encounter_disease = scanner.next();

						encounter.setEncounter_a_id(encounter_id);
						encounter.setEnounter_date(encounter_date);
						encounter.setEncounter_disease(encounter_disease);

						System.out.println("these are the  hospitals branches  available  ");

					    System.out.println(	dao1.getBranch());
						System.out.println("pls choose your wish to admit in the branch");
						int branchid = scanner.nextInt(); 
                        
						save.saveEnounter(person_id,encounter, branchid);
				
					
						
						
						
                       
						System.out.println("your can go to ur checkup room --->----->--->");
						System.out.println("Enter Medorder id");
						int  medOrder_id = scanner.nextInt();
						System.out.println("Enter name");
						String medOrder_name = scanner.next();
						System.out.println("Enter Age");
						Integer medOrder_age = scanner.nextInt();
						System.out.println("Enter Date");
						String medOrder_date = scanner.next();
						medorder.setMedorder_id(medOrder_id);
						medorder.setMedorder_name(medOrder_name);
						medorder.setMedorder_age(medOrder_age);
						medorder.setMedorder_date(medOrder_date);
						
						
						save.saveMedOrder(medorder,encounter_id);
						
						
						
						boolean innerexit=true;
						System.out.println("Enter the med items");
						
						do {
							System.out.println("Enter your choice  \n 1.Add medicine \n 2.Exit ");
							
							int num3=scanner.nextInt();
							switch (num3) {
							case 1:
							{
								System.out.println("enter meditems id");
								int meditems_id=scanner.nextInt();
								System.out.println("enter medicine name");
								String meditems_medcine=scanner.next();
								System.out.println("Enter no.of Pills");
								int meditems_pills=scanner.nextInt();
								System.out.println("enter The price");
								double medItems_price =scanner.nextDouble();
								
								medItems.setMeditems_id(meditems_id);
								medItems.setMeditems_name(meditems_medcine);
								medItems.setMeditems_pills(meditems_pills);
								medItems.setMeditems_cost(medItems_price);
								
								save.saveMedItems(medItems, medOrder_id);
							}
							break;
							case 2:
								innerexit=false;
								
								
								
								
								
								
								
							}	
							}while(innerexit);

							
						
						
						
					
						

					}break;
					case 2:
					{
						
						System.out.println("pls provide your id");
						int id=scanner.nextInt();
						
						boolean innercheck=true;
						do {
							System.out.println("choose your options \n 1.your previous admit details details"
									+ " \n 2.New admit  \n  3.Exit");
							int num1=scanner.nextInt();
							switch (num1) {
							case 1:{
								detail.getEncounterDetails(id);
								
							}break;
							case 2:
							{
								System.out.println("pls provide your details to admit hospaital");
								
								System.out.println("Enter admission id");
								int encounter_id = scanner.nextInt();
								System.out.println("Enter the date ");
								String encounter_date = scanner.next();
								System.out.println("enter your health issue");
								String encounter_disease = scanner.next();

								encounter.setEncounter_a_id(encounter_id);
								encounter.setEnounter_date(encounter_date);
								encounter.setEncounter_disease(encounter_disease);

								System.out.println("these are the  hospitals branches  available  ");

								 System.out.println(	dao1.getBranch());
								
								System.out.println("pls choose your wish to admit in the branch");
								int branchid = scanner.nextInt(); 
								
								
		                        
								save.saveEnounter(id,encounter, branchid);
								
								
								System.out.println("your can go to ur checkup room--->----->----> ");
								System.out.println("Enter Medorder id");
								int  medOrder_id = scanner.nextInt();
								System.out.println("Enter name");
								String medOrder_name = scanner.next();
								System.out.println("Enter Age");
								Integer medOrder_age = scanner.nextInt();
								System.out.println("Enter Date");
								String medOrder_date = scanner.next();
								medorder.setMedorder_id(medOrder_id);
								medorder.setMedorder_name(medOrder_name);
								medorder.setMedorder_age(medOrder_age);
								medorder.setMedorder_date(medOrder_date);
								
								
								save.saveMedOrder(medorder,encounter_id);
								
								
								
								boolean innerexit=true;
								System.out.println("Enter the med items");
								
								do {
									System.out.println("Enter your choice  \n 1.Add medicine \n 2.Exit ");
									
									int num3=scanner.nextInt();
									switch (num3) {
									case 1:
									{
										System.out.println("enter meditems id");
										int meditems_id=scanner.nextInt();
										System.out.println("enter medicine name");
										String meditems_medcine=scanner.next();
										System.out.println("Enter no.of Pills");
										int meditems_pills=scanner.nextInt();
										System.out.println("enter The price");
										double medItems_price =scanner.nextDouble();
										
										medItems.setMeditems_id(meditems_id);
										medItems.setMeditems_name(meditems_medcine);
										medItems.setMeditems_pills(meditems_pills);
										medItems.setMeditems_cost(medItems_price);
										save.saveMedItems(medItems,medOrder_id );
									}
									break;
									case 2:
										innerexit=false;
										
										
										
										
										
										
										
									}	
									}while(innerexit);

									
								
							   
								
							

								
								
								
								
							}break;
							case 3:
								innercheck=false;
								
								
							}
							
							
						}while(innercheck);
						
						
					}break;//existing
					case 3:
					{
						exit=false;
					}
						

					}

				} while (exit);
				System.out.println("=======thank you====");

			}break;/// peerson details
				
			case 3: {
				check = false;
			}

			}
			

		} while (check);
    System.out.println("========thanks for using app=========");
	}

}
