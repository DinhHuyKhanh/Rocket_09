package backend.Repository;

import entity.Account;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class AddressRepository {
    UtilsHibernate utilsHibernate;

    public AddressRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createAddress(Address address){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(address);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Address> getAllAddress(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Address> query = session.createQuery("FROM Address ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void updateAddress(short id, String newAddressName){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Address address = (Address) session.load(Address.class, id);

            // update group
            address.setAddressName(newAddressName);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteAddress(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Address address = (Address) session.load(Address.class, id);

            session.delete(address);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
