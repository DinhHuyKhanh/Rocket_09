package backend.POJO.Repository.Criteria;

import backend.POJO.DepartmentConvert;
import entity.Department;
import entity.DetailDepartment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import utils.UtilsHibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DepartmentCriteria {
    UtilsHibernate utilsHibernate;

    public DepartmentCriteria(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createDepartment(Department department){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(department);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<DepartmentConvert> getAllDepartment(String fieldName, short filter){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            Criteria criteria = session.createCriteria(DetailDepartment.class);
            List<DetailDepartment> departments2 = criteria.list();

//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<DepartmentConvert> query = builder.createQuery(DepartmentConvert.class);
//            Root<DetailDepartment> root = query.from(DetailDepartment.class); // FROM
//
//            query.select( builder.construct( DepartmentConvert.class,
//                    root.get("departmentID"), root.get("departmentName") ) );
            List<DepartmentConvert> departments = new ArrayList<DepartmentConvert>();
            for (DetailDepartment departmen:departments2 ) {
                DepartmentConvert departmentConvert =
                        new DepartmentConvert(departmen.getDepartmentID(),departmen.getDepartmentName(),
                                departmen.getAddress().getAddressName());
                departments.add(departmentConvert);

            }

            return departments;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }




}
