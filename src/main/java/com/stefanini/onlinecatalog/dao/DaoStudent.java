package com.stefanini.onlinecatalog.dao;
import com.stefanini.onlinecatalog.JpaService;
import com.stefanini.onlinecatalog.entity.Students;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


public class DaoStudent implements  DAO<Students> {
    EntityManager entityManager = JpaService.getInstance();

    @Override
    public Optional<Students> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Students.class, id));
    }

    @Override
    public List<Students> getAll() {

        Query query = entityManager.createQuery("SELECT c FROM Students c", Students.class);

        return query.getResultList() ;
    }
    /*public List<Students>  groupStudentsBySubjects() {
        Query query = entityManager.createNamedQuery("group students by subjects");

        return query.getResultList() ;
    }
*/

    @Override
    public void save(Students students) {
        entityManager.getTransaction().begin();
        entityManager.persist(students);
        entityManager.getTransaction().commit();
    }

    public Students find(Integer id){
       Students student =  entityManager.find(Students.class, id);
        return student;
    }

    @Override
    public void update(Students students) {
        entityManager.getTransaction().begin();
        entityManager.merge(students);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Students students) {
        entityManager.getTransaction().begin();
        Students student = entityManager.merge(students);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
    public List<Students> getBursieriDeMerit(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s " +
                "FROM Students s " +
                "JOIN FETCH  Prof_Stud_Subj Prof " +
                "ON Prof.ID = s.ID and Prof.grade >= 9 ORDER by Prof.grade desc", Students.class);
        List<Students> students =  query.getResultList();
       /* for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }*/
        entityManager.getTransaction().commit();
        return students;
    }

    public List<Students> getGrantHolders(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s from Students s where s.grantHolder = 'y'", Students.class);
        List<Students> students =  query.getResultList();
        /*for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }*/
        entityManager.getTransaction().commit();
        return students;
    }

    public void close(){
        entityManager.close();
    }
}
