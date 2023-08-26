import java.util.*;


class Security
{
	String name,dtime,ctime;
 	int fno;
 	Scanner sc=new Scanner(System.in);
 	void getdata()
 	{ 	
 		System.out.println("Enter the Flat number to visit: \n");
 		fno=sc.nextInt();
 		sc.nextLine();
 		
 		System.out.println("Enter the date and time of visit:\n");
  		dtime=sc.nextLine();
  		sc.nextLine();
  		System.out.println("Enter the date and time of check out:\n");
  		ctime=sc.nextLine();
  		sc.nextLine();
 	
 		System.out.println("Enter the Name:\n");
 		name=sc.nextLine();
 		System.out.println("\n");
 	
  		
  	}
  	
  		
  		
 	
 	void putdata()
 	{
 		System.out.println("Flat num : "+fno);
 		System.out.println("Person who visited : "+name);
 		System.out.println("Check in Date and time: "+dtime+"\n");
 		System.out.println("Check out Date and time: "+ctime+"\n");
 	}
}	


class Complain
{
	String comp,name;
 	int fno;
 	Scanner sc=new Scanner(System.in);
 	void getdata()
 	{ 	
 		System.out.println("Enter your flat number: \n");
 		fno=sc.nextInt();
 		sc.nextLine();
 	
 		System.out.println("Enter your Name:\n");
 		name=sc.nextLine();
 	
  		System.out.println("Enter your Complain:\n");
  		comp=sc.nextLine();
  		System.out.println("\n");
  	}
 	
 	void putdata()
 	{
 		System.out.println("Flat num: "+fno);
 		System.out.println("Name : "+name);
 		System.out.println("Complaint is: "+comp+"\n");
 	}
}


class Notice
{
	Scanner sc=new Scanner(System.in);
	String not,dt;
	
	void getdata()
	{
		System.out.println("Enter the date of notice:\n");
	
		dt=sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the notice: \n");
		not=sc.nextLine();
		sc.nextLine();
		System.out.println("\n");
		
	}
	void putdata()
	{
	
		System.out.println("Date: "+dt);
		System.out.println("Notice:"+not+"\n");
	}
}


class Member
{	
	Scanner sc=new Scanner(System.in);
	String name;
	int flatno;
	String dop;
	
	void getdata()
	{
		System.out.println("Enter the Flat number:");
		flatno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name:");
		
		name=sc.nextLine();
		System.out.println("Enter the date of Possesion");
		dop=sc.nextLine();
		System.out.println("\n");
		
	}
	int getflatno()
	{
		return flatno;
	}
	
	void putdata()
	{
		System.out.println("\nFlat no.: "+flatno+"\nName is: "+name+"\ndate of possesion: "+dop+"\n");
	}
	
}


class Admin
{
 	Scanner sc=new Scanner(System.in);
 	static Vector owners=new Vector();
 	static Vector noti_vec=new Vector();
 	static Vector maintain=new Vector();
 	static Vector complain=new Vector();
 	static Vector security=new Vector();
 
 
	void add_owner()
	{	
		
		Member M=new Member();
		M.getdata();
		owners.addElement(M);
		System.out.println("Data Inserted Succesfully\n");
		
	}
	
	void add_notice()
	{
		Notice N=new Notice();
		N.getdata();
		noti_vec.addElement(N);
		System.out.println("Data Inserted Succesfully\n");
	}
	
	void del_notice(int n)
	{
		noti_vec.remove(n);
		System.out.println("Data Removed Succesfully\n");
	}
	
	void view_notices()
	{
		Notice No=new Notice();
		int i;
		System.out.println("Following are the notices\n");
		for(i=0;i<noti_vec.size();i++)
		{
			No=(Notice)noti_vec.get(i);
			System.out.println("Notice number"+i+"\n");
			No.putdata();
			
		}
		if(noti_vec.size()==0)
		System.out.println("No info found\n");
	}
	
	static int set_n(int fn)
	{
		Member M=new Member();
		for(int i=0;i<owners.size();i++)
		{
			M=(Member)owners.get(i);
			int mn=M.getflatno();
			if(mn==fn)
			return i;
			
		}
		System.out.println("Flat number not found...exiting program\n");
		return -1;
	}
		
	void edit_owner(int fn)
	{
		Member Me=new Member();
		Me.getdata();
		int fno=Admin.set_n(fn);
		owners.setElementAt(Me,fno);
		System.out.println("Data Inserted Succesfully\n");
	}
	
	static void view_allowners()
	{
		int j;
		Member M=new Member();
		for(j=0;j<owners.size();j++)
		{
			M=(Member)owners.get(j);
			System.out.println("Details of Member " +j+" is \n"); 
			M.putdata();
		}
		if(owners.size()==0)
		System.out.println("No info found\n");
	}
	
	static void set_maint(int n,double amt,String date)
	{	Double D=new Double(amt);
		maintain.addElement(n);
		maintain.addElement(date);
		maintain.addElement(D);
	}
	
	void add_maintinfo(int n)
	{
		String date;
		double amt;
		
		System.out.println("Enter the maintainance amount for flat no. "+n );
		amt=sc.nextDouble();
		sc.nextLine();
		
		
		System.out.println("Enter the due date for the maintainance");
		date=sc.nextLine();
		sc.nextLine();
		
		set_maint(n,amt,date);
		System.out.println("Data Inserted Succesfully\n");
		
	}
	
