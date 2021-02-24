package backend.Repository;

import entity.CategoryQuestion;
import entity.Question;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class QuestionRepository {
    UtilsHibernate utilsHibernate;

    public QuestionRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createQuestion(Question question){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(question);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Question> getAllQuestion(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Question> query = session.createQuery("FROM Question ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void onUpdateQuestion(short id, String newContent){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Question question = (Question) session.load(Question.class, id);

            // update group
            question.setContent(newContent);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteQuestion(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Question question = (Question) session.load(Question.class, id);

            session.delete(question);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
