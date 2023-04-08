package ds.proj4.streetmapping;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class MapGraphic extends JFrame {

	private int width = 600;
	private int height = 600;
	
	// 지도를 실제로 화면에 보여주기 위해선. 주어진 맵테이터의 
	// 최대 최소 lat, lng 값을 알아야 한다
	private Double minLat = null, maxLat = null;
	private Double minLng = null, maxLng = null;
	
	private double dotSize = 2.0;    // intersection dot 의 크기 (지름)
	
	Graph graph;  // 맵데이터
	
	public MapGraphic(Graph graph, String title) {
		// 맵데이터 연결
		this.graph = graph;
		
		// 맵의  min/max lat/lng 추출
		sizeMap();		
		
		add("Center", new MapCanvas());

		setTitle(title);
		setSize(width + 40, height + 80);  // 좌우폭 여분.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	
	/**
	 * 맵의 min/max lat/lng 추출
	 */
	public void sizeMap() {
		
		HashMap<String, IntersectionNode> hmap = graph.getHmapIntersection();
		
		IntersectionNode node;
		
		double latitude, longitude;
		
		// 최대 최소값 계산하기 전에 먼저 
		minLat = null; maxLat = null;
		minLng = null; maxLng = null;

		
		for(Map.Entry m : hmap.entrySet()) {
			node = (IntersectionNode)m.getValue();
			latitude = node.getLat();
			longitude = node.getLng();
			
			// lat, lng 의 최대 최소값
			if(minLat == null) {
				minLat = latitude;
				maxLat = latitude;
				minLng = longitude;
				maxLng = longitude;
			}else {
				if(latitude < minLat) minLat = latitude;
				if(maxLat < latitude) maxLat = latitude;
				if(longitude < minLng) minLng = longitude;
				if(maxLng < longitude) maxLng = longitude;
			}
		}// end for	
	}
	

	class MapCanvas extends Canvas {
		@Override
		public void paint(Graphics graphics) {
			Graphics2D g = (Graphics2D) graphics;
			
			// road 그리기
			{
				HashMap<String, RoadEdge> hmap = graph.getHmapRoad();
				
				RoadEdge edge;
				IntersectionNode node1;
				IntersectionNode node2;
				
				for(Map.Entry m : hmap.entrySet()) {
					edge = (RoadEdge)m.getValue();
					node1 = edge.getIntersection1();
					node2 = edge.getIntersection2();
					
					g.drawLine( (int)mapX(node1.getLng()), 
							(int)mapY(node1.getLat()), 
							(int)mapX(node2.getLng()), 
							(int)mapY(node2.getLat()));
				}
			} // end road 그리기
			
			// path 그리기
			{
				RoadEdge edge;
				IntersectionNode node1;
				IntersectionNode node2;
				
				ArrayList<IntersectionNode> path = graph.getPath();
				if(path != null && path.size() > 1) {
					for(int i = 1; i < path.size(); i++) {
						edge = path.get(i).getRoad();
						node1 = edge.getIntersection1();
						node2 = edge.getIntersection2();
						
						g.setColor(new Color(255, 0, 0));  // 경로 빨간색
						g.setStroke(new BasicStroke(3));   // 두께
						g.drawLine( (int)mapX(node1.getLng()), 
								(int)mapY(node1.getLat()), 
								(int)mapX(node2.getLng()), 
								(int)mapY(node2.getLat()));
					}
				}
			} // end path 그리기
			
		} // end paint()
	} // end class MapCanvas

	
	
	public double mapVal(double min, double max, double value, double span) {
		return (value - min) / (max - min) * span;
	}
	public double mapX(double longitude) {
		return mapVal(minLng, maxLng, longitude, width);
	}
	public double mapY(double latitude) {
		// latitude 의 증가값은  ↑ 이지만
		// 화면상의 y 좌표 증가값은 ↓ 이다
		return height - mapVal(minLat, maxLat, latitude, height);
	}

	// getter / setter
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public Double getMinLat() {return minLat;}
	public void setMinLat(Double minLat) {this.minLat = minLat;}
	public Double getMaxLat() {return maxLat;}
	public void setMaxLat(Double maxLat) {this.maxLat = maxLat;}
	public Double getMinLng() {return minLng;}
	public void setMinLng(Double minLng) {this.minLng = minLng;}
	public Double getMaxLng() {return maxLng;}
	public void setMaxLng(Double maxLng) {this.maxLng = maxLng;}
	public double getDotSize() {return dotSize;}
	public void setDotSize(double dotSize) {this.dotSize = dotSize;}
		
} // end class
