package ds.proj4.streetmapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * ur.txt --show
 * ur.txt --show --directions HOYT MOREY
 * ur.txt --directions HOYT MOREY --show 
 * ur.txt --show --directions DEWEY i28
 * ur.txt --show --directions i2 i28
 * ur.txt --show --directions GILBERT-LONG HARKNESS 
 * ur.txt --show --directions i2 i39
 * 
 * ↓ 너~ 무 느리다...
 * monroe.txt --show --directions i1 i60912    <--- adj 체크하는데 어마무시한 시간 걸림.  graph 를 tree 형태로 구축할수 있어야 함.
 * 
 * 
 * disconnect 테스트용 :   monroe   i7 ~ i33333
 * 
 */

public class StreetMap {

	private final static String ERRMSG_USAGE = "USAGE: java StreetMap map.txt [--show] [--directions startIntersection endIntersection]";
	
	public static void main(String[] args) {
	
		
		
		
		//---------------------------------------------------------------
		// 1. 
		// TEST
		System.out.println(Arrays.toString(args));
		
		// 명령행 매개변수 (Command Line Argument) 읽어오기
		if(args.length < 1) {
			System.out.println(ERRMSG_USAGE);
			return; // 프로그램 종료
		}
		
		String mapFileName = args[0];
		boolean isShow = false;
		String startIntersection = null;
		String endIntersection = null;
		
		for(int i = 1; i < args.length; i++) {
			if(args[i].toLowerCase().equals("--show")) {
				isShow = true;
			}else if(args[i].toLowerCase().equals("--directions")) {
				// 이 경우 startIntersection endIntersection 필수적으로 해야 한다.
				try {					
					i++;
					startIntersection = args[i];  // 대소문자 체크 안함 (즉, 정확히 대소문자 일치해야 함)
					i++;
					endIntersection = args[i];
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("--directions needs 2 more intersection names");
					System.out.println(ERRMSG_USAGE);
					return;
				}
			}else {
				System.out.println("Unknown Option: " + args[i]);
				System.out.println(ERRMSG_USAGE);
				return; // 프로그램 종료
			}
		} // end for
		
		// TEST
		// 명령행에 다음과 같이 
		// ur.txt
		// ur.txt --show
		// ur.txt --directions HOYT MOREY
		// ur.txt --show --directions HOYT MOREY
		// ur.txt --df --directions HOYT MOREY      [에러]
		// ur.txt --show --directions   [에러]
		System.out.println("mapFileName: " + mapFileName);
		System.out.println("isShow: " + isShow);
		System.out.println("startIntersection: " + startIntersection);
		System.out.println("endIntersection: " + endIntersection);
		
		
		//---------------------------------------------------------------
		// 2.
		// 파일읽기
		// 명령행의 파일 존재여부 체크 및 읽기
		// intersection 과 road 데이터 저장하기  (여기서는 HashMap 사용)
		// 로딩 성공하면 Graph 객체 생성

		File mapFileInput;
		BufferedReader in = null;
		String strLine;
		int lineNum = 1;

		// 
		HashMap<String, IntersectionNode> hmapIntersection = new HashMap<String, IntersectionNode>();
		HashMap<String, RoadEdge> hmapRoad = new HashMap<String, RoadEdge>(); 
		
		String intersectionId;
		double latitude;
		double longitude;
		
		String roadId;
		String intersectionId1;
		String intersectionId2;

		try {
			mapFileInput = new File(mapFileName);
			in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(mapFileInput), "UTF8"));
			while((strLine = in.readLine()) != null) {
				// TEST 
				// System.out.println(strLine);
				
				// 맵파일의 각 라인은 tab 으로 구분된 텍스트 파일 (tab-delimited text)
				String [] lines = strLine.split("\\s+");
				
				// TEST
				//System.out.println(Arrays.toString(lines));
				
				
				// intersection (i) / road (r) 구분
				//  ↑ node        /   ↑ edge 가 됨
				
				try {					
					switch(lines[0].toLowerCase()) {
					case "i":
						intersectionId = lines[1];
						latitude = Double.parseDouble(lines[2]);
						longitude = Double.parseDouble(lines[3]);
						
						// TEST
//						System.out.println("INTERSECTION: " + intersectionId + " [" + latitude + ", " + longitude +"]");
						
						if(hmapIntersection.get(intersectionId) == null) {
							hmapIntersection.put(intersectionId, new IntersectionNode(intersectionId, latitude, longitude));
							
							//TEST
							//System.out.println(hmapIntersection.get(intersectionId));
							
						}else {
							System.out.println(mapFileName + " 맵 데이터 오류 @ 라인 " + lineNum);
							System.out.println("\t 중복된 intersection : " + intersectionId);
						} // end if
												
						break;
						
					case "r":
						roadId = lines[1];
						intersectionId1 = lines[2];
						intersectionId2 = lines[3];
						
						// TEST
						// System.out.println("ROAD: " + roadId + "(" + intersectionId1 + " ~ " + intersectionId2 + ")");
						
						IntersectionNode node1 = hmapIntersection.get(intersectionId1);
						IntersectionNode node2 = hmapIntersection.get(intersectionId2);
						
						if(node1 == null || node2 == null) {
							System.out.println(mapFileName + " 맵 데이터 오류 @ 라인 " + lineNum);
							System.out.println("\t road 의 intersection id 가 존재하지 않습니다" + roadId);							
						}
						
						if(hmapRoad.get(roadId) == null) {
							hmapRoad.put(roadId, new RoadEdge(roadId, node1, node2));
							
							//TEST
							System.out.println(hmapRoad.get(roadId));
							
							
						}else {
							System.out.println(mapFileName + " 맵 데이터 오류 @ 라인 " + lineNum);
							System.out.println("\t 중복된 road : " + roadId);
						}
						
						
						break;
					default:
						System.out.println("Invalid map data starting with : " + lines[0]);
					} // end switch
				}catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
					System.out.println(mapFileName + " 맵 데이터 오류 @ 라인 " + lineNum);
					System.out.println("\t" + strLine);
				}
				
