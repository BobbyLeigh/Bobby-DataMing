package prim;
 
import java.util.*;
 
public class Graph {
 
	private int vNum;
	private int edgeNum;
	private LinkedList<Edge>[] edgeLinks;
	private LinkedList<Integer> TV;	
	private LinkedList<Edge> T;	
	
	public Graph(int vNum){
		this.vNum = vNum;
		this.edgeNum = 0;
		edgeLinks = new LinkedList[vNum];
		for(int i = 0;i<vNum;i++){
			edgeLinks[i] = new LinkedList<>();
		}
	}
	
	public void insertEdge(Edge edge){
		int v1 = edge.getV1();
		int v2 = edge.getV2();
		edgeLinks[v1].add(edge);
		Edge edge2 = new Edge(v2,v1,edge.getWeight());
		edgeLinks[v2].add(edge2);
		edgeNum++;
	}
	
	public void deleteEdge(Edge edge){
		int v1 = edge.getV1();
		int v2 = edge.getV2();
		Edge edge2 = new Edge(v2,v1,edge.getWeight());
		edgeLinks[v1].remove(edge);
		edgeLinks[v2].remove(edge2);
		edgeNum--;
	}
	
	public void bianli(){
		System.out.println(+vNum+" POINTS， "+edgeNum+" EDGES");
		for(int i = 0;i<vNum;i++){
			LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
			System.out.print(i+" : [");
			while(!list.isEmpty()){
				Edge edge = list.pop();
				System.out.print(edge.getV2()+"("+edge.getWeight()+")"+"  ");
			}
			System.out.println("]");
		}
	}
	

	public void Prim(){
		
		TV = new LinkedList<>();
		T = new LinkedList<>();
		TV.add(0);
		
		while(edgeNum>0 && T.size()!=vNum-1){
			Edge edge = getMinEdge(TV);
			if(edge==null)
				break;
			this.deleteEdge(edge);
			T.add(edge);
			TV.add(edge.getV2());
		}
		
		if(T.size()==vNum-1){
			System.out.println("YOU HAVE GOT A MST");
			LinkedList<Edge> list = (LinkedList<Edge>) T.clone();
			int sumWeight = 0;
			while(!list.isEmpty()){
				Edge edge = list.pop();
				sumWeight += edge.getWeight();
				System.out.println(edge.toString());
			}
			System.out.println("TOTAL WEIGHT IS： "+sumWeight);
		}else{
			System.out.println("NO MST");
		}
		
		
	}
	
	public Edge getMinEdge(LinkedList<Integer> t){
		
		Edge minEdge = new Edge(10000);
		LinkedList<Integer> tt = (LinkedList<Integer>) t.clone();
		
		while(!tt.isEmpty()){
			int i = tt.pop();
			LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
			while(!list.isEmpty()){
				Edge edge = list.pop();
				if(minEdge.getWeight()>edge.getWeight() && !t.contains(edge.getV2())){
					minEdge = edge;
				}
			}
		}		
 
		if(minEdge.getWeight()==10000)
			return null;
		return minEdge;
	}
	
}
