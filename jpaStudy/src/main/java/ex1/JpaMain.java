package ex1;

import javax.persistence.*;
import java.util.List;

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

            // 비영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            // 영속 (이때는 DB에 저장되는 상태가 아님)
            em.persist(member1);
            em.persist(member2);
            System.out.println("===================");
            // 영속성 컨텍스트에서 분리, 준영속 상태
            //em.detach(member);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}