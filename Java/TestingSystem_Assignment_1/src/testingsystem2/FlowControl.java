package testingsystem2;
import backend.*;
import emtity.*;
import frontend.*;

public class FlowControl {

    public void question1(Account[] accounts){
        if(accounts[1].getDepartmentid() == 0 )
        {
            System.out.println("Nhân viên chưa có phòng ban");
        }
        else
        {
            System.out.println("Nhân viên này thuộc phòng ban: "+accounts[2].getDepartmentid());
        }
    }

    public void question2(AccountGroup[] ac){
        int dem=0;
        for(int i=0;i<ac.length;i++)
        {
            if(ac[i].getAccountid()==2) dem++;
        }
        switch (dem)
        {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default: System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả group");
        }
    }
    public void question3(Account[] accounts){
        String s;
        s= (accounts[1].getDepartmentid()==0)?"Nhân viên chưa có phòng bàn":("Nhân viên này thuộc phòng ban: "+accounts[2].getDepartmentid());
        System.out.println(s);
    }

    public void question4(Account[] accounts, Position[] positions){
        int res=0;
        for(int i=0;i<positions.length;i++)
        {
            if(positions[i].getPositionname().equals("Dev"))
            {
                res = i;
                break;
            }
        }
        System.out.println((accounts[0].getPositionid() == res)?"Đây là Developer":"Người này không phải Developer");
    }

    public void question5(AccountGroup[] ac) {
        int dem = 0;
        for (int i = 0; i < ac.length; i++) {
            if (ac[i].getAccountid() == 1) dem++;
        }
        switch (dem) {
            case 1:
                System.out.println("Nhóm có 1 thành viên");
                break;
            case 2:
                System.out.println("Nhóm có 2 thành viên");
                break;
            case 3:
                System.out.println("Nhóm có 3 thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
    }
      // question 6 == question 2;
      public void question7(Account[] accounts,Position[] positions){
          int res=0;
          for(int i=0;i<positions.length;i++)
          {
              if(positions[i].getPositionname().equals("Dev"))
              {
                  res = i;
                  break;
              }
          }
          int x=0;
          if(accounts[1].getPositionid()==res) x=1;
          else x=0;
          switch (x)
          {
              case 0:
                  System.out.println("Người này không phải Developer!!!");
                  break;
              case 1:
                  System.out.println("Đây là Developer!!! ");
                  break;
          }
        }

        public void question8(Account[] a , Department[] b) {

            for (Account i : a) {
                System.out.println("Email: "+ i.getEmail());
                System.out.println("Full Name: "+i.getFullname());
                String s;
                for(int j=0;j<b.length;j++)
                {
                    if(b[j].getDepartmentid() == i.getDepartmentid())
                        System.out.println("Department name: "+ b[j].getDepartmentname());
                }
            }

        }
        public void question9(Department[] a) {

            for (Department x : a) {
                System.out.println("id: "+x.getDepartmentid());
                System.out.println("Department name: "+x.getDepartmentname());
            }
        }

       public void question10(Account[] accounts, Department[] departments) {
           for (int i = 0; i < accounts.length; i++) {
               System.out.println("Account Thứ"+(i+1)+ " là");
               System.out.println("Email: " + accounts[i].getEmail());
               System.out.println("Full Name: " + accounts[i].getFullname());

                for(int j=0;j<departments.length;j++)
                {
                    if(accounts[i].getDepartmentid()== departments[j].getDepartmentid())
                    {
                        System.out.println("Tên phòng ban: "+departments[i].getDepartmentname());
                    }
                }
           }
       }


       public void question11(Department[] departments){

        for(int i=0;i<departments.length;i++)
        {
            System.out.println("Id: " +departments[i].getDepartmentid());
            System.out.println("Name: "+departments[i].getDepartmentname());
        }
       }
       public void question12(Department[] departments){

        for(int i=0;i<departments.length;i++)
        {
            System.out.println("Depatment thứ "+(i+1) +" là");
            System.out.println("Id: "+ departments[i].getDepartmentid());
            System.out.println("Name: "+departments[i].getDepartmentname());
        }
       }

       public void question13(Account[] accounts){
           for(int i=0;i<accounts.length;i++)
           {
               if(accounts[i].getDepartmentid()!=2)
                   System.out.println("Đây là account thứ"+ accounts[i].getDepartmentid());
           }
       }

       public void question14(Account[] accounts)
       {
           for(int i=0;i<accounts.length;i++)
           {
               if(accounts[i].getAccountid()<4)
                   System.out.println("account : "+accounts[i].getAccountid());

           }
       }
       public void question15()
       {
           for(int i=1;i<20;i++)
           {
               System.out.println((i%2==0)?i:"");
           }
       }
       // while
    public void question16(Account[] accounts, Department[] departments){
        int i=0;
        while(i<accounts.length) {
            System.out.println("Account Thứ"+(i+1)+ " là");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full Name: " + accounts[i].getFullname());
            int j=0;
            while(true)
            {
                if(accounts[i].getDepartmentid()== departments[j].getDepartmentid()) {
                    System.out.println("Tên phòng ban: " + departments[i].getDepartmentname());
                    break;
                }else{
                    j++;
                    continue;
                }
            }
        }
    }
    //  Nhung cau con lai phan while tuong tu question16
    // question 17
    public void question17(Account[] accounts, Department[] departments){
        int i=0;
       do {
            System.out.println("Account Thứ"+(i+1)+ " là");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full Name: " + accounts[i].getFullname());
            int j=0;
            do
            {
                if(accounts[i].getDepartmentid()== departments[j].getDepartmentid()) {
                    System.out.println("Tên phòng ban: " + departments[i].getDepartmentname());
                    break;
                }else{
                    j++;
                    continue;
                }
            }while(true);
            i++;
        }while (i<accounts.length);
    }

    // cac phan con lai do while tuong tu question17


    // ex2  ở phần project TestingSystem2


}


