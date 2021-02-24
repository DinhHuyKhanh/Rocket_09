package backend.Repository;

import entity.Address;
import entity.Answer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;


public class AnswerRepository {
    UtilsHibernate utilsHibernate;

    public  AnswerRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createAnswer(Answer answer){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(answer);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Answer> getAllAnswer(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Answer> query = session.createQuery("FROM Answer ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void onUpdateAnswer(short id, String newContent){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Answer answer = (Answer) session.load(Answer.class, id);

            // update group
            answer.setContent(newContent);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteAnswer(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Answer answer = (Answer) session.load(Answer.class, id);

            session.delete(answer);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

}
