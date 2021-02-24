package backend.Repository;

import entity.CategoryQuestion;
import entity.Position;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class PositionRepository {
    UtilsHibernate utilsHibernate;

    public PositionRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createPosition(Position position){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(position);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Position> getAllPosition(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Position> query = session.createQuery("FROM Position ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }



    public void onDeletePosition(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get
            Position position = (Position) session.load(Position.class, id);

            session.delete(position);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
