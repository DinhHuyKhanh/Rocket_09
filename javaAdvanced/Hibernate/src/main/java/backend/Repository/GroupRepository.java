package backend.Repository;


import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;
import entity.group;

import java.util.List;


public class GroupRepository {
    UtilsHibernate  utilsHibernate;


    public GroupRepository() {
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void creatGroup(group group){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // create;
            session.save(group);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<group> getAllGroup(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<group> query = session.createQuery("FROM group ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public group getGroupById(short id){

        Session session = null;

        try{
            session = utilsHibernate.openSession();

            group group = session.get(group.class, id);

            return group;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public group getGroupByName(String name){

        Session session = null;

        try{
            session = utilsHibernate.openSession();

            // creat hql query
            Query<group> query = session.createQuery("FROM group WHERE groupName = :nameParameter");

            // set parameter
            query.setParameter("nameParameter",name);

            //get result
            group group = query.uniqueResult();

            return group;

        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void updateGroup(short id, String newName){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            group group = (group)session.load(group.class, id);

            // update group
            group.setGroupName(newName);
            // commit lại
            session.getTransaction().commit();
        }finally {
             if(session != null){
                 session.close();
             }
        }
    }

    public void deleteGroup(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            group group = (group) session.load(group.class, id);

            session.delete(group);
            session.getTransaction().commit();
        }finally {
             if(session != null){
                 session.close();
             }
        }
    }

    public boolean isGroupExistById(short id){
        group group = getGroupById(id);
        if(group == null) {
            return false;
        }

        return true;
    }

    public boolean isGroupExistsByName(String name){
        group group = getGroupByName(name);
        if(group == null) return false;
        return true;
    }

    
    

}
