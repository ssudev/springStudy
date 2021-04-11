package hello.core.singleton;

public class SingletonService {

    // static 영역에 하나만 만들어져서 올라간다
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 만듬 밖에서 못만들게
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
