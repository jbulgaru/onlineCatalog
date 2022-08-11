package com.stefanini.onlinecatalog.dao;

import com.stefanini.onlinecatalog.JpaService;
import com.stefanini.onlinecatalog.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DaoProf_Stud_Subj implements  DAO<Prof_Stud_Subj>{
    EntityManager entityManager = JpaService.getInstance();
    @Override
    public Optional<Prof_Stud_Subj> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Prof_Stud_Subj> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Prof_Stud_Subj c", Prof_Stud_Subj.class);
        List<Prof_Stud_Subj> list = query.getResultList();
        return list;
    }

    public List<Prof_Stud_Subj> catalogWithGradesLessThenFive() {
        Query query = entityManager.createQuery("SELECT c FROM Prof_Stud_Subj c where c.grade < 5", Prof_Stud_Subj.class);
        List<Prof_Stud_Subj> list = query.getResultList();
        return list;
    }

    @Override
    public void save(Prof_Stud_Subj prof_stud_subj) {
        entityManager.getTransaction().begin();
        //Grade validation
        if(prof_stud_subj.getGrade() >= 1 && prof_stud_subj.getGrade() <=10){
            entityManager.persist(prof_stud_subj);
        }else{
            System.out.println("\n\nPlease enter a valid grade  [1, 10]\n");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Prof_Stud_Subj prof_stud_subj) {
        entityManager.getTransaction().begin();
        entityManager.merge(prof_stud_subj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Prof_Stud_Subj prof_stud_subj) {
        entityManager.getTransaction().begin();
        Prof_Stud_Subj data = entityManager.merge(prof_stud_subj);
        entityManager.remove(data);
        entityManager.getTransaction().commit();
    }
    public Prof_Stud_Subj ifExist(Integer subj, Integer stud, Integer prof, Float grade) {
        Scanner sc = new Scanner(System.in);
        DaoStudent daoStudent = new DaoStudent();
        DaoProfessor daoProfessor = new DaoProfessor();
        DaoSubject daoSubject = new DaoSubject();
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();

        Object[] gradeData ={null, null, null};
        try {
            gradeData[0] = daoStudent.find(stud);
            gradeData[1] = daoProfessor.find(prof);
            gradeData[2] = daoSubject.find(subj);
            for (int i = 0; i < gradeData.length; i++) {
                if(gradeData[i] == null)
                    throw new Exception();
            }
        } catch (Exception e) {

            System.out.println("\n\n\nError!!! \nNo object with such ID!!\n\n\n\n");
            e.printStackTrace();
            return null;
        }

        Prof_Stud_Subj daoProfStudSubj = new Prof_Stud_Subj((Students) gradeData[0],
                (Professors) gradeData[1], (Subjects) gradeData[2], grade);
        return daoProfStudSubj;
    }
    public Prof_Stud_Subj find(Integer id){
        Prof_Stud_Subj obj =  entityManager.find(Prof_Stud_Subj.class, id);
        return obj;
    }
    public void deleteStudentsByIDs(int idStudent) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Prof_Stud_Subj o WHERE o.studentID = "+ idStudent);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Prof_Stud_Subj> findAllCoursesByStudentId(int idStudent) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select c from Prof_Stud_Subj c where c.studentID = " + idStudent);
        query.getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }
    public void close(){
        entityManager.close();
    }
}
