package ds.proj4.streetmapping;

public class IntersectionNode {
	private String id;
	private double lat; // latitude
	private double lng; // longitude
		
	// dijkstra 알고리즘을 위한 AdjList 를
	private boolean visited;
	private double distance;
	private IntersectionNode previous;
	RoadEdge road;     // (previous <-> vertex) 인 road

	public IntersectionNode() {
		this.visited = false;
		this.distance = Double.MAX_VALUE;
		this.previous = null;
		this.road = null;
	}

	public IntersectionNode(String id, double lat, double lng) {
		this();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
	}

	public String getId() {return id;}
	public IntersectionNode setId(String id) {this.id = id; return this;}

	public double getLat() {return lat;}
	public IntersectionNode setLat(double lat) {this.lat = lat; return this;}

	public double getLng() {return lng;}
	public IntersectionNode setLng(double lng) {this.lng = lng; return this;}
	
	public boolean isVisited() {return visited;}
	public IntersectionNode setVisited(boolean visited) {this.visited = visited; return this;}

	public double getDistance() {return distance;}
	public IntersectionNode setDistance(double distance) {this.distance = distance; return this;}

	public IntersectionNode getPrevious() {return previous;}
	public IntersectionNode setPrevious(IntersectionNode previous) {this.previous = previous; return this;}

	public RoadEdge getRoad() {return road;}
	public IntersectionNode setRoad(RoadEdge road) {this.road = road; return this;}

	// 위도와 경도를 사용한 구형상의 두 intersection 간의 거리
	// Haversine Formula 공식 사용
	// 참조: https://en.wikipedia.org/wiki/Haversine_formula
	// 참조: https://bigdatanerd.wordpress.com/2011/11/03/java-implementation-of-haversine-formula-for-distance-calculation-between-two-points/
	public double getDistanceFrom(IntersectionNode other) {
		//final int R = 6371; // Radious of the earth (km)
		final int R = 24901; // Radious of the earth (mile)  <-- 주어진 문제는 mile 이다.
		double latDistance = toRad(other.lat - this.lat);
		double lngDistance = toRad(other.lng - this.lng);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(toRad(this.lat)) * Math.cos(toRad(other.lat)) 
					* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c;
		return distance;
	} // end getDistanceFrom()
	
	public static double getDistanceBetween(IntersectionNode node1, IntersectionNode node2) {
		if(node1 == null || node2 == null) return -1.0;
		return node1.getDistanceFrom(node2);
	}
	
	// Radian 값 변화
	public double toRad(double value) {
		return value * Math.PI / 180;
	}
	
	@Override
	public String toString() {
		return 
			String.format("%20s\t", getId()) +
			String.format(((isVisited())?"T":"F") + "\t") + 
			String.format(((getDistance() == Double.MAX_VALUE)?"∞": String.format("%.3f", getDistance())) + "\t") +
			String.format(((getPrevious() != null)?getPrevious().getId() : "--") + "\t") +
			String.format(((getRoad() != null)?getRoad().toString(): "--"));
	}
	
} // end class
