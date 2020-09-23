package prim;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		bookGraph();
		//randomGraph();
	}
	
	public static void bookGraph(){
		
		Graph graph = new Graph(9);
		Edge[] edges = new Edge[14];
		
		edges[0] = new Edge(0,1,4);
		edges[1] = new Edge(0,7,8);
		edges[2] = new Edge(1,2,8);
		edges[3] = new Edge(1,7,11);
		edges[4] = new Edge(2,3,7);
		edges[5] = new Edge(2,5,4);
		edges[6] = new Edge(2,8,2);
		edges[7] = new Edge(3,4,9);
		edges[8] = new Edge(3,5,14);
		edges[9] = new Edge(4,5,10);
		edges[10] = new Edge(5,6,2);
		edges[11] = new Edge(6,7,1);
		edges[12] = new Edge(6,8,6);
		edges[13] = new Edge(7,8,7);
		
		for(int i = 0;i<14;i++){
			graph.insertEdge(edges[i]);
		}
		
		graph.bianli();
		graph.Prim();
	}
	
	public static void randomGraph(){
		Graph graph = new Graph(100);
		
		for(int i = 0;i<1000;){
			
			int preV = (int)(Math.random()*100);
            int folV = (int)(Math.random()*100);
            int weight = (int)(Math.random()*100+1);
            if(preV != folV){
            	Edge edge = new Edge(preV,folV,weight);
            	try{
            		graph.insertEdge(edge);
            		i++;
            	}catch(Exception e){
            		continue;
            	}
            }
		}
		
		graph.bianli();
		graph.Prim();
	}
 
}