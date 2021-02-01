package backend.Controller;

import backend.Repository.GroupRepository;
import entity.group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import  org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Scanner;


public class ControllerGroup {
    GroupRepository groupRepository = new GroupRepository();


    public void getAllGroup() {
        List<group> groups;
         groups = groupRepository.getAllGroup();
        for(group group : groups){
            System.out.println(group);
        }
    }

    public void createGroup(){
        Scanner scanner = new Scanner(System.in);
        String s;
        group creategroup = new group();
        System.out.println("nhap group name: "); s= scanner.nextLine();
        creategroup.setGroupName(s);
        groupRepository.creatGroup(creategroup);
    }

    public void getGroupById(){
        short id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id:" );
        id = scanner.nextShort();

        group groupbyid = groupRepository.getGroupById(id);
        System.out.println(groupbyid);
    }

    public void getGroupByName(){
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập name:" );
        name = scanner.nextLine();

        group groupbyname = groupRepository.getGroupByName(name);
        System.out.println(groupbyname);
    }
    public void updateGroup(){
        Scanner scanner = new Scanner(System.in);
        String newName;
        short id;
        System.out.println("Nhập id cần update: ");
        id = scanner.nextShort();

        scanner.nextLine();
        System.out.println("Nhập New Name: ");
        newName = scanner.nextLine();

        groupRepository.updateGroup(id,newName);
        System.out.println("success ! ");
    }

    public void deleteGroup(){
        short id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id muốn xóa: ");
        id = scanner.nextShort();

        groupRepository.deleteGroup(id);
    }

    public void isGroupExistsById(){
        Scanner  scanner = new Scanner(System.in);
        short id;
        System.out.println("Mời bạn nhập id");
        id = scanner.nextShort();
        if(groupRepository.isGroupExistById(id) == false) {
            System.out.println("group not exists !");
        }else {
            System.out.println("group exists !");
        }
    }

    public void isGroupExistsByName(){
        Scanner  scanner = new Scanner(System.in);
        String name;
        System.out.println("Mời bạn nhập name");
        name = scanner.nextLine();
        if(groupRepository.isGroupExistsByName(name) == false) {
            System.out.println("group not exists !");
        }else {
            System.out.println("group exists !");
        }
    }



}
