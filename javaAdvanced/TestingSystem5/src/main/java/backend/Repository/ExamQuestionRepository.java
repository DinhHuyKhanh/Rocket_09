package backend.Repository;

import entity.CategoryQuestion;
import entity.Exam;
import entity.ExamQuestion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class ExamQuestionRepository {
    UtilsHibernate utilsHibernate;

    public ExamQuestionRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createExamQuestion(ExamQuestion examQuestion){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(examQuestion);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<ExamQuestion> getAllExamQuestion(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<ExamQuestion> query = session.createQuery("FROM ExamQuestion ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }



    public void onDeleteExamQuestion(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            ExamQuestion examQuestion = (ExamQuestion) session.load(ExamQuestion.class, id);

            session.delete(examQuestion);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
