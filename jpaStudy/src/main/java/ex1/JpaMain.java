package ex1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        // 로딩시점에 딱 한번 만든다.
        // DB당 하나만 생성한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 쿼리를 실행할때마다 manager를 만들어야 된다.
        // 고객의 요청이 올때마다 썻다가 버렸다가 한다.
        // 쓰레드간에 절대 공유하면 안된다.
        EntityManager em = emf.createEntityManager();
        
        // 트랜잭션 호출
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            // JPA에서는 트랜잭션이 매우 중요하다.
            Member member = em.find(Member.class, 1L);

            // JPA를 통해 데이터를 가져오면 COMMIT하는 시점에 데이터를 다 확인해서 업데이트를 다 치고 COMMIT한다.
            member.setName("helloJPA");
            
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}