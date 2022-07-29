package com.stefanini.onlinecatalog.dao;

import com.stefanini.onlinecatalog.JpaService;
import com.stefanini.onlinecatalog.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        return query.getResultList();
    }

    @Override
    public void save(Prof_Stud_Subj prof_stud_subj) {
        ifExist();
        entityManager.getTransaction().begin();
        entityManager.persist(prof_stud_subj);
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
    public Prof_Stud_Subj ifExist() {
        Scanner sc = new Scanner(System.in);
        DaoStudent daoStudent = new DaoStudent();
        DaoProfessor daoProfessor = new DaoProfessor();
        DaoSubject daoSubject = new DaoSubject();
        DaoProf_Stud_Subj daoProf_stud_subj = new DaoProf_Stud_Subj();

        /*System.out.println("Enter grade: ");
        Float grade = sc.nextFloat();
        System.out.println("Enter professor ID: ");
        Integer pID = sc.nextInt();
        System.out.println("Enter student ID: ");
        Integer sID = sc.nextInt();
        System.out.println("Enter subject ID: ");
        Integer subjID = sc.nextInt();*/

        Object[] gradeData ={null, null, null};
        try {
            gradeData[0] = daoStudent.find(2);
            gradeData[1] = daoProfessor.find(1);
            gradeData[2] = daoSubject.find(1);
            for (int i = 0; i < gradeData.length; i++) {
                if(gradeData[i] == null)
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error!!! \nNo object with such ID!!");
            e.printStackTrace();
            return null;
        }

        Prof_Stud_Subj daoProfStudSubj = new Prof_Stud_Subj((Students) gradeData[0],
                (Professors) gradeData[1], (Subjects) gradeData[2], 9.13f);
        return daoProfStudSubj;
    }
    public Prof_Stud_Subj find(Integer id){
        Prof_Stud_Subj obj =  entityManager.find(Prof_Stud_Subj.class, id);
        return obj;
    }
    public void close(){
        entityManager.close();
    }
}
