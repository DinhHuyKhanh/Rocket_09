package backend.Repository;

import entity.CategoryQuestion;
import entity.TypeQuestion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class TypeQuestionRepository {
    UtilsHibernate utilsHibernate;

    public TypeQuestionRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createTypeQuestion(TypeQuestion typeQuestion){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(typeQuestion);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<TypeQuestion> getAllTypeQuestion(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
