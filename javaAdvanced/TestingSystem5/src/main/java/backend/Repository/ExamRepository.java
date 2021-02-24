package backend.Repository;

import entity.Exam;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class ExamRepository {
    UtilsHibernate utilsHibernate;

    public ExamRepository() {
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void creatExam(Exam exam ){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // create;
            session.save(exam);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Exam> getAllExam(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Exam> query = session.createQuery("FROM Exam ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Exam getExamById(short id) {

        Session session = null;

        try {
            session = utilsHibernate.openSession();

            Exam exam = session.get(Exam.class, id);

            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings({"unchecked"})
    public short getCountOfExamCode(short duration){
        Session session = null;
        try{
            session = utilsHibernate.openSession();

            String sql;
            if(duration >= 180){
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 180";
            }else if(duration >=90){
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 90 AND Duration <180";
            }else{
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration <90";
            }

            Query<Long> query = session.createQuery(sql);
            return  query.uniqueResult().shortValue();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void onDeleteCascade(short id){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            Exam exam = (Exam) session.load(Exam.class,id);

            session.delete(exam);

            session.getTransaction().commit();
        }finally {
            if(session!= null){
                session.close();
            }
        }
    }


}