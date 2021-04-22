import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

public class test {

    @Test
    @DisplayName("그리드")
    public void test1(){
        int n = 5;
        int[] arr = new int[n];
        
        // 소팅
        Arrays.sort(arr);

        int cnt = (5/4);
        int a = 0, b = 0;

        Math.min(a,b);
        Math.max(a,b);

        n = 28;
        int k= 3;
        int target=0;
        int result = 0;

        System.out.println(n/k);
    }

    @Test
    @DisplayName("상하좌우")
    public void 구현1(){
        int n = 5;
        String[] moves = new String[6];
        moves[0] = "R";
        moves[1] = "R";
        moves[2] = "R";
        moves[3] = "U";
        moves[4] = "D";
        moves[5] = "D";

        int x = 0, y = 0, xx = 0, yy = 0;
        String[] mv = {"U","R","D","L"};
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int moveIndex = 0;

        for(String move:moves){
            for(int i=0;i<4;i++){
                if (move.equals(mv[i])){
                    moveIndex = i;
                    break;
                }
            }

            xx = x + dx[moveIndex];
            yy = y + dy[moveIndex];

            if ((xx >= 0 && xx < n) && (yy >= 0 && yy < n)){
                x = xx;
                y = yy;
            }
        }

        x += 1;
        y += 1;

        System.out.println("x : " + x + " y : " + y);
    }

    @Test
    @DisplayName("시각")
    public void 구현2(){
        int n = 5;
        int result = 0;

        int hour,min,sec;
        hour = 0;
        min = 0;
        sec = 0;
        
        // 하루는 86400초
        for(int i=0;i<n+1;i++){
            for(int j=0;j<60;j++){
                for(int s=0;s<60;s++){
                    
                    // 포함여부 확인 하는 방법
                    String ck = String.valueOf(i) + String.valueOf(j) + String.valueOf(s);
                    if(ck.contains("3")){
                        result += 1;
                    }
                }
            }
        }

        System.out.println("Result : " + result);
    }

    @Test
    @DisplayName("나이트")
    public void 구현3(){
        String inputData = "a1";
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

    }

    @Test
    @DisplayName("게임 개발")
    public void 구현4(){
        int[][] map = new int[50][50];

        for(int i=0;i<50;i++){
            System.out.println(map[i][i]);
        }
    }

    @Test
    @DisplayName("스택, 큐")
    public void 스택큐(){
        // stack
        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.pop();

        while( !s.empty() ){
            s.pop();
        }

        // queue
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.poll();

        while (!q.isEmpty()){
            q.poll();
        }
    }

    @Test
    @DisplayName("인접리스트")
    public void 인접리스트(){
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for(int i=0;i<3;i++){
            graph.add(new ArrayList<Node>());
        }

        graph.get(0).add(new Node(1,7));

        for(int i=0;i<3;i++){
            for(int j=0;j<graph.get(i).size();i++){
                graph.get(i).get(j).show();
            }
        }
    }

    // DFS 재귀함수 로직
    public void logicDfs(int x, boolean[] visited, ArrayList<ArrayList<Node>> graph){
        visited[x] = true;
        System.out.print(x + " ");

        for(int i=0;i<graph.get(x).size();i++){
            int y = graph.get(x).get(i).getIndex();

            if (!visited[y]) logicDfs(y,visited,graph);
        }
    }

    // BFS 로직
    public void bfs(int start, boolean[] visited, ArrayList<ArrayList<Node>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i).getIndex();
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    @Test
    @DisplayName("DFS")
    public void DFS(){
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        boolean[] visit = new boolean[9];

        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(new Node(2));
        graph.get(1).add(new Node(3));
        graph.get(1).add(new Node(4));

        logicDfs(1, visit, graph);
    }

    @Test
    @DisplayName("음료수 얼려먹기")
    public void 음료수얼려먹기(){
        int[][] map = new int[4][5];

        map[0][2] = 1;
        map[0][3] = 1;
        map[1][3] = 1;
        map[1][4] = 1;
        map[2][0] = 1;
        map[2][1] = 1;
        map[2][2] = 1;
        map[2][3] = 1;
        map[2][4] = 1;

        Queue<MapNode> q = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int result = 0;

        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){

                if(map[i][j] == 0){

                    q.offer(new MapNode(i,j));
                    map[i][j] = 1;
                    result += 1;

                    while(!q.isEmpty()){
                        MapNode e = q.poll();

                        int x = e.getX();
                        int y = e.getY();

                        for(int k=0;k<4;k++){
                            int xx = x + dx[k];
                            int yy = y + dy[k];

                            if(( xx >=0 && xx < 4) && (yy >=0 && yy < 5) && map[xx][yy] == 0){
                                q.offer(new MapNode(xx,yy));
                                map[xx][yy] = 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("result : " + result);
    }

    @Test
    @DisplayName("성적정렬")
    public void 성적정렬(){
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("홍길동",95));
        studentList.add(new Student("이순신",77));

        Collections.sort(studentList);
        
        for(Student student : studentList){
            System.out.println("student = " + student);
        }
    }

    @Test
    @DisplayName("원소교체 정렬")
    public void 원소교체(){
        Integer[] a = new Integer[5];
        Integer[] b = new Integer[5];

        a[0] = 1;
        a[1] = 2;
        a[2] = 5;
        a[3] = 4;
        a[4] = 3;

        b[0] = 5;
        b[1] = 5;
        b[2] = 6;
        b[3] = 6;
        b[4] = 5;

        // 정렬
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i=0;i<3;i++){
            if(a[i] < b[i]){
                a[i] = b[i];
            }
        }

        // Integer -> int 변환
        int[] s = Arrays.stream(a).mapToInt(Integer::intValue).toArray();
        
        // 배열 합
        Arrays.stream(s).sum();
        
        // 최대 최소
        Arrays.stream(s).max().getAsInt();
        Arrays.stream(s).min().getAsInt();
    }

    // 이진 탐색 구현
    public int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end);
    }

