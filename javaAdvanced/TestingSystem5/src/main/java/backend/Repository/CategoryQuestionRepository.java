package backend.Repository;

import entity.Answer;
import entity.CategoryQuestion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class CategoryQuestionRepository {

    UtilsHibernate utilsHibernate;

    public CategoryQuestionRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createCategoryQuestion(CategoryQuestion categoryQuestion){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(categoryQuestion);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<CategoryQuestion> getAllCategoryQuestion(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void onUpdateCategoryQuestion(short id, String newCategoryName){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

            // update group
            categoryQuestion.setCategoryName(newCategoryName);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteCategoryQuestion(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

            session.delete(categoryQuestion);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
