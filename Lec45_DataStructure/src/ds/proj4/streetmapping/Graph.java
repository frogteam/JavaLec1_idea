package ds.proj4.streetmapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 
 * The Graph ADT describes a container storing an adjacency relation 
 * – Queries include: 
 * • The number of vertices 
 * • The number of edges 
 * • List the vertices adjacent to a given vertex 
 * • Are two vertices adjacent? 
 * • Are two vertices connected?
 * 
 * – Modifications include: 
 * • Inserting or removing an edge 
 * • Inserting or removing a vertex (and all edges containing that vertex
 * 
 * adjecency matrix 가 아니라 adjacenty list 를 사용해야 한다 (과제 요구사항)
 */
public class Graph {
	private HashMap<String, IntersectionNode> hmapIntersection;
	private HashMap<String, RoadEdge> hmapRoad;
	
	private PriorityQueue<IntersectionNode> pqUnvisit;
	private ArrayList<IntersectionNode> listVisit;
	private PriorityQueue<IntersectionNode> pqTempUnvisit;
	
	
	private ArrayList<IntersectionNode> path;
	
	public Graph(HashMap<String, IntersectionNode> hmapIntersection, HashMap<String, RoadEdge> hmapRoad) {
		this.hmapIntersection = hmapIntersection;
		this.hmapRoad = hmapRoad;
		
	}
	
	
	public HashMap<String, IntersectionNode> getHmapIntersection() {return hmapIntersection;}
	public void setHmapIntersection(HashMap<String, IntersectionNode> hmapIntersection) {this.hmapIntersection = hmapIntersection;}

	public HashMap<String, RoadEdge> getHmapRoad() {return hmapRoad;}
	public void setHmapRoad(HashMap<String, RoadEdge> hmapRoad) {this.hmapRoad = hmapRoad;}

	public IntersectionNode getIntersection(String intersectionId) {return hmapIntersection.get(intersectionId);}	
	public RoadEdge getRoad(String roadId) {return hmapRoad.get(roadId);}
	public RoadEdge getRoad(IntersectionNode node1, IntersectionNode node2) {  // instance 비교..
		IntersectionNode intersection1;
		IntersectionNode intersection2;
		// road 를 다 뒤져서 찾아본다.
		for(Map.Entry<String, RoadEdge> m : hmapRoad.entrySet()) {
			intersection1 = m.getValue().getIntersection1();
			intersection2 = m.getValue().getIntersection2();
			
			// road 양끝단 intersection 중  주어진 id 와 같은 것이 있다면
			// 반대쪽 intersection 은 adject vertex 이므로 추가!
			if((intersection1 == node1 && intersection2 == node2) ||
					(intersection1 == node2 && intersection2 == node1)) {
				return m.getValue();
			}
		}
		return null;
	}
	
	public ArrayList<IntersectionNode> getPath() {return path;}
	public void setPath(ArrayList<IntersectionNode> path) {this.path = path;}


	public int getNumIntersections() {
		if(hmapIntersection == null) return -1;
		return hmapIntersection.size();
	}
	
	
	public int getNumRoads() {
		if(hmapRoad == null) return -1;
		return hmapRoad.size();
	}
	
	
	// 참조: http://bumbums.tistory.com/4   <-- 중간 경로가 안나오고 최종 거리만 산출
	// 참조:  http://www.cs.dartmouth.edu/~thc/cs10/lectures/0509/0509.html
	// adjacency matrix 를 쓰면 안되고
	// adjacency list 를 사용하자 --> PriorityQueue<> !!
	
	public void dijkstra(String id1, String id2) {
		
		IntersectionNode startIntersection = getIntersection(id1);
		IntersectionNode endIntersection = getIntersection(id2);
		path = null;
		
		// 두개의 id가 존재하는지 확인
		if(startIntersection == null || endIntersection == null) return;
		
		// 일단 기존의 Adj List 를 리셋시켜야 한다.
		pqUnvisit = new PriorityQueue<IntersectionNode>(hmapIntersection.size(), new AscDistance());
		listVisit = new ArrayList<IntersectionNode>();
		pqTempUnvisit = new PriorityQueue<IntersectionNode>(hmapIntersection.size(), new AscDistance());
		
		
		for(Map.Entry m : hmapIntersection.entrySet()) {
			IntersectionNode node = (IntersectionNode)m.getValue();
			node.setVisited(false);
			node.setPrevious(null);
			
			if(node == startIntersection) {  // 일단 instance 로 비교하긴 했는데... (이름으로 비교할까?)
				node.setDistance(0.0);   // 시작지점은 거리 0 으로 시작
			}else {
				node.setDistance(Double.MAX_VALUE);	
			}
			
			pqUnvisit.offer(node);  
		} // end for

		// TEST
		// 테스트에선 HOYT : 0.0 이 나와야 한다
//		System.out.println("TEST " + pqUnvisit.peek().getId() + " : " + pqUnvisit.peek().getDistance());
		
		while(true) {			
			pqTempUnvisit.clear();
			
			// visit 할 intersection 선택
			// unvisit 된 vertex 중에서 distance 가 가장 작은 것
			IntersectionNode visit = pqUnvisit.poll();
			
			System.out.println("VISIT " + visit.getId() + ":" + visit.getDistance());
			
			if(visit.getDistance() == Double.MAX_VALUE) {  // 이때 선택된 u 의 distance 가  ∞ 이면 종료.  즉 나머지 것들은 disconnected 되었다는 뜻
				System.out.println(id1 + " ~ " + id2 + " 는 disconnect 됨.  최단경로 없슴");
				return;
			}
			
			visit.setVisited(true);  // visited → true 세팅
			listVisit.add(visit);
			
			// visit 종료
			//visit 종료 된 vertex 가 ‘도착지’ 라면  여기서 ‘길찾기’ 종료하면 된다.
			if(visit == endIntersection) break;
			
			// 특정 u 와 ‘인접한 unvisit 들'들 추출
			IntersectionNode unvisit;
			RoadEdge road;
			while((unvisit = pqUnvisit.poll()) != null) {
				road = getRoad(visit, unvisit);   // 인접했나?
				if(road != null) {  // 인접했다면! relax 수행
					relax(visit, unvisit);
				}
				pqTempUnvisit.offer(unvisit);
			}
			
			// Priority Queue 교체
			PriorityQueue<IntersectionNode> temp;
			temp = pqUnvisit; 
			pqUnvisit = pqTempUnvisit;   
			pqTempUnvisit = temp;
			
			
		} // end while
		
		
		
		// TEST
		System.out.println("[VISIT 종료]");
		for(IntersectionNode node : listVisit) {
			System.out.println(node);
		}

	
		// 최단 경로 path 추출하기
		if(listVisit.size() <= 1) return;    // 경로가 없으면 null 리턴
		
		IntersectionNode node = listVisit.get(listVisit.size() - 1);
		path = new ArrayList<IntersectionNode>();
		
		while(node != null) {
			path.add(node);
			if(node == startIntersection) break;
			node = node.getPrevious();		
		}
		
		Collections.reverse(path);
		
		//TEST
		System.out.println("최단경로");
		for(IntersectionNode n : path) {
			System.out.println(n);
		}
		
		return;
		
	} // end dijkstra()
	
	
	//
	public void relax(IntersectionNode u, IntersectionNode v) {
		RoadEdge road = getRoad(u, v);
		if (road == null) {
			System.out.println("ERROR: relax() 해당 road 가 없습니다" + u.getId() + " -- " + v.getId());
			return;
		}
		
		double newDistance = u.getDistance() + road.getDistance();
		if(newDistance < v.getDistance()) {
			v.setDistance(newDistance);    // v.의 distance 업데이트
			v.setPrevious(u);    // v 의 previous 업데이트
			v.setRoad(road);
		}
	} // end relax()
	
	
	// 
	class AscDistance implements Comparator<IntersectionNode> {
		@Override
		public int compare(IntersectionNode o1, IntersectionNode o2) {
			if(o1.getDistance() > o2.getDistance()) return 1;
			if(o1.getDistance() < o2.getDistance()) return -1;
			return 0;
		}
	}
	

} // end class

