package ds.proj4.streetmapping;

public class RoadEdge {
	private String id;  // roadId

	private IntersectionNode intersection1;
	private IntersectionNode intersection2;
	
	public RoadEdge() {}

	public RoadEdge(String id, IntersectionNode intersection1, IntersectionNode intersection2) {
		super();
		this.id = id;
		this.intersection1 = intersection1;
		this.intersection2 = intersection2;
	}
	
	// getter / setter
	public String getId() {return id;}
	public RoadEdge setId(String id) {this.id = id; return this;}
	
	public IntersectionNode getIntersection1() {return intersection1;}
	public RoadEdge setIntersection1(IntersectionNode intersection1) {
		this.intersection1 = intersection1;
		return this;
	}
	public IntersectionNode getIntersection2() {return intersection2;}
	public RoadEdge setIntersection2(IntersectionNode intersection2) {
		this.intersection2 = intersection2;
		return this;
	}
	
	// 두 intersection 사이의 거리
	public double getDistance() {
		return intersection1.getDistanceFrom(intersection2);
	}
	
	@Override
	public String toString() {
		return String.format("%s[%s-%s] %.3f", id, intersection1.getId(), intersection2.getId(), getDistance()); 
	}
	
} // end class