				lineNum++;
				
			} // end while
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("맵파일이 없습니다-> " + mapFileName);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try
		} // end try
		
		
		// TEST
		// 파일 읽어 들인뒤
		// ur.txt 의 경우
		//intersection: 124
		//road: 181
		System.out.println("파일로딩완료");
		System.out.println("intersection: " + hmapIntersection.size());
		System.out.println("road: " + hmapRoad.size());

		
		//Graph 생성
		System.out.println("\nGRAPH 생성");
		Graph graph = new Graph(hmapIntersection, hmapRoad);
		
		//TEST
//		System.out.println(graph.getNumIntersections());
//		System.out.println(graph.getNumRoads());
	
		// TEST
		// ur.txt 에서
		// i1 과 인접한 intersection은 i2, i3 두개
//		ArrayList<IntersectionNode> list = graph.getAdjectIntersections("i1");
//		System.out.println(list.size() + "개 인접");
//		for(IntersectionNode node : list) {
//			System.out.println(node.getId());
//		}

		
		// TEST
		//graph.dispAdj();
		
		
		
		//----------------------------------------------------------------------
		// 명령행에 startIntersection 과 endIntersection 이 있었으면
		// 최단 경로 shortestpath 찾기
		// 주의: connected 되지 않은 경우도 체크 해야 한다
		// Graph 객체에서 수행
		// path 는  IntersectionNode 들의 list 로 
		
		// 해당 intersection 들이 이 존재 한다면 최단 경로 검색
		ArrayList<IntersectionNode> path = null;
		if(startIntersection != null && endIntersection != null &&
				hmapIntersection.get(startIntersection) != null &&
				hmapIntersection.get(endIntersection) != null) {
		
			System.out.println("최단거리 검색:" + startIntersection + " → " + endIntersection + " ...");			
			graph.dijkstra(startIntersection, endIntersection);	
		} // end if
		
		
		
		//----------------------------------------------------------------------
		MapGraphic mapGraphic;
		if(isShow) {
			String title = mapFileName;
			if(startIntersection != null && endIntersection != null) {
				title += "  [ " + startIntersection + " ~ " + endIntersection +" ]"; 
			}
			mapGraphic = new MapGraphic(graph, title);
		}
		
	} // end main

} // end class