	void view_maintinfo(int n)
	{	
		int fn=0;
		for(int i=0;i<maintain.size();i=i+3)
		{
			fn=Integer.parseInt(maintain.get(3*i).toString());
			if(fn==n)
			{
				System.out.println("Maintainance info for flat no. "+n+"\n");
				System.out.println("Flat no. :"+n);
				
				System.out.println("Maintainance due date: "+(maintain.get((3*i)+1)));
				
				System.out.println("Maintainance amount"+(maintain.get((3*i)+2))+"\n");
			}
		}
		if(fn!=n)
		System.out.println("No info found\n");	
				
	}
	
	void add_complain()
	{	
		Complain C=new Complain();
		C.getdata();
		complain.addElement(C);
		System.out.println("Data Inserted Succesfully\n");
	}
	
	void view_complain()
	{
		Complain C=new Complain();
		System.out.println("Complaints are\n");
		for(int j=0;j<complain.size();j++)
		{
			C=(Complain)complain.get(j);
			System.out.println("Complaint number  "+(j+1)+"\n");
			
			C.putdata();
		}
		if(complain.size()==0)
		System.out.println("No info found\n");
		
	}
	
	void add_visitor()
	{	
		Security S=new Security();
		S.getdata();
		security.addElement(S);
		System.out.println("Data Inserted Succesfully\n");
	}
	
	void view_visitor()
	{
		Security S=new Security();
		System.out.println("Visits are:\n");
		for(int j=0;j<security.size();j++)
		{
			S=(Security)security.get(j);
			System.out.println("Entry number  "+(j+1)+"\n");
			
			S.putdata();
		}
	}
	
	
		
}


class SocietyMain
{
	public static void main(String args[])
	{
		int choice;
		int choic;
		String username="Semil_Jain";
		String password="9930125765";
		String user,pass;
		Scanner sc=new Scanner(System.in);
		
		Admin A=new Admin();
		Member M=new Member();
		Notice N=new Notice();
		Complain C=new Complain();
		Security S=new Security();
		
		System.out.println("\t\tWelcome to Excella Residency !!!\n");
		
		do
		{
			System.out.println("Enter your choice from below options:\n");
			
			System.out.println("1.Admin Login\n2.Members Login\n3.Security Login\n4.exit\n");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case 1:{
						System.out.println("Enter Username");
						user=sc.nextLine();
						
						System.out.println("Enter Password");
						pass=sc.nextLine();
						int compare=user.compareToIgnoreCase(username);
						int compare1=pass.compareToIgnoreCase(password);
						
						if(compare==0 && compare1==0)
						{
							System.out.println("\t\tWelcome Admin\n");
							do
							{
							
							System.out.println("Enter your choice from below options:\n");
							System.out.println("1->Enter New Owners/Rentals Details\n2->Edit Existing Owners/Rentals Detaiils\n3->View All Owners Details\n4->Add new Notice\n5->View All Notices\n6->Delete a Notice\n7->Add Maintainance information\n8->View Maintainance information\n9->View Complains from Members\n10->Exit\n");
							choic=sc.nextInt();
							switch(choic)
							{
								case 1:
								{
								A.add_owner();
								break;
				       				}
				       					
								case 3:
								{
								A.view_allowners();
								break;
								}
								case 2:
								{
								System.out.println("Enter the flat no. whose details are to be edited\n");
								int ch=sc.nextInt();
								A.edit_owner(ch);
								break;
								}
								case 4:
								{
								A.add_notice();
								break;
								}
								case 5:
								{
								A.view_notices();
								break;
								}
								case 6:
								{
								System.out.println("Enter the notice number to be deleted\n");
								int num=sc.nextInt();
								A.del_notice(num);
								break;
								}
								case 7:
								{	
								System.out.println("Enter the flat no.\n");
								int cho=sc.nextInt();
							 	A.add_maintinfo(cho);
							 	break;
								}
								case 8:
								{
								System.out.println("Enter the flat no.\n");
								int choi=sc.nextInt();
								A.view_maintinfo(choi);
								break;
								}
								case 9:
								{
								A.view_complain();
								break;
								}
							}
						       }while(choic!=10);
						}
						else 
						  {
						  System.out.println("Incorrect Username or password...Exiting\n");
						  }
						  break;
					}
					
				case 2:{
						System.out.println("\t\tWelcome Members of Excella Residency !!!\n");
						do
							{
							
							System.out.println("Enter your choice from below options:");
							System.out.println("1->View All Owners Details\n2->View All Notices\n3->View Maintainance information\n4->Enter Complains for Secretary\n5->Exit\n");
							choic=sc.nextInt();
							switch(choic)
							{
								case 1:
								{
								A.view_allowners();
								break;
								}
								case 2:
								{
								A.view_notices();
								break;
								}
								case 3:
								{
								System.out.println("Enter the flat no.\n");
								int choi=sc.nextInt();
								A.view_maintinfo(choi);
								break;
								}
								case 4:
								{
								A.add_complain();
								break;
								}
							}
						       }while(choic!=5);
						       break;
					}	  	
						
				case 3:{
						System.out.println("\t\tWelcome Security Guards !!!\n");
						do
						{
							
							System.out.println("Enter your choice from below options:");
							System.out.println("1->Check in/out guests\n2->view all guests\n3->Exit\n");
							choic=sc.nextInt();
							switch (choic)
							{
								case 1:
								{
								 A.add_visitor();
								 break;
								}
								
								case 2:
								{
								 A.view_visitor();
								 break;
								}
							}
						}while(choic!=3);
					}	
			}					
		}while(choice!=4);					
	}							
}						
											   
									     
		
		
		
	
		 
		
	
			
	
			
	
	
		