    // 이진 탐색 소스코드 구현(반복문)
    public int binarySearchLoop(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    @Test
    @DisplayName("다이나믹 프로그래밍")
    public void 일로만들기(){
        int x = 26;
        int[] dp = new int[27];
        dp[1] = 0;

        for( int i=2;i<x+1;i++){
            int num = dp[i-1] + 1;

            if(i % 2 == 0){
                num = Math.min(num, dp[i/2] + 1);
            }

            if(i % 3 == 0){
                num = Math.min(num, dp[i/3] + 1);
            }

            if(i % 5 == 0){
                num = Math.min(num, dp[i/5] + 1);
            }

            dp[i] = num;
        }
        
        for(int i = 1; i < dp.length;i++){
            System.out.println(i + " " + dp[i]);
        }
    }

    public void dijkstra(int start, int[] d, ArrayList<ArrayList<Node>> graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist)
                continue;

            for(int i=0;i<graph.get(now).size();i++){

                int cost = d[now] + graph.get(now).get(i).getDistance();
                int nextIndex = graph.get(now).get(i).getIndex();

                if(cost < d[nextIndex]){
                    d[nextIndex] = cost;
                    pq.offer(new Node(nextIndex, cost));
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        list.size();

        Map<String,Integer> resultMap = new HashMap<String, Integer>();
    }

    @Test
    public void 플로이드워셜(){
        final int INF = (int)1e9;
        int[][] graph = new int[501][501];
        int n,m;
        n = 5;
        m = 5;

        // 가득 체우기
        for(int i=0;i<501;i++){
            Arrays.fill(graph[i], INF);
        }

        // 자기자신 비용 0으로 초기화
        for(int i=0;i<n;i++){
            graph[i][i] = 0;
        }

        // 그래프에 비용 넣기
        for(int i=0;i<m;i++){
            int a,b;
            a = 0;
            b = 0;
            graph[a][b] = 0;
        }

        // 모든 간선을 가는 경우를 판단한다.
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

    public int findParent(int x, int[] parent){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x], parent);
    }

    public void unionParent(int a, int b, int[] parent){
        a = findParent(a,parent);
        b = findParent(b,parent);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    @Test
    public void 크루스칼(){
        ArrayList<Edge> edges = new ArrayList<>();
        int[] parent = new int[5];

        // 부모테이블은 자기 자신으로 업데이트
        for(int i=0;i<5;i++){
            parent[i] = i;
        }

        for(int i=0;i<5;i++){
            edges.add(new Edge(3,1,1));
        }

        // 짧은 순대로 정렬
        Collections.sort(edges);
        int result = 0;

        // 간선 확인
        for(int i=0;i<edges.size();i++){
            Edge edge = edges.get(i);
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            // 사이클 발생 확인
            if(findParent(a,parent) != findParent(b,parent)){
                unionParent(a,b,parent);
                result += cost;
            }
        }

        System.out.println(12%4);

        if (1 < 3){

        }
    }

    @Test
    public void 위상정렬(){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[50];

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for(int i=1;i<=50;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);

            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i=0;i<graph.get(now).size();i++){
                indegree[graph.get(now).get(i)] -= 1;

                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }

    @Test
    public void solution() {

        int[] T = {-3,-14,-5,7,8,42,8,3};

        // write your code in Java SE 8
        int[] winter = new int[T.length/4];
        int[] spring = new int[T.length/4];
        int[] summer = new int[T.length/4];
        int[] autumn = new int[T.length/4];
        String result = "";
        int num = T.length/4;

        for(int i=1;i<T.length+1;i++){
            if(num * 1 >= i){
                winter[(i-1)%num] = T[(i-1)];
            }else if(num * 2 >= i && num * 1 < i){
                spring[(i-1)%num] = T[(i-1)];
            }else if(num * 3 >= i && num * 2 < i){
                summer[(i-1)%num] = T[(i-1)];
            }else{
                autumn[(i-1)%num] = T[(i-1)];
            }
        }

        for(int i=0;i<T.length/4;i++){
            System.out.print(winter[i] + " ");
        }

        for(int i=0;i<T.length/4;i++){
            System.out.print(spring[i] + " ");
        }

        for(int i=0;i<T.length/4;i++){
            System.out.print(summer[i] + " ");
        }

        for(int i=0;i<T.length/4;i++){
            System.out.print(autumn[i] + " ");
        }

        //return result;
    }
}

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Node implements Comparable<Node>{
    private int index;
    private int distance;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node(int index) {
        this.index = index;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }

    @Override
    public int compareTo(@NotNull Node o) {
        if(this.distance < o.distance){
            return -1;
        }else{
            return 1;
        }
    }
}

// 객체 정렬
class Student implements Comparable<Student>{
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        if(this.grade < o.grade){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
class MapNode{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MapNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}