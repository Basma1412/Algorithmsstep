/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


/**
 *
 * @author taseneem 21
*/

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.image.impl.IntArgb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.spriteManager.*;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.*;
import java.util.Iterator;
import java.util.List;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
class GraphExplore {
  public SingleGraph graph;
 
    public GraphExplore() {
           graph = new SingleGraph("single resource");
graph.addAttribute("ui.stylesheet", styleSheet);

    System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        graph.setAutoCreate(true);
        graph.setStrict(false);
        graph.display();
    }
      
    public void SecondDraw(List<Edge> edges){
     for(int i=0; i<edges.size() ;i++){
             //  graph.addEdge("r"+requesting_resource[i][0]+"p"+i+"","r"+requesting_resource[i][0],"p"+i,true);
        //     for(int j=1;j<resource;j++){
          //              if(requesting_resource[i][j]!=0){
            //                if(requesting_resource[i][j]==-2){
              //                  continue;
   // } else{
        graph.addEdge(""+edges.get(i).getSource()+""+edges.get(i).getDestination(),""+edges.get(i).getSource(),""+edges.get(i).getDestination(),false);
                        //}
                        //}
                        
                       graph.getNode(""+edges.get(i).getDestination()).addAttribute("ui.class", "Pro");
                     //  graph.getNode(""+edges.get(i).getSource()).addAttribute("ui.class", "res");
                 //       graph.getEdge(""+edges.get(i).getWeight()).addAttribute("ui.class", "edge");

//}
     //}
     }
                 for (org.graphstream.graph.Node node : graph) {
           node.addAttribute("ui.label", node.getId());
        }
                 
                 
                      
           //     for (org.graphstream.graph.Edge edge : graph) {
          //edge.addAttribute("ui.label", edge.getId());
        //}

    }
         
         
public void draw(int [][]process,int [][]requesting_resource,int resource){
       
               graph.addEdge("P"+0+""+"R"+process[0][0],"R"+process[0][0],"P"+0,true);  
               
                        graph.getNode("R"+0).addAttribute("ui.class", "res");
                        graph.getNode("P"+0).addAttribute("ui.class", "pro");
         for(int i=0; i<process.length  ;i++){
      //            graph.addEdge("p"+i+""+"r"+process[i][0],"r"+process[i][0],"p"+i,true);
             for(int j=1;j<resource;j++){
                        if(process[i][j]!=0){
                            if (+process[i][j]==-2){
                            continue;
                            }
                            else{
                  graph.addEdge("P"+i+""+"R"+process[i][j],"R"+process[i][j],"P"+i,true);
            //    graph.addEdge("r"+requesting_resource[i][j]+"p"+i+"","r"+requesting_resource[i][j],"p"+i,true);
                }
                        }
                        graph.getNode("R"+process[i][j]).addAttribute("ui.class", "res");
                        graph.getNode("P"+i).addAttribute("ui.class", "pro");
             }
                 for (org.graphstream.graph.Node node : graph) {
           node.addAttribute("ui.label", node.getId());
          
       
        }
         
         }
          
      }

    public void explore(org.graphstream.graph.Node source) {
        Iterator<? extends org.graphstream.graph.Node> k = source.getBreadthFirstIterator();

        while (k.hasNext()) {
            org.graphstream.graph.Node next = k.next();
            next.setAttribute("ui.class", "marked");
            sleep();
        }
    }
    protected void sleep() {
        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    protected String styleSheet =
        "node.pro {" +
        "   fill-color: grey;" +
            "size: 70px;"+
            
        "}" +
        "node.res {" +
            " shape: box;"+
            "size: 70px;"+
        "   fill-color: grey;" +
        "}"
           ;
    
      
}
